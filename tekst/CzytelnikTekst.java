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
import model.Czytelnik;
import przyciski.ButtonPanel;

public class CzytelnikTekst extends JPanel implements ActionListener {
	private Biblioteka b;
	private JTextField imie;
	private JTextField nazwisko;
	private JTextField pesel;
	private JButton acceptButton;
	private final JFrame frame;
	
	public String getImie() {
		return imie.getText();
	}
	
	public String getNazwisko() {
		return nazwisko.getText();
	}
	public String getPesel() {
		return pesel.getText();
	}
	
	public CzytelnikTekst(JFrame frame, Biblioteka b) {
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
		JLabel imieLabel = new JLabel("Imie: ");
		JLabel nazwiskoLabel = new JLabel("Nazwisko: ");
		JLabel peselLabel = new JLabel("Pesel: ");
		
		imie = new JTextField();
		nazwisko = new JTextField();
		pesel = new JTextField();
		
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 3));
        
        inputPanel.add(imieLabel);
        inputPanel.add(imie);
        inputPanel.add(nazwiskoLabel);
        inputPanel.add(nazwisko);
        inputPanel.add(peselLabel);
        inputPanel.add(pesel);
        
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
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == acceptButton) {
			b.insertCzytelnik(getImie(), getNazwisko(), getPesel());
	        System.out.println("Lista czytelników: ");
	        List<Czytelnik> czytelnicy = b.selectCzytelnicy();
	        for(Czytelnik c: czytelnicy)
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


