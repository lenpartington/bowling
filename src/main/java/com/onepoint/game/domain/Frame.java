package com.onepoint.game.domain;

public class Frame {
	public static final int MAX_PIN = 10;
	public static final int MIN_PIN = 0;
	private int currentPins;

	public Frame() {
		System.out.println("new Frame with 10 Pins");
		currentPins = 10;
	}

	public int getCurrentPins() {
		return currentPins;
	}

	public void setCurrentPins(int currentPins) {
		this.currentPins = currentPins;
	}

}
