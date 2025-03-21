package com.ivatolm.sem6;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.lang.NullPointerException;

/**
 * Implementation of a HashMap with closed addressing.
 */
class HashMap<K, V> {
	class HashEntry {
		public K key;
		public V value;

		HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private ArrayList<List<HashEntry>> data;

	public HashMap() {
		this.data = new ArrayList<List<HashEntry>>();
		for (int i = 0; i < 128; i++) {
			this.data.add(new LinkedList<>());
		}
	}

	public void insert(K key, V value) throws NullPointerException {
		if (key == null || value == null) {
			throw new NullPointerException();
		}
		int index = getIndex(key);
		HashEntry entry = new HashEntry(key, value);
		this.data.get(index).add(entry);
	}

	public V remove(K key) throws NullPointerException {
		if (key == null) {
			throw new NullPointerException();
		}
		int index = getIndex(key);
		List<HashEntry> entries = this.data.get(index);
		for (var entry : entries) {
			if (entry.key == key) {
				entries.remove(entry);
				this.data.set(index, entries);
				return entry.value;
			}
		}
		return null;
	}

	public V get(K key) throws NullPointerException {
		if (key == null) {
			throw new NullPointerException();
		}
		int index = getIndex(key);
		List<HashEntry> entries = this.data.get(index);
		for (var entry : entries) {
			if (entry.key == key) {
				return entry.value;
			}
		}
		return null;
	}

	private int getIndex(Object object) {
		return object.hashCode() % this.data.size();
	}
}
