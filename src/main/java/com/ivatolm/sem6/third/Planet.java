package com.ivatolm.sem6.third;

enum PlanetState {
	NORMAL,
	DYING
}

public class Planet {

	private String name;
	private River[] rivers;
	private PlanetState state;

	public Planet(String name, River[] rivers, PlanetState state) {
		this.name = name;
		this.rivers = rivers;
		this.state = state;
	}

}
