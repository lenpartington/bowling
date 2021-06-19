package com.onepoint.game.domain.ball;

import com.onepoint.game.exception.InvalidSequenceException;

public interface Ball {
	public int roll(int min, int max) throws InvalidSequenceException;
}
