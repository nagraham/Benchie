package com.alexco.benchie.tablebuilder;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.stringContainsInOrder;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.hamcrest.core.IsInstanceOf;

public class TestTableBuilder {
	
	TableBuilder tb;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		tb = new TableBuilder();
	}
	
	@Test
	public void testSetHeader() {
		TableBuilder result = tb.setHeader(0, "foo");
		assertThat(tb, equalTo(result));
		assertThat(tb.toString(), equalTo("| foo |\n"));
		
		tb.setHeader(1, "foobar");
		tb.setHeader(2, "batzing!");
		assertThat(tb.toString(), equalTo("| foo | foobar | batzing! |\n"));
		
		tb.setHeader(0, "replaceFoo");
		assertThat(tb.toString(), equalTo("| replaceFoo | foobar | batzing! |\n"));
	}
	
	@Test
	public void testAddHeaders() {
		TableBuilder result = tb.addHeaders("foo", "foobar", "batzing!");
		assertThat(tb, equalTo(result));
		assertThat(tb.toString(), equalTo("| foo | foobar | batzing! |\n"));
	}
	
	@Test
	public void testSetHeader_settingBeyondSize() {
		exception.expect(IndexOutOfBoundsException.class);
		tb.setHeader(100, "foo");
	}
	
	@Test
	public void testSetHeader_negativeIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		tb.setHeader(-1, "foo");
	}
	
	@Test
	public void testAddRow_singleRow() {
		TableBuilder result = tb.addRow("foo", "foobar", "batzing!");
		assertThat(tb, equalTo(result));
		assertThat(tb.toString(), equalTo("| foo | foobar | batzing! |\n"));
	}
	
	@Test
	public void testAddRow_multipleRows() {
		tb.addRow("foo", "foobar", "batzing!");
		tb.addRow("A", "B", "C");
		System.out.println(tb);
		assertThat(tb.toString(), equalTo("| foo | foobar | batzing! |\n| A   | B      | C        |\n"));
	}

}
