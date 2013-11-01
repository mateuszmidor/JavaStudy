package com.mateuszmidor;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import com.google.common.base.Joiner;
import com.google.common.collect.ComparisonChain;

public class EchoSorted {
	private static class StringLengthComparator implements Comparator<String> {

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
		}

		@Override
		public int compare(String left, String right) {
			return ComparisonChain.start()
					.compare(left.length(), right.length()).result();
		}
	}

	private static void displayTokens(String[] args) {
		StringTokenizer st = new StringTokenizer(Joiner.on(" ").join(args), " ");

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void printErrorLn(List<String> stringList) {
		System.err.println(stringList);
	}

	/**
	 * @param argumetnArray
	 */
	public static void main(String[] argumetnArray) {
		assert argumetnArray.length > 0 : "musza byc podane parametry w linii komend";
		displayTokens(argumetnArray);

		// Map list;
		sort(argumetnArray, new StringLengthComparator());
		printErrorLn(asList(argumetnArray));
	}

}
