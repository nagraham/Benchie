package com.alexco.benchie;

public class Benchie {
	
	public static Benchmark run(Benchmarkable algorithm) {
		return new SimpleBenchmark(algorithm);
	}
	
	public static Benchmark run(String name, Benchmarkable algorithm) {
		return new SimpleBenchmark(name, algorithm);
	}

	public static BenchmarkComparison compare() {
		return null;
	}
}