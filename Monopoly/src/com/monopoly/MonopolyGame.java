package com.monopoly;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class MonopolyGame {

	private List<Player> players;
	private Board board;

	public enum Token{Dog, Thimble, Iron, Battleship, Wheelbarrow, Pen, Shoe, Tophat, Car};
	public MonopolyGame(int maxPlayers) {
		if(maxPlayers > 8)
		{
			throw new IllegalArgumentException("Too many players!");
		}
		if(maxPlayers < 2)
		{
			throw new IllegalArgumentException("Too few players!");
		}

		board = new Board();
		
		players = new ArrayList<>();
		Iterator<Token> tokens = EnumSet.allOf(Token.class).iterator();
		for(int j = 0; j < maxPlayers && tokens.hasNext(); j++){
			players.add(new Player(board.getSquares().get(0), tokens.next()));
		}
	}

	public List<Square> getSquares() {
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		return players;
	}
}
