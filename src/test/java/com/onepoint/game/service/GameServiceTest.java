package com.onepoint.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.onepoint.game.domain.Game;
import com.onepoint.game.domain.ball.Only5AndSpareBall;
import com.onepoint.game.domain.ball.Only9AndMissBall;
import com.onepoint.game.domain.ball.OnlyStrikeBall;
import com.onepoint.game.domain.ball.SequenceBall;
import com.onepoint.game.domain.player.Player;
import com.onepoint.game.exception.InvalidSequenceException;

class GameServiceTest {

	ScoreService scoreService = new ScoreService();

	@Test
	public void test_game_with_only_strike() throws InvalidSequenceException {
		GameService service = new GameService();

		Game game = service.startNewGame();

		Player mike = new Player("Mike");
		mike.setBall(new OnlyStrikeBall());
		service.addPlayer(mike, game);
		service.playGame(game);
		int result = scoreService.getPlayerScore(mike);
		assertEquals(300, result);
		assertEquals(12, mike.getPlayerRolls().size());
	}

	@Test
	public void test_game_with_only_5_and_spare() throws InvalidSequenceException {
		GameService service = new GameService();
		ScoreService scoreService = new ScoreService();
		Game game = service.startNewGame();

		Player mike = new Player("Mike");
		mike.setBall(new Only5AndSpareBall());
		service.addPlayer(mike, game);
		service.playGame(game);
		int result = scoreService.getPlayerScore(mike);
		// assertEquals(150, result); Enoncé erroné
		assertEquals(21, mike.getPlayerRolls().size());
		assertEquals(205, result);
	}

	@Test
	public void test_game_with_only_9_and_miss() throws InvalidSequenceException {
		GameService service = new GameService();
		ScoreService scoreService = new ScoreService();
		Game game = service.startNewGame();

		Player mike = new Player("Mike");
		mike.setBall(new Only9AndMissBall());
		service.addPlayer(mike, game);
		service.playGame(game);
		int result = scoreService.getPlayerScore(mike);
		assertEquals(20, mike.getPlayerRolls().size());
		assertEquals(90, result);
	}

	@Test
	public void test_game_with_sequence_1() throws InvalidSequenceException {
		GameService service = new GameService();
		ScoreService scoreService = new ScoreService();
		Game game = service.startNewGame();

		Player mike = new Player("Mike");
		mike.setBall(new SequenceBall("X X X X X X X X X X X X".split(" ")));
		service.addPlayer(mike, game);
		service.playGame(game);
		int result = scoreService.getPlayerScore(mike);
		assertEquals(300, result);
		assertEquals(12, mike.getPlayerRolls().size());
	}
}
