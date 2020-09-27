package com.misc;

import java.util.HashMap;
import java.util.Map;

public class HashMapMethods {

	public static void main(String[] args) {

		addIfNotPresentElseAdd();
	}

	public static void addIfNotPresentElseAdd() {

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		System.out.println(map);

		map.merge("B", 1, (exisitingVal, passedVal) -> exisitingVal + passedVal);
		map.merge("C", 1, (exisitingVal, passedVal) -> exisitingVal + passedVal);
		map.merge("C", -1, (exisitingVal, passedVal) -> exisitingVal + passedVal);

		System.out.println(map);
	}

	public static void testComputeIfPresent() {

		Map<String, String> map = new HashMap<>();
		map.put("Name", "Parkash");
		map.put("Address", "Framingham");

		System.out.println("Map: " + map);

		map.computeIfPresent("Name", (key, value) -> value.concat(" Arjan"));

		System.out.println("Map: " + map);
	}

	public static void testComputeIfAbsent() {

		Map<String, String> map = new HashMap<>();
		map.put("Name", "Parkash");
		map.put("Address", "Framingham");

		System.out.println("Map: " + map);

		map.computeIfAbsent("Name", (key) -> ("Arjan"));

		System.out.println("Map: " + map);
	}

	public static void testCompute() {

		Map<String, String> map = new HashMap<>();
		map.put("Name", "Parkash");
		map.put("Address", "Framingham");

		System.out.println("Map: " + map);

		map.compute("Name", (key, val) -> val.concat(" Arjan"));

		System.out.println("Map: " + map);
	}
}
