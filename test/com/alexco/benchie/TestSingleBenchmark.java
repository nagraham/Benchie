package com.alexco.benchie;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSingleBenchmark {
	
	private final ByteArrayOutputStream output = new ByteArrayOutputStream(); 
	private final SingleBenchmark sb = new SingleBenchmark(() -> { Utils.runGenericAlgorithm(100); });
	private final SingleBenchmark sbWithName = new SingleBenchmark("Generic Algorithm", () -> {
		Utils.runGenericAlgorithm(100);
	});
	
	@Before
	public void setUpPrintStream() {
		System.setOut(new PrintStream(output));
	}
	
	@After
	public void cleanUpPrintStream() {
		System.setOut(null);
	}

	@Test
	public void testConstructorAndGetTime_genericAlgorithm() {
		assertThat(sb.getTime(), greaterThan(0.0));
		assertThat(sb.getTime(), lessThan(1000.0));
	}
	
	@Test
	public void testConstructorWithName_genericAlgorithm() {
		assertThat(sbWithName.getTime(), greaterThan(0.0));
		assertThat(sbWithName.getTime(), lessThan(1000.0));
		assertThat(sbWithName.getName(), equalTo("Generic Algorithm"));
	}
	
	@Test
	public void testToString() {
		assertThat(sb.toString(), equalTo(sb.getTime() + "ms"));
	}
	
	@Test
	public void testToStringWithName() {
		String expectedResult = sbWithName.getName() + ": " + sbWithName.getTime() + "ms";
		assertThat(sbWithName.toString(), equalTo(expectedResult));
	}
	
	@Test
	public void testPrint() {
		sb.print();
		assertThat(output.toString(), equalTo(sb.toString() + "\n"));
	}
	
	@Test
	public void testPrintWithName() {
		sbWithName.print();
		assertThat(output.toString(), equalTo(sbWithName.toString() + "\n"));
	}

}
