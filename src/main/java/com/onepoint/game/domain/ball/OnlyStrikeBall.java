package com.onepoint.game.domain.ball;

public class OnlyStrikeBall implements Ball {

	@Override
	public int roll(int min, int max) {

		return 10;
	}

}
