package hangman;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameCore {
	private static char[] word;
	private static char[] guess;
	private static boolean[] exist;
	private static int life = 6;
        
	// Reads a list of words from a file and returns them as an ArrayList  
	public static ArrayList<String> wordGrab() {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\77935\\Desktop\\nouns.txt"));
			ArrayList<String> words = new ArrayList<String>();
			while (sc.hasNext()) {
				words.add(sc.nextLine());

			}
			return words;
		} catch (FileNotFoundException e) {
			System.err.println("No Word List!");
		}
		return null;
	}

	// Checks if the game has ended  
	public static boolean gameEnd() {
		for (boolean c : exist) {
			if (c) {
				return false;
			}
		}
		return true;
	}

	// Randomly selects a word from the provided ArrayList  
	public static String randomChoose(ArrayList<String> s) {
		Random random = new Random();
		try {
			return s.get(random.nextInt(s.size()));
		} catch (Exception e) {
			System.err.println("You Should Add Word List!");
		}
		return null;
	}

	// Creates a boolean array of the same length as the provided char array, with all values set to true 
	public static boolean[] createCheck(boolean[] b, char[] c) {
		b = new boolean[c.length];
		for (int i = 0; i < c.length; i++) {
			b[i] = true;
		}
		return b;
	}

	// Judges a user's guess. If the character is in the word, it's placed in the guess array. 
	public static String judge(char b, MainWindow M) {
		boolean hasFound = false;
		for (int i = 0; i < word.length; i++) {

			if (word[i] == b) {
				guess[i] = word[i];

				exist[i] = false;
				hasFound = true;
			}
		}
		if (!hasFound) {
			removeLife(M.HP, M.HP.get_L());
		}
		return new String(guess);
	}

	 // Removes a life from the game by changing the background color of the corresponding JLabel  
	public static void removeLife(JPanel j, JLabel[] l) {
		l[life].setBackground(Color.red);
		life--;
	}

	// Checks if the game has ended (same as gameEnd but using the exist array)  
	public static boolean endGame() {
		for (int i = 0; i < exist.length; i++) {
			if (exist[i]) {
				return false;
			}
		}
		return true;
	}

	public static String createWord() {
		String prompt = GameCore.randomChoose(GameCore.wordGrab());
		word = prompt.toCharArray();
		guess = prompt.toCharArray();
		for (int i = 0; i < guess.length; i++) {
			guess[i] = '_';

		}
		exist = createCheck(exist, guess);
		return new String(guess);
	}

	public static String get_trueword() {
		return new String(word);
	}

	public static void setTrueword(char[] trueword) {
		GameCore.word = trueword;
	}

	public static void start(MainWindow m) {
		createWord();
		m.setText(new String(guess));
		life = 6;
		m.HP.refresh();
	}

	public static int get_I() {
		return life;
	}

	public static void setI(int i) {
		GameCore.life = i;
	}

}
