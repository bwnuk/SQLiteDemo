import java.awt.EventQueue;

import biblioteka.Biblioteka;
import przyciski.Action;

public class Start {

	public static void main(String[] args) {
		Biblioteka b = new Biblioteka();
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Action(b);
			}
		});
	}

}
