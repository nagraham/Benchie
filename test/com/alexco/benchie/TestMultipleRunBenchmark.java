package com.alexco.benchie;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.isEmptyString;

import org.junit.Test;

import com.alexco.benchie.statistics.Statistics;

public class TestMultipleRunBenchmark {

	private final MultipleRunBenchmark mrb = new MultipleRunBenchmark(10, () -> {
		Utils.runGenericAlgorithm(100);
	});
	
	private final MultipleRunBenchmark mrbWithName = new MultipleRunBenchmark("Say my name", 10, () -> {
		Utils.runGenericAlgorithm(100);
	});
	
	@Test
	public void testConstructorAndGetTime() {
		assertThat(mrb.getTime(), greaterThan(0.0));
		assertThat(mrb.getTime(), lessThan(100.0));
		assertThat(mrb.getName(), isEmptyString());
	}
	
	@Test
	public void testConstructorWithNameAndGetTimeAndGetName() {
		assertThat(mrbWithName.getTime(), greaterThan(0.0));
		assertThat(mrbWithName.getTime(), lessThan(100.0));
		assertThat(mrbWithName.getName(), equalTo("Say my name"));
	}
	
	@Test
	public void testGetStatistics() {
		Statistics stats = mrb.getStatistics();
		
		// sanity test the stats
		assertThat(stats.mean(), greaterThan(0.0));
		assertThat(stats.mean(), lessThan(20.0));
		assertThat(stats.max(), greaterThan(0.0));
		assertThat(stats.max(), lessThan(20.0));
	}

}