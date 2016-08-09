package home.main;

import javax.swing.JFrame;

import home.gui.GUIPanel;

public class Main {

	public static void main(String[] args) {
		
		GUIPanel panel = new GUIPanel();
		JFrame f = new JFrame("Manipulación de properties.");
		
		f.add(panel);
		
		f.setSize(550,  225);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
