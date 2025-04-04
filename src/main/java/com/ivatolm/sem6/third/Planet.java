package com.ivatolm.sem6.third;

import lombok.Getter;
import lombok.Setter;

enum PlanetState {
	NORMAL,
	DYING
}

@Getter
@Setter
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
