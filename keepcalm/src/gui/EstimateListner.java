package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstimateListner implements ActionListener {
	private MainWindow mw;

	public EstimateListner(MainWindow mainWindow) {
		mw = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] temp = mw.getSettings();
					if (temp != null) {
						ShowResult window = new ShowResult(mw.getSettings());
						mw.setInfoLabel("Running estimation...", Color.GREEN);
						window.getFrame().setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
