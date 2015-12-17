package com.monopoly;

import com.dicegame.Die;

public class Player implements PlayerInfo {

	private Square location;
	private Token token;
	private int money;
	private int rollValue;

	public Player(Token token, Square startSquare) {
		this.location = startSquare;
		this.token = token;
		this.money = 1500;
	}

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getLocation()
	 */
	@Override
	public Square getLocation() {
		return location;
	}

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getToken()
	 */
	@Override
	public Token getToken() {
		return token;
	}

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getMoney()
	 */
	@Override
	public int getMoney() {
		return money;
	}

	public void takeTurn(Die die1, Die die2) {
		this.rollValue = die1.roll() + die2.roll();
		move(rollValue);
	}

	private void move(int rollValue) {
		
		for (int i = 0; i < rollValue - 1; i++) {
			step();
			location.passOverBy(this);
		}
		step();
		location.landOnBy(this); 
	}

	private void step() {
		location = location.getNextSquare();
	}

	public void credit(int amount) {
		money += amount;
	}

	public void debit(int amount) { 
		money -= amount;
	}

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getLastRoll()
	 */
	@Override
	public int getLastRoll() {
		return rollValue;
	}

}
