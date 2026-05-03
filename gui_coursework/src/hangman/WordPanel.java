package hangman;  
  
import java.awt.Font;  
import java.awt.GridLayout;  
  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
  
// WordPanel class extends JPanel to display a letter in a customized way  
public class WordPanel extends JPanel {  
	// Private JLabel to hold the displayed letter  
	private JLabel j_lab;  
  
	// Constructor that takes a letter as a parameter  
	public WordPanel(String letter) {  
		// Set the layout of this panel to a single-row, single-column GridLayout  
		this.setLayout(new GridLayout(1, 1));  
		// Build the JLabel with the given letter and add it to the panel  
		j_lab = build_JLabel(null, letter); // Pass null as the first argument since we're creating a new JLabel  
		this.add(j_lab);  
	}  
  
	// Method to build a JLabel with a given letter  
	public JLabel build_JLabel(JLabel j_2, String letter) {  
		// Create a new Font with Calibri, bold, italic, and size 45  
		Font f_WP = new Font("Calibri", Font.BOLD + Font.ITALIC, 45);  
		// Create a new JLabel with the given letter and centered text  
		// If j_2 is not null (but in this case it's always null), it would be replaced with a new JLabel  
		j_2 = new JLabel(letter, JLabel.CENTER);  
		// Set the size of the JLabel (not recommended as it's better to use layout managers)  
		j_2.setSize(30, 30);  
		// Set the font of the JLabel  
		j_2.setFont(f_WP);  
		// Return the built JLabel  
		return j_2;  
	}  
  
	// Getter method to return the JLabel holding the displayed letter  
	public JLabel get_J() {  
		return j_lab;  
	}  
}