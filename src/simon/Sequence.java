package simon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sequence {
	public static List<Character> generatedSequence = new ArrayList<>();
	public static List<Character> userGuessSequence = new ArrayList<>();
	public int score = 0;
	public static char[] rgby = {'Y', 'B', 'R', 'G'};
	public static Random rand = new Random();

	public static List<Character> getSequence() {
		generatedSequence.clear();
		for(int i = 0; i < 4; i++) {
			generatedSequence.add(rgby[rand.nextInt(3)]);
		}
		return generatedSequence;
	}

	public boolean userInput(char input) {
		userGuessSequence.add(input);
		if(generatedSequence.get(userGuessSequence.size()-1) == userGuessSequence.get(userGuessSequence.size()-1)) {
			return true;
		} else {
		return false;
		}
	}
	
	public static void addSequence() {
		generatedSequence.add(rgby[rand.nextInt(3)]);
	}
	
	public int getCurrentScore() {
		return score;
	}
	
	
}
