package com.ivatolm.sem6.third;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

public class BoatTest {

    private Boat boat;

    @BeforeEach
    void init() {
        this.boat = new Boat("Titanic", new Vector3(0, 0, 0), 1);
    }

    @Test
    void testBoatRideWhileNotStarted() {
        this.boat.setDestination(new Vector3(10, 10, 10));
        Vector3 difference = this.boat.ride();

        assertTrue(difference.equals(new Vector3(0, 0, 0)));
    }

    @Test
    void testBoatRideWhileStarted() {
        this.boat.setDestination(new Vector3(10, 10, 10));
        this.boat.start();
        Vector3 difference = this.boat.ride();

        assertTrue(difference.equals(new Vector3(9.422649730810374, 9.422649730810374, 9.422649730810374)));
    }

    @Test
    void testBoatStartStopStartBeforeRiding() {
        this.boat.setDestination(new Vector3(10, 10, 10));
        this.boat.start();
        this.boat.stop();
        this.boat.start();
        Vector3 difference = this.boat.ride();
        assertTrue(difference.equals(new Vector3(9.422649730810374, 9.422649730810374, 9.422649730810374)));
    }

}
