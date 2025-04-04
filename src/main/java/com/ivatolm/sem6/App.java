package com.ivatolm.sem6;

import com.ivatolm.sem6.third.President;
import com.ivatolm.sem6.third.Boat;
import com.ivatolm.sem6.third.River;
import com.ivatolm.sem6.third.Vector3;

import java.util.List;
import java.util.Arrays;
import java.lang.Thread;

public class App {

	public static void main(String[] args) {
		River[] rivers = new River[] {
			new River(1, new Vector3(10, 10, 10), 25),
			new River(2, new Vector3(100, 10, 10), 250),
			new River(3, new Vector3(10, 100, 10), 500),
			new River(3, new Vector3(10, 10, 100), 1000),
		};
		List<River> riverList = Arrays.asList(rivers);

		President president = President.getInstance(4, new Vector3(0, 0, 0), riverList);
		Boat boat = new Boat(5, new Vector3(0, 5, 0), 42);
		president.mount(boat);

		while (true) {
			Vector3 difference = president.ride();
			Vector3 position = president.getPosition();
			System.out.println("position: " +
				position.getX() + ", " +
				position.getY() + ", " +
				position.getZ());

			try {
				Thread.sleep(100);
			} catch (java.lang.InterruptedException exception) {
				// ignore
			}
		}
	}

}
