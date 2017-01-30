package com.alexco.benchie;

// NOTE: To create a different implementation of how benchmarks are run,
// (e.g. to implement concurrent benchmarks) you could simply create a
// child class off this class, and override "createTime"
public class SimpleBenchmark implements Benchmark {
	
	private final long time;
	private final String name;
	

	public SimpleBenchmark(Benchmarkable algorithm) {
		this.time = createTime(algorithm);
		this.name = "";
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
		StringBuilder sb = new StringBuilder();
		if (name.length() > 0) { 
			sb.append(name);
			sb.append(": ");
		}
		sb.append(getTime());
		sb.append("ms");
		return sb.toString();
	}
	
	private long createTime(Benchmarkable algorithm) {
		long startTime = System.nanoTime();
		algorithm.execute();
		return System.nanoTime() - startTime;
	}
}
