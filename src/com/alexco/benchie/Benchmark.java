package com.alexco.benchie;

public interface Benchmark {
	// public Statistics getStatistics
	
	public String getName();
	public double getTime();
	public void print();
}
