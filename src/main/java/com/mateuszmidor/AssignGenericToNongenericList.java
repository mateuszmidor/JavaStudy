package com.mateuszmidor;

import java.util.List;

public class AssignGenericToNongenericList {

	// takie przypisanie jest mo¿liwe, ¿eby da³o siê w kodzie korzystaj¹cym z generyków
	// wspó³pracowaæ z kodem nie korzystaj¹cym z generyków
	// List list = List<String> jest ok
	// List<Object> list = list<String> ju¿ nie jest ok
	@SuppressWarnings("rawtypes")
	public List genericToNongeneric(List<String> list) {
		List result = list;
		return result;
	}
	
	// w drug¹ stronê te¿ siê da i te¿ bêdzie warning kompilatora
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> nongenericToGeneric(List list) {
		List<String> result = list;
		return result;
	}
	
	public AssignGenericToNongenericList() {
		System.out
				.println("Przypisywanie listy generycznej List<String> do listy niegenerycznej List ");
		System.out.println("Kompilator warninguje o przypisaniu bez sprawdzania typów");
		System.out.println();
	}
}
