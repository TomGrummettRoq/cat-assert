package com.credersi.animals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CatTest {
	
	@Test
	public void testInitialState() {
		Cat cat = new Cat();
		assertTrue(cat.isAlive());
		assertEquals(cat.howHungry(), 50);
	}

	@Test
	public void testFeedCat() {
		Cat cat = new Cat(); {
			cat.feeds();
		};
		assertEquals(cat.howHungry(), 30);
	}
	
	@Test
	public void testRunCat() {
		Cat cat = new Cat(); {
			cat.runs();
		};
		assertEquals(cat.howHungry(), 80);
	}
		
	@Test
	public void testRunFeedRun() {
		Cat cat = new Cat(); {
			cat.runs();
			cat.feeds();
			cat.runs();
		};
		assertEquals(cat.howHungry(), 90);
	}
	
	@Test
	public void testLowestLevel() {
		Cat cat = new Cat(); {
			cat.feeds();
			cat.feeds();
			cat.feeds();
		};
		assertTrue(cat.isAlive());
		assertEquals(cat.howHungry(), 0);
	}
	
	@Test
	public void testResurrection() {
		Cat cat = new Cat(); {
			cat.runs();
			cat.runs();
			cat.feeds();
		};
		assertEquals(cat.howHungry(), 90);
		assertTrue(!cat.isAlive());
	}
}

