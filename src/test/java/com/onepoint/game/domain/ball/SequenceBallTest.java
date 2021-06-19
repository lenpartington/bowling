package com.onepoint.game.domain.ball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.onepoint.game.exception.InvalidSequenceException;

class SequenceBallTest {

	@Test
	void test_validateSequence_throws() {
		assertThrow("");
		assertThrow("123");
		assertThrow("123z");
		assertThrow("123123123");
		assertThrow("1231231231231");
		assertThrow("/2 31 23 12 31 13 13 13 13 13 14");
		assertThrow("1X 31 23 12 31 13 13 13 13 14");
	}

	private void assertThrow(String seq) {
		String[] args = seq.split(" ");
		System.out.println(seq);
		assertThrows(InvalidSequenceException.class, () -> new SequenceBall(args));
	}

	@Test
	void test_validateSequence_dont_throws() {
		assertDontThrow("12 31 23 12 31 13 13 13 13 13");
		assertDontThrow("-- -- -- -- -- -- -- -- -- --");

		assertDontThrow("12 31 23 12 31 13 13 13 13 1/1");
		assertDontThrow("X X X X X X X X X X X X");
		assertDontThrow("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
		assertDontThrow("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
	}

	private void assertDontThrow(String seq) {
		System.out.println(seq);
		String[] args = seq.split(" ");
		assertDoesNotThrow(() -> new SequenceBall(args));
	}
}
