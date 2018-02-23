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
import model.Czytelnik;
import przyciski.ButtonPanelShow;


public class CzytelnikPokaz extends JPanel implements ActionListener{
	
	private final JFrame frame;
	private Biblioteka b;
	private JButton actionButton;
	
	private final JEditorPane editorPane = new JEditorPane();
	
	public CzytelnikPokaz(JFrame frame, Biblioteka b){
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
        List<Czytelnik> czytelnicy = b.selectCzytelnicy();
        for(Czytelnik c: czytelnicy)
        	text = text + System.lineSeparator() + c;
        
        editorPane.setText(text);
        editorPane.revalidate();
        //this.add(helpPanel, BorderLayout.CENTER);
        //this.add(actionButton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
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
