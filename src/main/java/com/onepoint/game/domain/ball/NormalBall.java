package com.onepoint.game.domain.ball;

import java.util.concurrent.ThreadLocalRandom;

public class NormalBall implements Ball {

	@Override
	public int roll(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
