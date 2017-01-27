package com.alexco.benchie;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class TestSimpleBenchmark {

	@Test
	public void testConstructorAndGetTime_simpleAlgorithm() {
		Benchmark b = new SimpleBenchmark(() -> { runAlgorithm(100); });
		assertThat(b.getTime(), greaterThan(0.0));
		assertThat(b.getTime(), lessThan(1000.0));
	}
	
	@Test
	public void testToString() {
		Benchmark b = new SimpleBenchmark(() -> { runAlgorithm(100); });
		assertThat(b.toString(), equalTo(b.getTime() + "ms"));
	}
	
	private void runAlgorithm(int n) {
		List<String> list = new ArrayList<String>(n);
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			list.add(String.valueOf(Character.toChars(rand.nextInt(255))));
		}
		Collections.sort(list);
	}

}
