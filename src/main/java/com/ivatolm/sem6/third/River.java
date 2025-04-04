package com.ivatolm.sem6.third;

public class River {

	private Integer id;
	private Vector3 position;
	private double width;

	public River(Integer id, Vector3 position, double width) {
		this.id = id;
		this.position = position;
		this.width = width;
	}

	public Vector3 getPosition() {
		return this.position;
	}

	public double getWidth() {
		return this.width;
	}

}
