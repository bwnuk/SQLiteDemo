package tekst;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import biblioteka.Biblioteka;
import przyciski.ButtonPanelShow;
import model.Wypozyczenia;

public class WypozyczeniePokaz extends JPanel implements ActionListener{

	private final JFrame frame;
	private Biblioteka b;
	private JButton actionButton;
	
	private final JEditorPane editorPane = new JEditorPane();
	
	public WypozyczeniePokaz(JFrame frame, Biblioteka b) {
		super();
		this.frame = frame;
		this.b = b;
		createView();
	}
	
	private void createView() {
		editorPane.setEditable(false);
		
		actionButton = new JButton("Powrot");
        
        actionButton.addActionListener(this);
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        
        helpPanel.add(editorPane);   
        
        this.add(helpPanel);
        this.add(actionButton);
        String text = "Lista: ";
        List<Wypozyczenia> wypozyczenia = b.selectWypozyczenia();
        for(Wypozyczenia c: wypozyczenia)
        	text = text + System.lineSeparator() + c;
        
        editorPane.setText(text);
        editorPane.revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == actionButton) {
			SwingUtilities.invokeLater(new Runnable(){
				@Override
				public void run() {
					JPanel buttonPanel = new ButtonPanelShow(frame, b);
					
					frame.getContentPane().removeAll();
                    frame.add(buttonPanel);
                    frame.validate();
				}
		});
		}
	}

}
