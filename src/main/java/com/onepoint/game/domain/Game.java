package com.onepoint.game.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import com.onepoint.game.domain.player.Player;

public class Game {

	public static final int TURN = 10;
	private int id;
	private Set<Player> players = new LinkedHashSet<>();
	private int currentTurn;
	boolean isFinished = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void addPlayers(Player player) {
		this.players.add(player);
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public int getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}

}
