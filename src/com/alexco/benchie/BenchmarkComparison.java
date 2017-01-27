package com.alexco.benchie;

public interface BenchmarkComparison extends Benchmark {
	public BenchmarkComparison add();
	public Benchmark done();
	public BenchmarkComparison run();
}
