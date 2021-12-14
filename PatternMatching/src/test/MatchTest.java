package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.Match;

class MatchTest {
	
	Match match;
	
	@Test
	void testDotAsterisk() {
		match = new Match("c.*t");
		assertEquals(2, match.findFirstIn("bacacacat"));
	}
	
	@Test
	void testAsteriskDotDot() {
		match = new Match("c*..");
		assertEquals(0, match.findFirstIn("cabt"));
	}
	
	@Test
	void testDotDotAsterisk() {
		match = new Match("c..*");
		assertEquals(1, match.findFirstIn("fcabt"));
	}
	
	@Test
	void testAsterisk() {
		match = new Match("c*tb");
		assertEquals(2, match.findFirstIn("bacatatb"));
	}
	
	@Test
	void testAsteriskDot() {
		match = new Match("c*.");
		assertEquals(0, match.findFirstIn("cat"));
	}
	
	@Test
	void testAsteriskStart() {
		match = new Match("*t");
		assertEquals(0, match.findFirstIn("bobcafft"));
	}
	
	@Test
	void testAsteriskMiddle() {
		match = new Match("c*t");
		assertEquals(3, match.findFirstIn("bobcat"));
	}
	
	@Test
	void testAsteriskEnd() {
		match = new Match("ca*");
		assertEquals(3, match.findFirstIn("bobcat"));
	}
	
	@Test
	void testAsteriskFail() {
		match = new Match("c*t");
		assertEquals(-1, match.findFirstIn("bobat"));
	}
	
	@Test
	void testDot() {
		match = new Match("a.t");
		assertEquals(0, match.findFirstIn("act"));
	}
	
	@Test
	void testDotStart() {
		match = new Match(".t");
		assertEquals(0, match.findFirstIn("at"));
	}
	
	@Test
	void testDotMiddle() {
		match = new Match("c.tb");
		assertEquals(2, match.findFirstIn("bacatb"));
	}
	
	@Test
	void testDotEnd() {
		match = new Match("b.");
		assertEquals(0, match.findFirstIn("bobcat"));
	}
	
	@Test
	void testDotFail() {
		match = new Match(".t");
		assertEquals(-1, match.findFirstIn("cacacat"));
	}
	
	@Test
	void testAlphabets() {
		match = new Match("cat");
		assertEquals(4, match.findFirstIn("cacacat"));
	}
	
	@Test
	void testAlphabetsFail() {
		match = new Match("bat");
		assertEquals(-1, match.findFirstIn("cacacat"));
	}
}
