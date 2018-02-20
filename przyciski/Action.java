package przyciski;

import java.awt.Dimension;

import javax.swing.*;

public class Action extends JFrame{
	public Action() {
		super("Biblioteka");
		
		JPanel buttonPanel = new ButtonPanel(this);
		add(buttonPanel);
        setPreferredSize(new Dimension(600, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
