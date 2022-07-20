package com.eric.catMouseApi.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eric.catMouseApi.service.backend.CatMouseServiceImpl;

public class catMouseTest {

	CatMouseServiceImpl catMouse = new CatMouseServiceImpl();
	
	@Test
	public void runEscapedCases() {
		//Escaped Cases
		String escapedText = "Escaped!";
		System.out.println("Executing Escaped! cases");
		//m > c
		assertEquals(escapedText, catMouse.isCaught(".D..C.....m..", 1)); //Leading dog, j less than
		assertEquals(escapedText, catMouse.isCaught(".C..m.....D..", 1)); //Trailing dog, j less than
		assertEquals(escapedText, catMouse.isCaught(".C.......m.", 1)); //No dog, j less than
		assertEquals(escapedText, catMouse.isCaught(".........C..........................................................m.....................", 5)); //No dog, j less than, many dots
		assertEquals(escapedText, catMouse.isCaught("....D....C..........................................................m.....................", 9)); //leading dog, j less than, many dots 
		assertEquals(escapedText, catMouse.isCaught("........C..........................................................m............D........", 7)); //trailing dog, j less than, many dots
		assertEquals(escapedText, catMouse.isCaught(".C.......D...m.", 3)); //dog between, j less than distance
		//c > m
		assertEquals(escapedText, catMouse.isCaught(".D..m.....C..", 1)); //Leading dog, j less than
		assertEquals(escapedText, catMouse.isCaught(".m.....C.....D..", 1)); //Trailing dog, j less than
		assertEquals(escapedText, catMouse.isCaught(".m.......C.", 1)); //No dog, j less than
		assertEquals(escapedText, catMouse.isCaught(".........m..........................................................C.....................", 5)); //No dog, j less than, many dots
		assertEquals(escapedText, catMouse.isCaught("....D....m..........................................................C.....................", 9)); //leading dog, j less than, many dots 
		assertEquals(escapedText, catMouse.isCaught("........m..........................................................C............D........", 7)); //trailing dog, j less than, many dots
		assertEquals(escapedText, catMouse.isCaught(".m....D.......C.", 5)); //dog between, j less than distance
	}
	
	@Test
	public void runCaughtCases() {
		//Caught Cases
		String caughtText = "Caught!";
		System.out.println("Executing Caught! cases");
		//m > c
		assertEquals(caughtText, catMouse.isCaught(".C...m.", 3)); //no dog, j exact distance  
		assertEquals(caughtText, catMouse.isCaught(".C.....m.", 7)); //no dog, j greater than
		assertEquals(caughtText, catMouse.isCaught("DC.....m.", 7)); //leading dog, j greater than 
		assertEquals(caughtText, catMouse.isCaught("DC.......m.", 7)); //leading dog, j exact distance
		assertEquals(caughtText, catMouse.isCaught(".C.....m....D", 19)); //trailing dog, j greater than  
		assertEquals(caughtText, catMouse.isCaught("D.C.....m....", 5)); //leading dog, j greater than
		assertEquals(caughtText, catMouse.isCaught(".........C..........................................................m.....................", 120040)); //No dog, j greater than, many dots
		assertEquals(caughtText, catMouse.isCaught(".........C...........................................................m.....................", 59)); //No dog, j exact distance, many dots 
		assertEquals(caughtText, catMouse.isCaught("..D.....C..........................................................m.....................", 120040)); //leading dog, j greater than, many dots
		assertEquals(caughtText, catMouse.isCaught(".....D..C...........................................................m.....................", 59)); //leading dog, j exact distance, many dots 
		assertEquals(caughtText, catMouse.isCaught("........C..........................................................m..........D..........", 120040)); //trailing dog, j greater than, many dots
		assertEquals(caughtText, catMouse.isCaught("........C...........................................................m...........D.........", 59)); //trailing dog, j exact distance, many dots
		assertEquals(caughtText, catMouse.isCaught("Cm", 3)); //no dog, j greater than distance, no dots
		assertEquals(caughtText, catMouse.isCaught("Cm", 0)); //no dog, j exact distance, no dots
		assertEquals(caughtText, catMouse.isCaught("DCm", 0)); //leading dog, j equal to distance, no dots
		assertEquals(caughtText, catMouse.isCaught("CmD", 0)); //trailing dog, j equal to distance, no dots
		assertEquals(caughtText, catMouse.isCaught("DCm", 12)); //leading dog, j greater than distance, no dots
		assertEquals(caughtText, catMouse.isCaught("CmD", 3)); //trailing dog, j greater than distance, no dots
		//c > m
		assertEquals(caughtText, catMouse.isCaught("....m...C....", 3)); //no dog, j exact distance 
		assertEquals(caughtText, catMouse.isCaught("....m..C.", 7)); //no dog, j greater than 
		assertEquals(caughtText, catMouse.isCaught("D.....m.....C......", 7)); //leading dog, j greater than
		assertEquals(caughtText, catMouse.isCaught("D.....m.......C......", 7)); //leading dog, j exact distance
		assertEquals(caughtText, catMouse.isCaught(".....m.....C......D", 7)); //trailing dog, j greater than
		assertEquals(caughtText, catMouse.isCaught(".....m.......C....D..", 7)); //trailing dog, j exact distance
		assertEquals(caughtText, catMouse.isCaught(".........m.........................................................C.....................", 120040)); //No dog, j greater than, many dots
		assertEquals(caughtText, catMouse.isCaught(".........m...........................................................C.....................", 59)); //No dog, j exact distance, many dots 
		assertEquals(caughtText, catMouse.isCaught("..D.....m..........................................................C.....................", 120040)); //leading dog, j greater than, many dots
		assertEquals(caughtText, catMouse.isCaught(".....D..m...........................................................C.....................", 59)); //leading dog, j exact distance, many dots 
		assertEquals(caughtText, catMouse.isCaught("........m..........................................................C..........D..........", 120040)); //trailing dog, j greater than, many dots
		assertEquals(caughtText, catMouse.isCaught("........m...........................................................C...........D.........", 59)); //trailing dog, j exact distance, many dots
		assertEquals(caughtText, catMouse.isCaught("mC", 3)); //no dog, j greater than distance, no dots
		assertEquals(caughtText, catMouse.isCaught("mC", 0)); //no dog, j exact distance, no dots
		assertEquals(caughtText, catMouse.isCaught("DmC", 0)); //leading dog, j equal to distance, no dots
		assertEquals(caughtText, catMouse.isCaught("mCD", 0)); //trailing dog, j equal to distance, no dots
		assertEquals(caughtText, catMouse.isCaught("DmC", 12)); //leading dog, j greater than distance, no dots
		assertEquals(caughtText, catMouse.isCaught("mCD", 3)); //trailing dog, j greater than distance, no dots
	}
	
