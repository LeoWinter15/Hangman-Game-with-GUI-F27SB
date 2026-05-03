package hangman;  
  
// Import necessary Java Swing and AWT libraries  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.GridLayout;  
  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
  
// Define a custom JPanel class named HealthPanel  
public class HealthPanel extends JPanel {  
  
    // Declare a private Font object F with custom font settings  
    // The font is "Times New Roman", bold and italic, with size 27  
    private Font F = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 27);  
  
    // Declare a private JLabel array lab with length 7  
    private JLabel[] lab = new JLabel[7];  
  
    // Constructor for HealthPanel  
    public HealthPanel() {  
        // Set the layout of this panel to a 1x7 GridLayout with specified gaps  
        this.setLayout(new GridLayout(1, 7, 30, 10));  
  
        // Set the initial size of this panel (although this is not recommended as it may not scale well)  
        this.setSize(10, 10);  
  
        // Initialize each JLabel in the array  
        for (int i = 0; i < lab.length; i++) {  
            // Create a new JLabel with text representing its index (starting from 1)  
            lab[i] = new JLabel(Integer.toString(i + 1), JLabel.CENTER);  
  
            // Set the font of the JLabel to the predefined font F  
            lab[i].setFont(F);  
  
            // Set the background color of the JLabel to green  
            lab[i].setBackground(Color.green);  
  
            // Make the JLabel opaque so the background color is visible  
            lab[i].setOpaque(true);  
  
            // Add the JLabel to this panel  
            this.add(lab[i]);  
        }  
    }  
  
    // Method to refresh all labels by setting their background color to green  
    public void refresh() {  
        for (JLabel j : lab) {  
            j.setBackground(Color.green);  
        }  
    }  
  
    // Getter method to return the array of JLabels  
    public JLabel[] get_L() {  
        return lab;  
    }  
}