package com.onepoint.game.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.onepoint.game.domain.player.Player;
import com.onepoint.game.exception.InvalidSequenceException;

class PlayerTest {

	@Test
	void test_playerRoll() throws InvalidSequenceException {
		Player player = new Player("Len");
		int result = player.roll(0, 10);
		System.out.println(result);
		assertTrue(result <= 10);
		result = player.roll(5, 12);
		System.out.println(result);
		assertTrue(result <= 12 && result >= 5);
	}

}
