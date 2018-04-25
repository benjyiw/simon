// Author: Ben Wesemann

package simon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Score {
	private List<HighScore<Integer, String>> topScores;
	private String saveFile = null;
	
	public Score(String saveFile) {
		this.saveFile = saveFile;
		if (new File(saveFile).exists()) {
			try {
				this.topScores = deserialize(saveFile);
			} catch (Exception e) {
				topScores = new ArrayList<>();
			}
		} else {
			topScores = new ArrayList<>();
		}
	}
	
	public boolean IfHighScore(int newScore) {
		if (topScores.size() > 4) {
			Collections.sort(topScores);
			Collections.reverse(topScores);
			if(newScore > topScores.get(topScores.size() -1).getKey()) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public void AddHighScore(int newScore, String initials) {
		if (topScores.size() > 4) {
			Collections.sort(topScores);
			Collections.reverse(topScores);
			topScores.remove(topScores.size() -1);
		}
		topScores.add(new HighScore<>(newScore, initials));
	}

	public int GetHighScore() {
		Collections.sort(topScores);
		Collections.reverse(topScores);
		return topScores.get(0).getKey();
	}

	public List<HighScore<Integer, String>> GetTopFiveScores() {
		Collections.sort(topScores);
		Collections.reverse(topScores);
		return topScores;
	}

	public void SaveScores() throws IOException {
		serialize(topScores, saveFile);
	}

	private static void serialize(List<HighScore<Integer, String>> topScores, String filename) throws IOException {
		ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(filename));
		write.writeObject(topScores);
	}
	
	private static List deserialize(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream read = new ObjectInputStream(new FileInputStream(filename));
		return (List) read.readObject();
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		Collections.sort(topScores);
		Collections.reverse(topScores);
		for (HighScore<Integer, String> highScore : topScores) {
			output.append(String.format("%s: %d\n", highScore.getValue(), highScore.getKey()));
		}
		return output.toString();
	}
}
