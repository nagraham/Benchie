package com.alexco.benchie.statistics;

// Adapter class that wraps Guava's Stat class
public class GuavaStatistic implements Statistic {
	
	public GuavaStatistic() {}

	public long count() {
		return -1;
	}
	
	public double max() {
		return -1.0;
	}
	
	public double mean() {
		return -1.0;
	}
	
	public double min() {
		return -1.0;
	}
	
	public double stddev() {
		return -1.0;
	}
	
	public double variance() {
		return -1.0;
	}
	
}
