package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimplifyDirectoryPathTest {

	private SimplifyDirectoryPath solver;
	
	@Before
	public void setUp() throws Exception {
		solver = new SimplifyDirectoryPath();
	}

	@Test
	public void test01() {
		assertThat(solver.simplifyPath("/a/b/.."), equalTo("/a"));
	}
	
	@Test
	public void test02() {
		assertThat(solver.simplifyPath("/a/"), equalTo("/a"));
	}
	
	@Test
	public void test03() {
		assertThat(solver.simplifyPath("/a/b/"), equalTo("/a/b"));
	}
	
	@Test
	public void test04() {
		assertThat(solver.simplifyPath("/"), equalTo("/"));
	}
	
	@Test
	public void test05() {
		assertThat(solver.simplifyPath("/."), equalTo("/"));
	}
	
	@Test
	public void test06() {
		assertThat(solver.simplifyPath("/a/b/."), equalTo("/a/b"));
	}
	
	@Test
	public void test07() {
		assertThat(solver.simplifyPath("/home/"), equalTo("/home"));
	}
	
	@Test
	public void test08() {
		assertThat(solver.simplifyPath("/home//foo/"), equalTo("/home/foo"));
	}

}
