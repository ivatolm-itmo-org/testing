package com.ivatolm.sem6.third;

import java.util.Optional;
import java.util.Random;

public abstract class Human {

	private final Integer id;
	private final String name;

	protected Vector3 position;

	public Human(Integer id, String name, Vector3 position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}

	public Vector3 getPosition() {
		return this.position;
	}

}
