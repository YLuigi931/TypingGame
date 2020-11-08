package TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import Words.WordRecord;


class WordRecordTest {
	
	WordRecord steve = new WordRecord("LOTR", 5);
	
	@Test
	void ConstructorTest() {
		try {
			new WordRecord("AMONgUs", 0);
			fail();
		}catch(IllegalArgumentException e) { }
		try {
			new WordRecord("Metal Gear Solid", -1);
			fail();
		}catch(IllegalArgumentException e) { }
		try {
			new WordRecord("Batman", 2);
		}catch(IllegalArgumentException e) {fail();}
		try {
			new WordRecord(null, 5);
			fail();
		}catch(IllegalArgumentException e) { }
	}
	
	@Test
	void addWordTest() {
		assertEquals(5,steve.getSize());
		assertEquals(0,steve.countElements());
		steve.addWord(" Teen   ");
		assertEquals("teen", steve.word[0].getWord());
		assertEquals(5,steve.getSize());
		assertEquals(1,steve.countElements());
		steve.addWord("Boat ");
		assertEquals("boat", steve.word[1].getWord());
		assertEquals(5,steve.getSize());
		assertEquals(2,steve.countElements());
		steve.addWord(" Sponge   ");
		assertEquals("sponge", steve.word[2].getWord());
		assertEquals(7,steve.getSize());
		assertEquals(3,steve.countElements());
		steve.addWord("               TELEVISIOn");
		assertEquals("television", steve.word[3].getWord());
		assertEquals(10,steve.getSize());
		assertEquals(4,steve.countElements());
		steve.addWord(" NERF ");
		assertEquals("nerf", steve.word[4].getWord());
		assertEquals(10,steve.getSize());
		assertEquals(5,steve.countElements());
		steve.addWord("silver ");
		assertEquals("silver", steve.word[5].getWord());
		assertEquals(15,steve.getSize());
		assertEquals(6,steve.countElements());
		steve.addWord(" THE   ");
		assertEquals("the", steve.word[6].getWord());
		assertEquals(15,steve.getSize());
		assertEquals(7,steve.countElements());
		steve.addWord("google");
		assertEquals("google", steve.word[7].getWord());
		assertEquals(22,steve.getSize());
		assertEquals(8,steve.countElements());
	}

}
