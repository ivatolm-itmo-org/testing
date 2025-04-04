package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class River {

	private Integer id;
	private Vector3 position;
	private double width;

	public River(Integer id, Vector3 position, double width) {
		this.id = id;
		this.position = position;
		this.width = width;
	}

}
