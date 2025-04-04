package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Human {

	protected final String name;
	protected Vector3 position;

	public Human(String name, Vector3 position) {
		this.name = name;
		this.position = position;
	}

}
