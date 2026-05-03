package hangman;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
* This class represents the main window of the Hangman game, containing the HealthPanel, WordPanel, and ButtonPanel.
*/

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	/**
	* The HealthPanel instance to display the player's remaining lives.
	*/
	HealthPanel HP = new HealthPanel();
	WordPanel WP = new WordPanel(GameCore.createWord());

	/**
	* Updates the text displayed in the WordPanel with the given string.
	*
	* @param s The new text to be displayed.
	*/
	
	public void setText(String s) {
		WP.get_J().setText(s);
	}

	ButtonPanel BP = new ButtonPanel(this);

	/**
	* Constructor for the MainWindow. Initializes the JFrame with a title and adds the components.
	*/
	
	public MainWindow() {
		this.setTitle("HANGMAN");
		this.setLayout(new GridLayout(3, 1, 40, 40));
		this.add(HP);
		this.add(WP);
		this.add(BP);
		this.setSize(1200, 1000);
		this.setDefaultCloseOperation(3);
	}

}

