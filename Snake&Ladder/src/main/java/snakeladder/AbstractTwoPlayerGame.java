package snakeladder;
import java.util.HashMap;

public abstract class AbstractTwoPlayerGame {
	// This is an abstract class which means we dont need an obj of this
	// One class level variable for the turn of player
	
	
	//Getter and setter for player vals
	
	//Lets generate ladder and snake first
	public HashMap createBoard(HashMap map) {
		int cnt = 6;
		for(int i = 0; i<cnt; i++) {
			map.put(((int)(Math.random()*98) + 1),((int)(Math.random()*6) + 5));
		}
		return map;
	}
	
	//Now roll dice function
	public int rollDice() {
		int res = (int)(Math.random()*6) + 1;
		System.out.println("The val of dice is : "+res);
		return res;
	}
	
	public int movePlayer(int playerScore, int diceRes, HashMap<Integer,Integer> snake, HashMap<Integer,Integer> ladder) {
		int temp1 = playerScore;
		playerScore = playerScore+diceRes;
		if(playerScore>100) {
			System.out.println("You need exact "+(100-temp1)+" to win");
			return temp1;
		}
		if(snake.containsKey(playerScore)) {
			System.out.println("OOOOPsiieee Snake Bit you");
			playerScore = playerScore-snake.get(playerScore);
			if(playerScore<0) playerScore = 0;
		}
		if(ladder.containsKey(playerScore)) {
			int temp = playerScore;
			playerScore = playerScore + ladder.get(playerScore);
			System.out.println("Hurray You got a ladder");
			if(playerScore>100) playerScore =  playerScore - ladder.get(temp);
		}
		return playerScore;
	}
	//Size of the baord is 100;
	// maps honge jisme size store krenge of snake and ladder and end , start point rkhegnge
}
