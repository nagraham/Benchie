package com.alexco.benchie;

import java.util.ArrayList;
import java.util.List;

import com.alexco.benchie.statistics.Statistics;

public class MultipleRunBenchmark implements Benchmark {
	
	final private String name;
	final private Statistics stats;
	
	public MultipleRunBenchmark(int numberOfRuns, Benchmarkable algorithm) {
		this("", numberOfRuns, algorithm);
	}
	
	public MultipleRunBenchmark(String name, int numberOfRuns, Benchmarkable algorithm) {
		this.name = name;
		List<Double> times = new ArrayList<>(numberOfRuns);
		for (int i = 0; i < numberOfRuns; i++) {
			times.add(convertNanoToMilli(createTime(algorithm)));
		}
		this.stats = Statistics.create(times);
	}

	/**
	 * @return The name of the benchmark.
	 */
	public String getName() {
		return name;
	}
	
	public Statistics getStatistics() {
		return stats;
	}
	
	/**
	 * @return The total time for all executions of the algorithm.
	 */
	public double getTime() {
		return stats.sum();
	}
	
	public void print() {}
	
	public String toString() {
		return null;
	}
	
	// ******************************************
	//    PRIVATE
	// ******************************************
	
	private double convertNanoToMilli(long nano) {
		return (double) nano / 1000000;
	}
	
	private long createTime(Benchmarkable algorithm) {
		long startTime = System.nanoTime();
		algorithm.execute();
		return System.nanoTime() - startTime;
	}
}
