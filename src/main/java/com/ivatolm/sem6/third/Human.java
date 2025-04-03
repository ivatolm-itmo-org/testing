package com.ivatolm.sem6.third;

import java.util.Optional;
import java.util.Random;

public abstract class Human {

	private final Integer id;
	private final String name;

	private Vector3 position;

	public Human(Integer id, String name, Vector3 position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}

}
