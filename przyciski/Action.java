package przyciski;

import java.awt.Dimension;

import javax.swing.*;

import biblioteka.Biblioteka;

public class Action extends JFrame{
	public Action(Biblioteka b) {
		super("Biblioteka");
		
		JPanel buttonPanel = new ButtonPanel(this, b);
		add(buttonPanel);
        setPreferredSize(new Dimension(600, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
