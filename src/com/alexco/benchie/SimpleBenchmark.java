package com.alexco.benchie;

public class SimpleBenchmark implements Benchmark {
	
	private final long time;
	private final String name;
	
	public SimpleBenchmark(Benchmarkable algorithm) {
		this.time = createTime(algorithm);
		this.name = null;
	}
	
	public SimpleBenchmark(String name, Benchmarkable algorithm) {
		this.time = createTime(algorithm);
		this.name = name;
	}

	public double getTime() {
		return (double) time / 1000000;
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public String toString() {
		return getTime() + "ms";
	}
	
	private long createTime(Benchmarkable algorithm) {
		long startTime = System.nanoTime();
		algorithm.execute();
		return System.nanoTime() - startTime;
	}
}
