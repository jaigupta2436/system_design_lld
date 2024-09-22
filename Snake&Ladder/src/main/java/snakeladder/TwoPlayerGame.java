package snakeladder;

import java.util.HashMap;

import snakeladder.AbstractTwoPlayerGame;
import java.util.*;

public class TwoPlayerGame extends AbstractTwoPlayerGame {
	public int player1 = 0;
	public int player2 = 0;
	private boolean player1turn = true;



	private static HashMap<Integer, Integer> snake = new HashMap<Integer, Integer>();
	private static HashMap<Integer, Integer> ladder = new HashMap<Integer, Integer>();

	public void startGame() {
		this.snake = createBoard(snake);
		this.ladder = createBoard(ladder);
		Scanner sc = new Scanner(System.in);
		while (player1 != 100 || player2 != 100) {
			
			if (player1turn) {
				System.out.println("Player 1 turn, roll the dice, press Enter");
				String enterkey = sc.nextLine();
				if(!enterkey.equals("")) continue;
				int diceRes = rollDice();
				if(player1==0 && diceRes!=6) {
					System.out.println("You need a six to start");
					player1turn = false;
					continue;
				}
				else if(player1==0 && diceRes == 6) {
					System.out.println("HoooRay You Got 6!!!Rolling The Dice again to move");
					diceRes = rollDice();
				}
				player1 = (movePlayer(player1, diceRes, snake, ladder));
				System.out.println("Player1 is at : "+player1);
				player1turn = false;
			} else {
				System.out.println("Player 2 turn, roll the dice, press Enter");
				String enterkey = sc.nextLine();
				if(!enterkey.equals("")) continue;
				int diceRes = rollDice();
				if(player2==0 && diceRes!=6) {
					System.out.println("You need a six to start");
					player1turn = true;
					continue;
				}
				else if(player2==0 && diceRes == 6) {
					System.out.println("HoooRay You Got 6!!!!Rolling The Dice again to move");
					diceRes = rollDice();
				}
				player2 = (movePlayer(player2, diceRes, snake, ladder));
				System.out.println("Player2 is at : "+player2);
				player1turn = true;
			}
			
			if(player1==100) {
				System.out.println("WOOOOHOOOO Player1 win");
				break;
			}else if(player2==100) {
				System.out.println("WOOOOHOOOO Player2 win");
				break;
			}
		}
	}

}
