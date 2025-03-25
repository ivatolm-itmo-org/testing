package com.ivatolm.sem6.third;

enum PlanetState {
	NORMAL,
	DYING
}

public class Planet {

	private String name;
	private Island[] islands;
	private River[] rivers;
	private PlanetState state;

	public Planet(String name, Island[] islands, River[] rivers, PlanetState state) {
		this.name = name;
		this.islands = islands;
		this.rivers = rivers;
		this.state = state;
	}

}
