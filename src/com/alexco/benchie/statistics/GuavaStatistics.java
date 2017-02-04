package com.alexco.benchie.statistics;

import java.util.ArrayList;
import java.util.Collections;
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
		ArrayList<Double> sortedSample = new ArrayList<>(sample);
		Collections.sort(sortedSample);
		int midpoint = sortedSample.size() / 2;
		if (sortedSample.size() % 2 == 0) {
			return (sortedSample.get(midpoint) + sortedSample.get(midpoint - 1)) / 2;
		} else {
			return sortedSample.get(midpoint);
		}
	}
	
	public double min() {
		return stat.min();
	}
	
	public List<Double> sample() {
		return sample;
	}
	
	public double stddev() {
		return stat.populationStandardDeviation();
	}
	
	public double sum() {
		return stat.sum();
	}
	
	public double variance() {
		return stat.populationVariance();
	}
	
}
