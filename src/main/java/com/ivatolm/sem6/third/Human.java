package com.ivatolm.sem6.third;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Human {

	protected final String name;
	protected Vector3 position;

	private Thread mind;
	private volatile boolean alive;

	public Human(String name, Vector3 position) {
		this.name = name;
		this.position = position;

		this.mind = new Thread(() -> mind());
		this.born();
	}

	public void born() {
		this.mind.start();
		this.alive = true;
	}

	public void die() {
		this.alive = false;
	}

	private void mind() {
		Random random = new Random();
		while (this.alive) {
			System.out.println("I am thinking...");

			try {
				Thread.sleep(random.nextInt(5000));
			} catch (java.lang.InterruptedException exception) {
				// ignore
			}
		}
	}

}
