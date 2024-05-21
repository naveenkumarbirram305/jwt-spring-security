package com.example.demo.ct.factorydesign;

public class Rectangle implements Shape {

	@Override
	public String draw() {
		System.out.println("Inside Rectangle::draw() method.");
		return "Inside Rectangle::draw() method.";
	}

}
