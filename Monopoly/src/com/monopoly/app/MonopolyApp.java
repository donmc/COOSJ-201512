package com.monopoly.app;

import com.monopoly.MonopolyGame;
import com.monopoly.Player;

public class MonopolyApp {

	public static void main(String[] args) {
		MonopolyGame game = new MonopolyGame(4);
		System.out.println("Game Started with " + game.getNumPlayers() + " players.");
		for (int i = 1; i < 100; i++) {
			game.playRound();
			for (Player player : game.getPlayers()) {
				System.out.println(player.getToken() + " rolled " + player.getLastRoll() + " and landed on " + player.getLocation().getName() +
						"; " + player.getToken() + " now has balance of " + player.getBalance() +  ".");
			}
			System.out.println();
		}
		
	}

}
