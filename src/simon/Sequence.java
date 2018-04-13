package simon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sequence {
	private static List<Character> generatedSequence = new ArrayList<>();
	private static List<Character> userGuessSequence = new ArrayList<>();
	private static int score = 0;
	private static char[] rgby = {'Y', 'B', 'R', 'G'};
	private static Random rand = new Random();

	public static List<Character> getSequence() {
		return generatedSequence;
	}
	
	public static void newSequence() {
		generatedSequence.clear();
		for(int i = 0; i < 4; i++) {
			generatedSequence.add(rgby[rand.nextInt(3)]);
		}
	}

	public static boolean userInput(char input) {
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
	
	public static int getCurrentScore() {
		return score;
	}
	
	public static boolean isOver() {
		if(generatedSequence.size() == userGuessSequence.size()) {
			return true;
		} else {
			return false;
		}
	}
	
}
