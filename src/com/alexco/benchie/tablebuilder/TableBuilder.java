package com.alexco.benchie.tablebuilder;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TableBuilder {
	
	private final List<String> headers;
	private final List<List<String>> rows;
	private final List<Integer> maxColumnLengths;

	public TableBuilder() {
		this.headers = new ArrayList<String>();
		this.rows = new ArrayList<List<String>>();
		this.maxColumnLengths = new ArrayList<Integer>();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(rowToString(headers));
		for (List<String> row : rows) {
			sb.append(rowToString(row));
		}
		return sb.toString();
	}
	
	public void print() {
	}
	
	public TableBuilder addHeaders(String... strings) {
		for (String s : strings) {
			headers.add(s);
		}
		return this;
	}
	
	public TableBuilder setHeader(int col, String str) {
		if (col < headers.size()) {
			headers.set(col, str);
		} else {
			headers.add(col, str);
		}
		return this;
	}
	
	public TableBuilder addRow(String... strings) {
		List<String> newRow = new ArrayList<String>();
		for (String s : strings) {
			newRow.add(s);
		}
		rows.add(newRow);
		return this;
	}
	
	// ==============================================================
	//    PRIVATE
	// ==============================================================
	
	private String rowToString(List<String> row) {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		for (String cell : row) {
			f.format("| %s ", cell);
		}
		String result = f.toString();
		if (result.length() > 0) { result += "|\n"; }
		return result;
	}
	
}
