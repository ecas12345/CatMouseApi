package com.eric.catMouseApi.tests;

import org.junit.Test;

import com.eric.catMouseApi.service.backend.CatMouseServiceImpl;

public class catMouseTest {

	CatMouseServiceImpl catMouse = new CatMouseServiceImpl();
	
	@Test
	public void runEscapedCases() {
		//Escaped Cases
		System.out.println(catMouse.isCaught(".D..C.....m..", 1)); //Leading dog, j less than, m > C (Escaped!)
		System.out.println(catMouse.isCaught(".C..m.....D..", 1)); //Trailing dog, j less than, m > C (Escaped!)
		System.out.println(catMouse.isCaught(".C.......m.", 1)); //No dog, j less than, m > C (Escaped!)
		System.out.println(catMouse.isCaught(".D..m.....C..", 1)); //Leading dog, j less than, m < C (Escaped!)
		System.out.println(catMouse.isCaught(".m..C.....D..", 1)); //Trailing dog, j less than, m < C (Escaped!)
		System.out.println(catMouse.isCaught(".m.......C.", 1)); //No dog, j less than, m < C (Escaped!)
		System.out.println(catMouse.isCaught("..............m...............................................C................................", 1)); //No dog, j less than, m < C, many dots (Escaped!)
		System.out.println(catMouse.isCaught(".........C..........................................................m.....................", 5)); //No dog, j less than, m > C, many dots (Escaped!)
		System.out.println(catMouse.isCaught(".......D......m...............................................C................................", 1)); //leading dog, j less than, m < C, many dots (Escaped!)
		System.out.println(catMouse.isCaught(".........C..........................................................m...D.................", 5)); //trailing dog, j less than, m > C, many dots (Escaped!)
		System.out.println(catMouse.isCaught(".C.D...m.", 3)); //dog between, j less than distance, c < m (Escaped!)
	}
	
	@Test
	public void runCaughtCases() {
		//Escaped Cases
		System.out.println(catMouse.isCaught(".C...m.", 3)); //no dog, j exact distance, c < m (Caught!)
		System.out.println(catMouse.isCaught(".C.....m.", 7)); //no dog, j greater than, c < m (Caught!)
		System.out.println(catMouse.isCaught("DC.....m.", 7)); //leading dog, j greater than, c < m (Caught!) 
		System.out.println(catMouse.isCaught(".C.....m....D", 19)); //trailing dog, j greater than, c < m (Caught!)
		System.out.println(catMouse.isCaught("....m...C....", 3)); //no dog, j exact distance, c > m (Caught!)
		System.out.println(catMouse.isCaught("....m..C.", 7)); //no dog, j greater than, c > m (Caught!)
		System.out.println(catMouse.isCaught("D.....m.....C......", 7)); //leading dog, j greater than, c > m (Caught!)
		System.out.println(catMouse.isCaught("....m........C....D", 19)); //trailing dog, j greater than, c < m (Caught!)
		System.out.println(catMouse.isCaught("..............m...............................................C................................", 10000)); //No dog, j greater than, m < C, many dots (Caught!)
		System.out.println(catMouse.isCaught(".........C..........................................................m.....................", 120040)); //No dog, j greater than, m > C, many dots (Caught!)
		System.out.println(catMouse.isCaught(".......D......m...............................................C................................", 100)); //leading dog, j greater than, m < C, many dots (Caught!)
		System.out.println(catMouse.isCaught(".........C..........................................................m...D.................", 459)); //trailing dog, j greater than, m > C, many dots (Caught!)
	}
	
	@Test
	public void runProtectedCases() {
		//Escaped Cases
		System.out.println(catMouse.isCaught(".C.D.m.", 3)); //dog between, j exact distance, c < m (Protected!)
		System.out.println(catMouse.isCaught(".C..D..m.", 7)); //dog between, j greater than, c < m (Protected!)	
	}
	
	@Test
	public void runBoringCases() {
		//Escaped Cases
		System.out.println(catMouse.isCaught("......", 3)); //Test for no animals (boring without all three)
	}
}
