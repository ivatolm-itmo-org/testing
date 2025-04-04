package com.ivatolm.sem6.third;

public abstract class Transport implements Ridable {

	private Integer id;
	private TransportType type;

	protected Vector3 position;
	protected Vector3 velocity;
	protected Vector3 acceleration;

	protected Vector3 target;

	public Transport(Integer id, TransportType type, Vector3 position) {
		this.id = id;
		this.type = type;
		this.position = position;
		this.velocity = new Vector3(0, 0, 0);
		this.acceleration = new Vector3(0, 0, 0);
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

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public Vector3 getVelocity() {
		return this.position;
	}

}
