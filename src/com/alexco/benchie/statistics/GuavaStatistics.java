package com.alexco.benchie.statistics;

import java.util.List;

import com.google.common.math.Stats;

// Adapter class that wraps Guava's Stat class
public class GuavaStatistics implements Statistics {
	
	private List<Double> sample;
	private Stats stat;
	
	public GuavaStatistics(List<Double> sample) {
		this.sample = sample;
		this.stat = Stats.of(sample);
	}
	
	public long count() {
		return stat.count();
	}
	
	public double max() {
		return stat.max();
	}
	
	public double mean() {
		return stat.mean();
	}
	
	public double median() {
		int midpoint = sample.size() / 2;
		if (sample.size() % 2 == 0) {
			return (sample.get(midpoint) + sample.get(midpoint - 1)) / 2;
		} else {
			return sample.get(midpoint);
		}
	}
	
	public double min() {
		return stat.min();
	}
	
	public double stddev() {
		return -1.0;
	}
	
	public double sum() {
		return -1.0;
	}
	
	public double variance() {
		return -1.0;
	}
	
}
