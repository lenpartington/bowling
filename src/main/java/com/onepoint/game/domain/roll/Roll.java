package com.onepoint.game.domain.roll;

public abstract class Roll {

	private int pin;

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Roll(int pin) {
		super();
		this.pin = pin;
	}

}
