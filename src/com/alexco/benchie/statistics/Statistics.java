package com.alexco.benchie.statistics;

import java.util.List;

public interface Statistics {

	public long count();
	public double max();
	public double mean();
	public double median();
	public double min();
	public double stddev();
	public double sum();
	public double variance();
	
//	public static Statistic create(List<Double> set) {
//		return null;
//	}
	
}
