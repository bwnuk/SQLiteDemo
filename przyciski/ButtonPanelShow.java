package przyciski;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import biblioteka.Biblioteka;
import tekst.CzytelnikPokaz;
import tekst.KsiazkaPokaz;
import tekst.WypozyczeniePokaz;

public class ButtonPanelShow extends JPanel implements ActionListener{
	private Biblioteka b;
	
	private final JFrame frame;
	
	private JButton czytelnikButton;
	private JButton ksiazkaButton;
	private JButton wypozyczenieButton;
	private JButton backButton;
	
	public ButtonPanelShow(JFrame frame, Biblioteka b){
		this.frame = frame;
		this.b = b;
		
		czytelnikButton = new JButton("Czytelnikow");
		ksiazkaButton = new JButton("Ksiazki");
		wypozyczenieButton = new JButton("Wypozyczenia");
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
		Object source = e.getSource();
		if(source == czytelnikButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel showPanel = new CzytelnikPokaz(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(showPanel);
                    frame.validate();
				}
			});
			
		}
		else if(source == ksiazkaButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel showPanel = new KsiazkaPokaz(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(showPanel);
                    frame.validate();
				}
			});
		}
		else if(source == wypozyczenieButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel showPanel = new WypozyczeniePokaz(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(showPanel);
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
