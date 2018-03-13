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
import tekst.KsiazkaTekst;
import tekst.WypozyczenieTekst;

public class ButtonPanelAdd extends JPanel implements ActionListener, Panel{
	private final JFrame frame;
	private Biblioteka b;
	
	public ButtonPanelAdd(JFrame frame, Biblioteka b){
		this.b = b;
		this.frame = frame;
		
		
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
		}
		else if(source == ksiazkaButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel buttonPanel = new KsiazkaTekst(b, frame);
					
					frame.getContentPane().removeAll();
                    frame.add(buttonPanel);
                    frame.validate();
				}
			});
		}
		else if(source == wypozyczenieButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel buttonPanel = new WypozyczenieTekst(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(buttonPanel);
                    frame.validate();
				}
			});
		}
		else if(source == backButton) {
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
