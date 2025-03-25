package com.ivatolm.sem6.second;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class HashMapTest {

	@Test
	void whenInsertingNullKey() {
		HashMap<Integer, String> map = new HashMap<>();
		try {
			map.insert(null, "Alice");
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	void whenInsertingNullValue() {
		HashMap<Integer, String> map = new HashMap<>();
		try {
			map.insert(1, null);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	void whenInsertingValid() {
		HashMap<Integer, String> map = new HashMap<>();
		map.insert(1, "Alice");
		assertTrue(true);
	}

	@Test
	void whenRemovingByNullKey() {
		HashMap<Integer, String> map = new HashMap<>();
		map.insert(1, "Alice");
		try {
			map.remove(null);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	void whenRemovingNonExistantKey() {
		HashMap<Integer, String> map = new HashMap<>();
		assertTrue(map.remove(2) == null);
	}

	@Test
	void whenRemovingExistantKey() {
		HashMap<Integer, String> map = new HashMap<>();
		map.insert(1, "Alice");
		assertTrue(map.remove(1) != null);
	}

	@Test
	void whenGettingByNullKey() {
		HashMap<Integer, String> map = new HashMap<>();
		try {
			map.get(null);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	void whenGettingNonExistantKey() {
		HashMap<Integer, String> map = new HashMap<>();
		assertTrue(map.get(1) == null);
	}

	@Test
	void whenGettingExistantKey() {
		HashMap<Integer, String> map = new HashMap<>();
		map.insert(1, "Alice");
		assertTrue(map.get(1) != null);
	}
}
