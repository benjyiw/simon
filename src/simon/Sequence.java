package simon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sequence {
	private List<Character> generatedSequence = new ArrayList<>();
	private List<Character> userGuessSequence = new ArrayList<>();
	private int score = 0;
	private char[] rgby = {'Y', 'B', 'R', 'G'};
	private Random rand = new Random();
	
	public List<Character> getSequence() {
		return generatedSequence;
	}
	
	public Sequence() {
		for(int i = 0; i < 4; i++) {
			generatedSequence.add(rgby[rand.nextInt(4)]);
		}
	}

	public boolean userInput(char input) {
		userGuessSequence.add(input);
		if(generatedSequence.get(userGuessSequence.size()-1) == userGuessSequence.get(userGuessSequence.size()-1)) {
			return true;
		} else { 	
		return false;
		}
	}
	
	public void addSequence() {
		generatedSequence.add(rgby[rand.nextInt(4)]);
	}
	
	public int getCurrentScore() {
		return score;
	}
	
	public char getSequenceChar(int n) {
		return generatedSequence.get(n);
	}
	
	public char getUserChar(int n) {
		return generatedSequence.get(n);
	}
	
	
	public List<Character> getUserGuessSequence() {
		return userGuessSequence;
	}

	public boolean turnOver() {
		if(generatedSequence.size() == userGuessSequence.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}
	}
	
}
