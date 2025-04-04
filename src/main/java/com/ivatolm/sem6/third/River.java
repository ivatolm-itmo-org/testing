package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class River {

	private String name;
	private Vector3 position;
	private double width;

	public River(String name, Vector3 position, double width) {
		this.name = name;
		this.position = position;
		this.width = width;
	}

}
