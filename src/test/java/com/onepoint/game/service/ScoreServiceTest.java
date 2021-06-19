package com.onepoint.game.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.onepoint.game.domain.player.Player;
import com.onepoint.game.domain.roll.NormalRoll;
import com.onepoint.game.domain.roll.Roll;
import com.onepoint.game.domain.roll.SpareRoll;
import com.onepoint.game.domain.roll.StrikeRoll;

class ScoreServiceTest {

	@Test
	void test_getPlayerScore_normal_rolls() {
		ScoreService service = new ScoreService();
		Player player = new Player("Len");
		List<Roll> rolls = player.getPlayerRolls();
		rolls.add(new NormalRoll(5));
		rolls.add(new NormalRoll(5));
		rolls.add(new NormalRoll(5));
		int score = service.getPlayerScore(player);
		assert score == 15;
	}

	@Test
	void test_getPlayerScore_spare_rolls_1() {
		ScoreService service = new ScoreService();
		Player player = new Player("Len");
		List<Roll> rolls = player.getPlayerRolls();
		rolls.add(new NormalRoll(5));
		rolls.add(new SpareRoll(5));
		rolls.add(new NormalRoll(5));
		int score = service.getPlayerScore(player);
		assertEquals(25, score);
	}

	@Test
	void test_getPlayerScore_strike_rolls_1() {
		ScoreService service = new ScoreService();
		Player player = new Player("Len");
		List<Roll> rolls = player.getPlayerRolls();
		rolls.add(new NormalRoll(5));
		rolls.add(new StrikeRoll(5));
		rolls.add(new NormalRoll(5));
		int score = service.getPlayerScore(player);
		assertEquals(10, score);
	}

	@Test
	void test_getPlayerScore_strike_rolls_2() {
		ScoreService service = new ScoreService();
		Player player = new Player("Len");
		List<Roll> rolls = player.getPlayerRolls();
		rolls.add(new StrikeRoll(5));
		rolls.add(new NormalRoll(5));
		rolls.add(new NormalRoll(5));
		int score = service.getPlayerScore(player);
		assertEquals(30, score);
	}

	@Test
	void test_getPlayerScore_spare_rolls_2() {
		ScoreService service = new ScoreService();
		Player player = new Player("Len");
		List<Roll> rolls = player.getPlayerRolls();
		rolls.add(new NormalRoll(5));
		rolls.add(new NormalRoll(5));
		rolls.add(new SpareRoll(5));
		int score = service.getPlayerScore(player);
		assertEquals(10, score);
	}

}
