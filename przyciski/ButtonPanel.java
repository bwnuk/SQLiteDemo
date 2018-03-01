package przyciski;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import biblioteka.Biblioteka;

public class ButtonPanel extends JPanel implements ActionListener{
	private final JFrame frame;
	private Biblioteka b;
	
	private JButton showButton;
	private JButton addButton;
	
	public ButtonPanel(JFrame frame, Biblioteka b){
		this.b = b;
		this.frame = frame;
		showButton = new JButton("Pokaz");
		addButton = new JButton("Dodaj");
		
		showButton.addActionListener(this);
		addButton.addActionListener(this);
		add(showButton);
		add(addButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == showButton){
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel buttonPanel = new ButtonPanelShow(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(buttonPanel);
                    frame.validate();
				}
			});
		}else if(source == addButton) {
			
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel buttonPanel = new ButtonPanelAdd(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(buttonPanel);
                    frame.validate();
				}
			});
		}
	}
	

}
