package com.alexco.benchie;

import com.alexco.benchie.statistics.Statistics;

public interface Benchmark {
	
	
	public String getName();
	public Statistics getStatistics();
	public double getTime();
	public void print();
}
