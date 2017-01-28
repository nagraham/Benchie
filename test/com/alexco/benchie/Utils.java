package com.alexco.benchie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utils {
	public static void runGenericAlgorithm(int n) {
		List<String> list = new ArrayList<String>(n);
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			list.add(String.valueOf(Character.toChars(rand.nextInt(255))));
		}
		Collections.sort(list);
	}
}
