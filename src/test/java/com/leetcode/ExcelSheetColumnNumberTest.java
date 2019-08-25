package com.leetcode;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExcelSheetColumnNumberTest {

	private ExcelSheetColumnNumber solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new ExcelSheetColumnNumber();
	}

	@Test
	public void test01() {
		String title = "AZ";
		assertThat(solver.numberToTitle(solver.titleToNumber(title)), equalTo(title));
	}

}
