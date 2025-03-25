package com.ivatolm.sem6.third;

import java.util.Optional;

public class Human {

	private final Integer id;
	private final String name;

	private Optional<Transport> transport;

	public Human(Integer id, String name) {
		this.id = id;
		this.name = name;
		this.transport = Optional.empty();
	}

	public void mount(Transport transport) {
		this.transport = Optional.of(transport);
	}

	public void unmount() {
		this.transport = Optional.empty();
	}

	public void update() {
		if (this.transport.isPresent()) {
			System.out.println("Riding...");
		}
	}

}
