package com.onepoint.game.domain.player;

import java.util.ArrayList;
import java.util.List;

import com.onepoint.game.domain.ball.Ball;
import com.onepoint.game.domain.ball.NormalBall;
import com.onepoint.game.domain.roll.Roll;
import com.onepoint.game.exception.InvalidSequenceException;

public class Player {

	private int id;
	private String name;
	private int playerScore = 0;
	private Ball ball = new NormalBall();

	List<Roll> playerRolls = new ArrayList();

	public Player() {
		super();
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Roll> getPlayerRolls() {
		return playerRolls;
	}

	public void setPlayerRolls(List<Roll> playerRolls) {
		this.playerRolls = playerRolls;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public int roll(int min, int max) throws InvalidSequenceException {
		return ball.roll(min, max);

	}

}
