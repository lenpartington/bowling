package com.onepoint.game.domain.ball;

import java.util.Arrays;
import java.util.List;

public class Only9AndMissBall implements Ball {
	int cursor = 0;
	List<Integer> scorePool = Arrays.asList(9, 0);

	@Override
	public int roll(int min, int max) {
		int result = scorePool.get(cursor);

		if (cursor == 1) {
			cursor = 0;
		} else {
			cursor++;
		}
		return result;
	}

}
