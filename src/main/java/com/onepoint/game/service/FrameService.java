package com.onepoint.game.service;

import com.onepoint.game.domain.Frame;
import com.onepoint.game.domain.player.Player;
import com.onepoint.game.domain.roll.NormalRoll;
import com.onepoint.game.domain.roll.SpareRoll;
import com.onepoint.game.domain.roll.StrikeRoll;
import com.onepoint.game.exception.InvalidSequenceException;

public class FrameService {

	// private Frame frame;
	private int currentRoll;
	private ScoreService scoreService = new ScoreService();

	private void rollBall(Player player, Frame frame) throws InvalidSequenceException {
		int minusPins = player.roll(Frame.MIN_PIN, frame.getCurrentPins() + 1);
		System.out.println(player.getName() + " knocks down " + minusPins + " pins!");

		frame.setCurrentPins(frame.getCurrentPins() - minusPins);
		if (frame.getCurrentPins() == 0) {
			resolveAllKnockedDown(player);
		} else {
			player.getPlayerRolls().add(new NormalRoll(minusPins));
		}

		System.out.println("pins left =" + frame.getCurrentPins());

	}

	private void resolveAllKnockedDown(Player player) {
		if (currentRoll == 1) {
			System.out.println("Strike");
			player.getPlayerRolls().add(new StrikeRoll(10));
		} else {
			System.out.println("Spare");
			player.getPlayerRolls().add(new SpareRoll(10));
		}
	}

	public void playFrame(Player player) throws InvalidSequenceException {
		Frame frame = new Frame();
		currentRoll = 1;

		while (currentRoll <= 2 && frame.getCurrentPins() > 0) {
			resolveFrame(player, frame);
			currentRoll++;
		}

	}

	private void resolveFrame(Player player, Frame frame) throws InvalidSequenceException {
		System.out.println("\t player " + player.getName() + " roll " + currentRoll);
		rollBall(player, frame);
		System.out.println("\t " + player.getName() + " score is " + scoreService.getPlayerScore(player) + "!");

	}

	public void playLastFrame(Player player) throws InvalidSequenceException {
		Frame frame = new Frame();
		currentRoll = 1;

		while (currentRoll <= 2 && frame.getCurrentPins() > 0) {
			resolveFrame(player, frame);
			if (frame.getCurrentPins() == 0) {
				resolveBonusRoll(player, currentRoll);
			}
			currentRoll++;
		}

	}

	private void resolveBonusRoll(Player player, int current) throws InvalidSequenceException {
		if (current == 1) {
			System.out.println("get 2 bonus rolls for strike");
			playBonusStrikeFrame(player);
		}
		if (current == 2) {
			System.out.println("get 1 bonus roll for spare");
			playBonusSpareFrame(player);
		}
	}

	private void playBonusSpareFrame(Player player) throws InvalidSequenceException {
		Frame frame = new Frame();
		resolveFrame(player, frame);

	}

	private void playBonusStrikeFrame(Player player) throws InvalidSequenceException {
		Frame frame = new Frame();
		resolveFrame(player, frame);
		if (frame.getCurrentPins() == 0) {
			frame = new Frame();
		}
		resolveFrame(player, frame);
	}

}
