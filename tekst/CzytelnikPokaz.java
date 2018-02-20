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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import biblioteka.Biblioteka;
import model.Czytelnik;


public class CzytelnikPokaz extends JPanel{
	private Biblioteka b;
	private final JEditorPane editorPane = new JEditorPane();
	public CzytelnikPokaz(Biblioteka b){
		super();
		this.b = b;
		createView();
	}
	
	private void createView() {
		editorPane.setEditable(false);
		
        JButton actionButton = new JButton("Sortuj");
        
        actionButton.addActionListener(new ConvertListener());
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        
        helpPanel.add(editorPane);   
        
        this.add(helpPanel);
        this.add(actionButton);
        String text = null;
        List<Czytelnik> czytelnicy = b.selectCzytelnicy();
        for(Czytelnik c: czytelnicy)
        	text = text + System.lineSeparator() + c;
        
        editorPane.setText(text);
        editorPane.revalidate();
        //this.add(helpPanel, BorderLayout.CENTER);
        //this.add(actionButton, BorderLayout.SOUTH);
	}
	
	class ConvertListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
