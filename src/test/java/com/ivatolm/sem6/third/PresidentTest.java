package com.ivatolm.sem6.third;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PresidentTest {

    private President president;

    @BeforeEach
    void init() {
        this.president = President.getInstance(new Vector3(0, 0, 0));
    }

    @Test
    void testSingleton() {
        assertEquals(this.president, President.getInstance());
        assertEquals(this.president, President.getInstance(new Vector3(1, 0, 0)));
    }

    @Test
    void testSetPath() {
        this.president.setPath(new ArrayList<>());
        assertTrue(this.president.getPath().isEmpty());
        assertTrue(this.president.getPathPointer().isEmpty());
        River[] path = { new River("Tharvess Run", new Vector3(0, 0, 0), 10) };
        this.president.setPath(Arrays.asList(path));
        assertTrue(this.president.getPath().isPresent());
        assertTrue(this.president.getPathPointer().isPresent());
    }

}
