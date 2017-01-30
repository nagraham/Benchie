package com.alexco.benchie;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

public class TestBenchie {

	@Test
	public void testBasicRun() {
		Benchmark b = Benchie.run(() -> {
			Utils.runGenericAlgorithm(100);
		});
		
		assertThat(b.getTime(), greaterThan(0.0));
		assertThat(b.getTime(), lessThan(10.0));
	}
	
	@Test
	public void testBasicRunWithName() {
		Benchmark b = Benchie.run("Foo", ()-> {
			Utils.runGenericAlgorithm(100);
		});
		
		assertThat(b.getTime(), greaterThan(0.0));
		assertThat(b.getTime(), lessThan(10.0));
		assertThat(b.getName(), equalTo("Foo"));
	}

}
