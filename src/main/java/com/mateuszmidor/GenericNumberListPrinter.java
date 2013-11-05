package com.mateuszmidor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// zwyk³a liczba. Ma funkcjê "getAsString"
class Number {

	public double value;

	public Number(double value) {
		this.value = value;
	}

	public String getAsString() {
		return String.format("%.2f", value);
	}
}

// liczba z³o¿ona (rzeczywista + urojona). Te¿ ma funkcjê "getAsString"
class ComplexNumber extends Number {

	public double imaginated;

	public ComplexNumber(double value, double imaginated) {
		super(value);
		this.imaginated = imaginated;
	}

	
	@Override
	public String getAsString() {
		return String.format("%.2f%+.2fi", value, imaginated);
	}

}

public class GenericNumberListPrinter {

	// drukuje listê liczb
	// List<? extends Number> zamiast List<Number>, bo
	// List<ComplexNumber> nie jest potomkiem List<Number>  !!!
	// wiêc implementacja printList(List<Number>) nie przyjmie parametru typu List<ComplexNumber>
	public void printNumberList(List<? extends Number> list) {
		for (Number item : list)
			System.out.printf("%s ", item.getAsString());

		System.out.println();
	}

	public GenericNumberListPrinter() {
		System.out.println("Generic list printer:");

		
		List<Number> numberList = new ArrayList<>();
		numberList.add(new Number(1.95D));
		numberList.add(new Number(4.95));
		numberList.add(new Number(9.99));
		printNumberList(numberList);

		List<ComplexNumber> complexNumberList = new LinkedList<>();
		complexNumberList.add(new ComplexNumber(1, 2));
		complexNumberList.add(new ComplexNumber(7, -3));
		complexNumberList.add(new ComplexNumber(-4, 1));
		printNumberList(complexNumberList);

		System.out.println();
	}
}
