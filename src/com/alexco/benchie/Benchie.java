package com.alexco.benchie;

public class Benchie {
	
	public static Benchmark run(Benchmarkable algorithm) {
		return new SingleBenchmark(algorithm);
	}
	
	public static Benchmark run(String name, Benchmarkable algorithm) {
		return new SingleBenchmark(name, algorithm);
	}

	public static BenchmarkComparison compare() {
		return null;
	}
}