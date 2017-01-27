package com.alexco.benchie;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSimpleBenchmark {
	
	private final ByteArrayOutputStream output = new ByteArrayOutputStream(); 
	private final SimpleBenchmark sb = new SimpleBenchmark(() -> { runAlgorithm(100); });
	
	@Before
	public void setUpPrintStream() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void cleanUpPrintStream() {
		System.setOut(null);
	}

	@Test
	public void testConstructorAndGetTime_simpleAlgorithm() {
		assertThat(sb.getTime(), greaterThan(0.0));
		assertThat(sb.getTime(), lessThan(1000.0));
	}
	
	@Test
	public void testToString() {
		assertThat(sb.toString(), equalTo(sb.getTime() + "ms"));
	}
	
	@Test
	public void testPrint() {
		sb.print();
		assertThat(sb.toString() + "\n", equalTo(output.toString()));
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
