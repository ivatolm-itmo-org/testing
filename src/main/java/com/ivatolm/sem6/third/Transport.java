package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Transport implements Ridable {

	private String name;
	private TransportType type;

	protected Vector3 position;
	protected Vector3 velocity;
	protected Vector3 acceleration;

	protected Vector3 destination;

	public Transport(String name, TransportType type, Vector3 position) {
		this.name = name;
		this.type = type;
		this.position = position;
		this.velocity = new Vector3(0, 0, 0);
		this.acceleration = new Vector3(0, 0, 0);
	}

}
