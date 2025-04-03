package com.ivatolm.sem6.third;

public abstract class Transport implements Ridable {

	private Integer id;
	private TransportType type;

	private Vector3 position;
	private Vector3 velocity;

	private Vector3 target;

	public Transport(Integer id, TransportType type, Vector3 position, Vector3 velocity) {
		this.id = id;
		this.type = type;
		this.position = position;
		this.velocity = velocity;
	}

	@Override
	public void setDestination(Vector3 target) {
		this.target = target;
	}

	public Integer getId() {
		return this.id;
	}

	public TransportType getType() {
		return this.type;
	}

	public Vector3 getPosition() {
		return this.position;
	}

	public Vector3 getVelocity() {
		return this.position;
	}

}
