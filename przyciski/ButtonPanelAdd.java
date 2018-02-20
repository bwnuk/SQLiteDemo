package przyciski;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import biblioteka.Biblioteka;
import tekst.CzytelnikTekst;

public class ButtonPanelAdd extends JPanel implements ActionListener{
	private final JFrame frame;
	private Biblioteka b;
	
	private JButton czytelnikButton;
	private JButton ksiazkaButton;
	private JButton wypozyczenieButton;
	private JButton backButton;
	
	public ButtonPanelAdd(JFrame frame, Biblioteka b){
		this.b = b;
		this.frame = frame;
		
		czytelnikButton = new JButton("Czytelnika");
		ksiazkaButton = new JButton("Ksiazke");
		wypozyczenieButton = new JButton("Wypozyczenie");
		backButton = new JButton("Powrot");
		
		czytelnikButton.addActionListener(this);
		ksiazkaButton.addActionListener(this);
		wypozyczenieButton.addActionListener(this);
		backButton.addActionListener(this);
		
		add(czytelnikButton);
		add(ksiazkaButton);
		add(wypozyczenieButton);
		add(backButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == czytelnikButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					CzytelnikTekst czyt = new CzytelnikTekst(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(czyt);
                    frame.validate();
				}
			});
		}else if(source == ksiazkaButton) {
			
		}else if(source == wypozyczenieButton) {
			
		}else if(source == backButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel buttonPanel = new ButtonPanel(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(buttonPanel);
                    frame.validate();
				}
			});
		}
		
	}
	
}
