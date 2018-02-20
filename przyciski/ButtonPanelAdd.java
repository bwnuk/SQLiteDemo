package przyciski;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ButtonPanelAdd extends JPanel implements ActionListener{
	private final JFrame frame;
	
	private JButton czytelnikButton;
	private JButton ksiazkaButton;
	private JButton wypozyczenieButton;
	
	public ButtonPanelAdd(JFrame frame){
		this.frame = frame;
		czytelnikButton = new JButton("Czytelnika");
		ksiazkaButton = new JButton("Ksiazke");
		wypozyczenieButton = new JButton("Wypozyczenie");
		
		czytelnikButton.addActionListener(this);
		ksiazkaButton.addActionListener(this);
		wypozyczenieButton.addActionListener(this);
		
		add(czytelnikButton);
		add(ksiazkaButton);
		add(wypozyczenieButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == czytelnikButton) {
			
		}else if(source == ksiazkaButton) {
			
		}else if(source == wypozyczenieButton) {
			
		}
		
	}
	
}
