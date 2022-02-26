package com.practice;



public class Singleton {

	public void demo() {
		System.out.println("demo");
	}
	public void sample() {
		System.out.println("sample");
	}
	private Singleton () {
		System.out.println("constructor executed");
	}

	public static Singleton objectsingleton() {
		Singleton singleton=new Singleton();
		return	singleton;
	}
}
