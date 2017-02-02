package com.alexco.benchie;

import java.util.ArrayList;
import java.util.List;

import com.alexco.benchie.statistics.Statistics;

// NOTE: To create a different implementation of how benchmarks are run,
// (e.g. to implement concurrent benchmarks) you could simply create a
// child class off this class, and override "createTime"
public class SingleBenchmark implements Benchmark {
	
	private final long time;
	private final String name;
	private final Statistics stats;
	
	public SingleBenchmark(Benchmarkable algorithm) {
		this.time = createTime(algorithm);
		this.name = "";
		this.stats = createStats();
	}
	
	public SingleBenchmark(String name, Benchmarkable algorithm) {
		this.time = createTime(algorithm);
		this.name = name;
		this.stats = createStats();
	}

	public double getTime() {
		return (double) time / 1000000;
	}
	
	public String getName() {
		return name;
	}
	
	public Statistics getStatistics() {
		return stats;
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
	
	private Statistics createStats() {
		List<Double> result = new ArrayList<>(1);
		result.add(getTime());
		return Statistics.create(result);
	}
}
