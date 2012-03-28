package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class FindListener implements ActionListener {
	private String filePath;
	private JTextField jt;

	public FindListener(JTextField textField) {
		jt = textField;
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser c = new JFileChooser();
		int choice = c.showOpenDialog(null);
		if (choice == JFileChooser.APPROVE_OPTION) {
			filePath = c.getSelectedFile().getAbsolutePath();
		}
		if (choice == JFileChooser.CANCEL_OPTION) {
			filePath = null;
		}
		jt.setText(this.toString());

	}

	public String toString() {
		return filePath;
	}
}
