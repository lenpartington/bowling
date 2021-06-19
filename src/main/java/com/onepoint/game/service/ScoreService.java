package com.onepoint.game.service;

import java.util.List;

import com.onepoint.game.domain.player.Player;
import com.onepoint.game.domain.roll.Roll;
import com.onepoint.game.domain.roll.SpareRoll;
import com.onepoint.game.domain.roll.StrikeRoll;

public class ScoreService {

	public int getPlayerScore(Player player) {
		return calculatePlayerScore(player);

	}

	private int calculatePlayerScore(Player player) {
		player.setPlayerScore(0);
		List<Roll> rolls = player.getPlayerRolls();
		int playerScore = computePlayerRolls(rolls);
		player.setPlayerScore(playerScore);
		return player.getPlayerScore();
	}

	private int computePlayerRolls(List<Roll> rolls) {
		int playerScore = 0;
		for (Roll roll : rolls) {
			int rollScore = 0;
			if (roll.getClass() == StrikeRoll.class) {
				rollScore = resolveStrikeScore(rolls, rolls.indexOf(roll));
			} else if (roll.getClass() == SpareRoll.class) {
				rollScore = resolveSpareScore(rolls, rolls.indexOf(roll));
			} else {
				rollScore = roll.getPin();
			}
			playerScore += rollScore;

		}

		return playerScore;
	}

	private int resolveSpareScore(List<Roll> rolls, int rollIndex) {

		if (rollIndex <= rolls.size() - 2) {
			return 10 + rolls.get(rollIndex + 1).getPin();
		}
		return 0;
	}

	private int resolveStrikeScore(List<Roll> rolls, int rollIndex) {
		if (rollIndex <= rolls.size() - 3) {
			return 10 + rolls.get(rollIndex + 1).getPin() + rolls.get(rollIndex + 2).getPin();
		}
		return 0;
	}

}
