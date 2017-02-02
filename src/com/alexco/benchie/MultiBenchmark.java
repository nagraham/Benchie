package com.alexco.benchie;

import com.alexco.benchie.statistics.Statistics;

public class MultiBenchmark implements Benchmark {
	
	public MultiBenchmark(int numberOfRuns, Benchmarkable algorithm) {
		
	}
	
	public MultiBenchmark(String name, int numberOfRuns, Benchmarkable algorithm) {
		
	}

	public String getName() {
		return null;
	}
	
	public Statistics getStatistics() {
		return null;
	}
	
	public double getTime() {
		return -1.0;
	}
	
	public void print() {}
	
	public String toString() {
		return null;
	}
}
