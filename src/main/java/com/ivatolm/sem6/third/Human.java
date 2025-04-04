package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Human {

	private final Integer id;
	private final String name;

	protected Vector3 position;

	public Human(Integer id, String name, Vector3 position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}

}
