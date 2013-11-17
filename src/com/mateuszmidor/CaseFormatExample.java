package com.mateuszmidor;

import com.google.common.base.CaseFormat;

public class CaseFormatExample {
	public CaseFormatExample() {
		System.out
				.println("CaseFormat example.\nConstant name to variable name:");

		String text = "JAKAS_STALA_TYPOWO_DUZYMI_LITERAMI_NAZWANA";
		System.out.println(text);

		String transformed = CaseFormat.UPPER_UNDERSCORE.to(
				CaseFormat.LOWER_CAMEL, text);
		System.out.println(transformed);

		System.out.println();
	}
}
