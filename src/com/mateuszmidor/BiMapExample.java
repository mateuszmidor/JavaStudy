package com.mateuszmidor;

import com.google.common.collect.HashBiMap;


public class BiMapExample {
	public BiMapExample() {

		System.out.println("BiMap example.\nA dictionary:");
		HashBiMap<String, String> plEnDict = HashBiMap.create();
		plEnDict.put("drzewo", "tree");
		plEnDict.put("kamie�", "stone");
		
		System.out.println("S�ownik polsko-angielski:");
		System.out.println("drzewo - " + plEnDict.get("drzewo"));
		System.out.println("kamie� - " + plEnDict.get("kamie�"));

		System.out.println("S�ownik angielsk-polski:");
		System.out.println("stone - " + plEnDict.inverse().get("stone"));
		System.out.println("tree - " + plEnDict.inverse().get("tree"));
		
		System.out.println();
	}
}
