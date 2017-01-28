package com.alexco.benchie;

public class Benchie {
	
	public static Benchmark run(Benchmarkable algorithm) {
		return new SimpleBenchmark(algorithm);
	}
	
	public static BenchmarkComparison compare() {
		return null;
	}
}