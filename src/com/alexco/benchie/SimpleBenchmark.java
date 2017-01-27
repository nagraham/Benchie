package com.alexco.benchie;

public class SimpleBenchmark implements Benchmark {
	
	private final long time;
	
	public SimpleBenchmark(Benchmarkable algorithm) {
		long startTime = System.nanoTime();
		algorithm.execute();
		time = System.nanoTime() - startTime;
	}

	public double getTime() {
		return (double) time / 1000000;
	}
	
	public void print() {
		System.out.println("SimpleBenchmark!");
	}
	
	public String toString() {
		return getTime() + "ms";
	}
	
}
