package com.ivatolm.sem6.third;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PresidentBoatTest {


    private President president;
    private Boat boat;

    @BeforeEach
    void init() {
        this.president = President.getInstance(new Vector3(0, 0, 0));
        this.boat = new Boat("Titanic", new Vector3(0, 5, 0), 42);
    }

    @Test
    void testMount() {
        this.president.mount(this.boat);
        assertEquals(this.president.getPosition(), this.boat.getPosition());
        assertTrue(this.boat.isMotorStarted());
    }

    @Test
    void testUnmount() {
        this.president.mount(this.boat);
        this.president.unmount();
        assertTrue(this.president.getTransport().isEmpty());
    }

    @Test
    void testRide() {
        this.president.mount(this.boat);
        Vector3 difference = this.president.ride();

        assertEquals(difference, new Vector3(0, 0, 0));
    }

}
