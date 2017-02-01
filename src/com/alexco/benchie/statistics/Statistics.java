package com.alexco.benchie.statistics;

import java.util.List;

public interface Statistics {

	public long count();
	public double max();
	public double mean();
	public double median();
	public double min();
	public List<Double> sample();
	public double stddev();
	public double sum();
	public double variance();
	
	public static Statistics create(List<Double> sample) {
		return new GuavaStatistics(sample);
	}
	
}
