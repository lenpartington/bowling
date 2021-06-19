package com.onepoint.game;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.onepoint.game.exception.InvalidSequenceException;

class GameApplicationTest {

	@Test
	void testMain_onlyStrike() throws InvalidSequenceException {
		GameApplication gameApp = new GameApplication();
		String[] args = "X X X X X X X X X X X X".split(" ");
		System.out.println(Arrays.toString(args));
		assertDoesNotThrow(() -> gameApp.main(args));
	}

	@Test
	void testMain_onlyMiss() throws InvalidSequenceException {
		GameApplication gameApp = new GameApplication();
		String[] args = "-- -- -- -- -- -- -- -- -- --".split(" ");
		System.out.println(Arrays.toString(args));
		assertDoesNotThrow(() -> gameApp.main(args));
	}

	@Test
	void testMain_only9AndMiss() throws InvalidSequenceException {
		GameApplication gameApp = new GameApplication();
		String[] args = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-".split(" ");
		System.out.println(Arrays.toString(args));
		assertDoesNotThrow(() -> gameApp.main(args));
	}

	@Test
	void testMain_only5AndSpare() throws InvalidSequenceException {
		GameApplication gameApp = new GameApplication();
		String[] args = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5".split(" ");
		System.out.println(Arrays.toString(args));
		assertDoesNotThrow(() -> gameApp.main(args));
	}

}
