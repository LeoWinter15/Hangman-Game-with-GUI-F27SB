package hangman;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//ButtonPanel class represents a panel with buttons for the Hangman game  
public class ButtonPanel extends JPanel {
	private MainWindow MW;
	private JButton[] key = new JButton[26];

	// Constructor for ButtonPanel, taking a MainWindow instance as a parameter 
	public ButtonPanel(MainWindow MW) {
		this.MW = MW;
		// Set the layout to a GridLayout with 5 rows, 6 columns, and specified gaps  
		this.setLayout(new GridLayout(5, 6, 6, 7));
		for (int i = 0; i < 26; i++) {
			char letter = (char) ('A' + i);
			String str = Character.toString(letter);
			key[i] = new JButton();
			key[i].setText(str);
			key[i].addActionListener(new guessListener(letter, MW));
			this.add(key[i]);
		}
	}

	// Method to set all buttons to visible
	public void set_Visible() {
		for (int i = 0; i < 26; i++) {
			key[i].setVisible(true);
		}
	}

}

//guessListener class that implements ActionListener for handling button clicks  
class guessListener implements ActionListener {
	private char letter;
	private MainWindow WM_guess;

	// Constructor for guessListener, taking a letter and MainWindow instance as parameters  
	public guessListener(char letter, MainWindow MainWindow) {
		this.WM_guess = MainWindow;
		this.letter = letter;
		// Sthis.MainWindow = MainWindow;
	}

	// Override the actionPerformed method to handle button clicks  
	@Override
	public void actionPerformed(ActionEvent e) {

		String str = GameCore.judge(letter, WM_guess);
		JButton source = (JButton) e.getSource();
		source.setVisible(false);
		WM_guess.setText(str);
		boolean over_game = GameCore.endGame();
		if (over_game) {
			String information = "Wonderful!\nSuccessfully spell the word！\nDo you want to play again?";
			int over = JOptionPane.showConfirmDialog(WM_guess, information, "Success!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (over == JOptionPane.YES_OPTION) {
				GameCore.start(WM_guess);
				WM_guess.BP.set_Visible();
				} 
			else if (over == JOptionPane.NO_OPTION) {
				System.exit(0);
				} 
			else if (over == JOptionPane.CLOSED_OPTION) {
				int end1 = JOptionPane.showConfirmDialog(WM_guess, "Are you going to cancel?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (end1 == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
				else {
					GameCore.start(WM_guess);
					WM_guess.BP.set_Visible();
				}
			}
		}
		
		if (GameCore.get_I() == -1) {
			String information = "Sorry!\nFailed to spell the word!\nThe word is: " + GameCore.get_trueword()
					+ "\nDo you want to play again?";
			int over = JOptionPane.showConfirmDialog(WM_guess, information, "Failed", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (over == JOptionPane.YES_OPTION) {
				GameCore.start(WM_guess);
				WM_guess.BP.set_Visible();
			}
			else if (over == JOptionPane.NO_OPTION) {
				System.exit(0);
			} 
			else if (over == JOptionPane.CLOSED_OPTION) {
				int end1 = JOptionPane.showConfirmDialog(WM_guess, "Are you going to cancel?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (end1 == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
				else {
					GameCore.start(WM_guess);
					WM_guess.BP.set_Visible();
				}
			}
		}
	}

}
