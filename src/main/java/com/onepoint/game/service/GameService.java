package com.onepoint.game.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.onepoint.game.domain.Game;
import com.onepoint.game.domain.player.Player;
import com.onepoint.game.exception.InvalidSequenceException;
import com.onepoint.game.util.SortByScore;

@Service
public class GameService {

	FrameService frameService = new FrameService();

	public Game startNewGame() {
		Game game = new Game();
		game.setId(ThreadLocalRandom.current().nextInt(1, 100 + 1));
		game.setCurrentTurn(0);
		System.out.println("Starting New Game!\n Game id :" + game.getId());
		return game;
	}

	public void addPlayer(Player player, Game game) {

		game.addPlayers(player);
		System.out.println("New Player added : " + player.getName());
	}

	public void playGame(Game game) throws InvalidSequenceException {
		System.out.println("Let's PLAY !");
		resolveTurn(game);
		System.out.println("end game");
		game.setFinished(true);
		showWinner(game);

	}

	private void resolveTurn(Game game) throws InvalidSequenceException {
		int currentTurn = game.getCurrentTurn();
		while (currentTurn < Game.TURN - 1) {
			currentTurn++;
			game.setCurrentTurn(currentTurn);
			playNormalTurn(currentTurn, game);

		}
		currentTurn++;
		game.setCurrentTurn(currentTurn);
		playLastTurn(currentTurn, game);
	}

	private void showWinner(Game game) {
		List<Player> players = new ArrayList<>(game.getPlayers());
		Collections.sort(players, new SortByScore());
		System.out.println("Winning player is " + players.get(0).getName());

	}

	private void playNormalTurn(int currentTurn, Game game) throws InvalidSequenceException {
		System.out.println("TURN " + currentTurn + " !");
		for (Player player : game.getPlayers()) {
			frameService.playFrame(player);

		}
	}

	private void playLastTurn(int currentTurn, Game game) throws InvalidSequenceException {
		System.out.println("LAST TURN " + currentTurn + " !");
		for (Player player : game.getPlayers()) {
			frameService.playLastFrame(player);

		}

	}
}
