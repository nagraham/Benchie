package com.alexco.benchie.tablebuilder;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TableBuilder {
	
	private final List<String> headers;

	public TableBuilder() {
		this.headers = new ArrayList<String>();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(rowToString(headers));
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
	
	public TableBuilder addRow(int row, String... strings) {
	
		return null;
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
		f.format("|\n");
		return f.toString();
	}
	
}