	@Test
	public void runProtectedCases() {
		//Protected Cases
		String protectedText = "Protected!";
		System.out.println("Executing Protected! cases");
		//c < m
		assertEquals(protectedText, catMouse.isCaught(".C.D.m.", 3)); //dog between, j exact distance
		assertEquals(protectedText, catMouse.isCaught(".C..D..m.", 7)); //dog between, j greater than 	
		assertEquals(protectedText, catMouse.isCaught("CDm", 4)); //dog between, j greater than distance, no dots
		assertEquals(protectedText, catMouse.isCaught("CDm", 1)); //dog between, j exact distance to mouse, no dots
		assertEquals(protectedText, catMouse.isCaught("CDm", 0)); //dog between, j exact distance to dog, no dots
		assertEquals(protectedText, catMouse.isCaught("C.....................D............................................................m........", 1000)); //dog, j greater than distance, many dots
		assertEquals(protectedText, catMouse.isCaught("C.....................D............................................................m........", 82)); //dog, j exact distance to mouse, many dots
		assertEquals(protectedText, catMouse.isCaught("C.....................D............................................................m........", 21)); //dog, j exact distance to dog, many dots
		
		//m < c
		assertEquals(protectedText, catMouse.isCaught(".m.D...C.", 5)); //dog between, j exact distance
		assertEquals(protectedText, catMouse.isCaught(".m..D..C.", 7)); //dog between, j greater than 	
		assertEquals(protectedText, catMouse.isCaught("mDC", 4)); //dog between, j greater than distance, no dots
		assertEquals(protectedText, catMouse.isCaught("mDC", 1)); //dog between, j exact distance to mouse, no dots
		assertEquals(protectedText, catMouse.isCaught("mDC", 0)); //dog between, j exact distance to dog, no dots
		assertEquals(protectedText, catMouse.isCaught("m.....................D............................................................C........", 1000)); //dog, j greater than distance, many dots
		assertEquals(protectedText, catMouse.isCaught("m.....................D............................................................C........", 82)); //dog, j exact distance to mouse, many dots
		assertEquals(protectedText, catMouse.isCaught("m.....................D............................................................C........", 60)); //dog, j exact distance to dog, many dots
	}
	
	@Test
	public void runBoringCases() {
		//Boring Cases
		String boringText = "boring without all three";
		System.out.println("Executing boring cases");
		assertEquals(boringText, catMouse.isCaught("......", 3)); //Test for no animals, more dots than j
		assertEquals(boringText, catMouse.isCaught("...", 3)); //Test for no animals, j and dots are equal
		assertEquals(boringText, catMouse.isCaught(".", 3)); //Test for no animals, j is greater than dots
		assertEquals(boringText, catMouse.isCaught("............................................................", 10)); //Test for no animals, many dots
		assertEquals(boringText, catMouse.isCaught("", 0)); //Test for no animals, no dots
		assertEquals(boringText, catMouse.isCaught("", 10)); //Test for no animals, no dots, j greater than dots
	}
}
