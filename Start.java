import java.awt.EventQueue;

import przyciski.Action;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Action();
			}
		});
	}

}
