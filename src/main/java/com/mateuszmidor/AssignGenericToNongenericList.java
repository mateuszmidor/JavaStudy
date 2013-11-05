package com.mateuszmidor;

import java.util.List;

public class AssignGenericToNongenericList {

	// takie przypisanie jest mo�liwe, �eby da�o si� w kodzie korzystaj�cym z generyk�w
	// wsp�pracowa� z kodem nie korzystaj�cym z generyk�w
	// List list = List<String> jest ok
	// List<Object> list = list<String> ju� nie jest ok
	@SuppressWarnings("rawtypes")
	public List genericToNongeneric(List<String> list) {
		List result = list;
		return result;
	}
	
	// w drug� stron� te� si� da i te� b�dzie warning kompilatora
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> nongenericToGeneric(List list) {
		List<String> result = list;
		return result;
	}
	
	public AssignGenericToNongenericList() {
		System.out
				.println("Przypisywanie listy generycznej List<String> do listy niegenerycznej List ");
		System.out.println("Kompilator warninguje o przypisaniu bez sprawdzania typ�w");
		System.out.println();
	}
}
