package com.ivatolm.sem6.third;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    // Integration test
    @Test
    void testPresidentBoatInteraction() {
        President president = President.getInstance(new Vector3(0, 0, 0));
		Boat boat = new Boat("Titanic", new Vector3(0, 5, 0), 42);
		president.mount(boat);
        Vector3 difference = president.ride();

        assertTrue(difference.equals(new Vector3(0, 0, 0)));
    }

}
