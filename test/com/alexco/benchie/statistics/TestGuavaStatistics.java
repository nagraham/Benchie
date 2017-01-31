package com.alexco.benchie.statistics;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestGuavaStatistics {

	// sum: 143
	List<Double> doubleSampleSet = new ArrayList<>(
		Arrays.asList(new Double[] { 1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0, 34.0, 55.0 })
	);
	
	GuavaStatistics gs = new GuavaStatistics(doubleSampleSet);
	
	@Test
	public void testCount() {
		assertThat(gs.count(), equalTo(10L));
	}
	
	@Test
	public void testMax() {
		assertThat(gs.max(), equalTo(55.0));
	}

	@Test
	public void testMean() {
		assertThat(gs.mean(), equalTo(14.3));
	}
	
	@Test
	public void testMedian_WithEvenSampleSize() {
		assertThat(gs.median(), equalTo((5.0 + 8.0) / 2));
	}
	
	@Test
	public void testMedian_WithOddSampleSize() {
		doubleSampleSet.add(89.0);
		GuavaStatistics gsOdd = new GuavaStatistics(doubleSampleSet);
		assertThat(gsOdd.median(), equalTo(8.0));
	}
	
	@Test
	public void testMin() {
		assertThat(gs.min(), equalTo(1.0));
	}
	
}
