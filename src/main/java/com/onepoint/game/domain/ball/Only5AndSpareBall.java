package com.onepoint.game.domain.ball;

public class Only5AndSpareBall implements Ball {

	@Override
	public int roll(int min, int max) {

		return 5;
	}

}
