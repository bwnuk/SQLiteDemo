package tekst;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import biblioteka.Biblioteka;
import przyciski.ButtonPanel;
import model.Wypozyczenia;
import model.Czytelnik;
import model.Ksiazka;

public class WypozyczenieTekst  extends JPanel implements ActionListener{
	private Biblioteka b;
	
	private JTextField id_czytelnika;
	private JTextField id_ksiazki;
	
	private JButton acceptButton;
	
	private final JFrame frame;
	
	public int getIdCzytelnik() {
		return Integer.parseInt(id_czytelnika.getText());
	}
	
	public int getIdKsiazki() {
		return Integer.parseInt(id_ksiazki.getText());
	}
	
	public WypozyczenieTekst(JFrame frame, Biblioteka b) {
		super();
		this.b = b;
		this.frame = frame;
		
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        createComponents();
	}
	
	private void createComponents() {
		JLabel id_c = new JLabel("ID czytelnika: ");
		JLabel id_k = new JLabel("ID ksiazki");
		
		id_czytelnika = new JTextField();
		id_ksiazki = new JTextField();
		
		JPanel inputPanel = new JPanel();
	    inputPanel.setLayout(new GridLayout(3, 3));
	    
	    inputPanel.add(id_c);
	    inputPanel.add(id_czytelnika);
	    inputPanel.add(id_k);
	    inputPanel.add(id_ksiazki);
	    
        acceptButton = new JButton("Wprowadz");
        
        acceptButton.addActionListener((ActionListener) this);
        
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(acceptButton, BorderLayout.SOUTH);
        
        this.add(parentPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == acceptButton) {
			b.insertWypozycz(getIdCzytelnik(), getIdKsiazki());

	        System.out.println("Lista wypozyczen: ");
	        List<Wypozyczenia> wypozyczenia = b.selectWypozyczenia();
	        for(Wypozyczenia c: wypozyczenia)
	            System.out.println(c);
	        
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
