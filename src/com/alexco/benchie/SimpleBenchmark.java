package com.alexco.benchie;

public class SimpleBenchmark implements Benchmark {
	
	public SimpleBenchmark() {}

	public int getTime() {
		return -1;
	}
	
	public void print() {
		System.out.println("SimpleBenchmark!");
	}
	
}
