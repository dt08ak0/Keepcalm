package gui;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;

import javax.swing.JButton;

public class ShowResult {

	private JFrame frame;
	private JTable table;
	private int similarity;
	private JButton btnClose;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowResult window = new ShowResult(new String[] { "asd",
//							"dsa", "85" });
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	// TODO: Behöver få in data
	public ShowResult(String[] strings) {
		initialize(strings);
	}

	// TODO: Visa resultat.
	/*
	 * The effort estimate should be displayed using the format person-hours
	 * (ph), person-days (pd), person-months (pm) and person-years(py)
	 */
	private void initialize(String[] strings) {
		frame = new JFrame();
		frame.setBounds(150, 150, 454, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setTitle("Result of estimation");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		similarity = Integer.parseInt(strings[2]);
		@SuppressWarnings("serial")
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return 2;
			}

			public int getRowCount() {
				return 5;
			}

			// Get a result in ph, pd, pm and py
			public Object getValueAt(int row, int col) {
				if (col == 0) {
					switch (row) {
					case 0:
						return "Time period";
					case 1:
						return "Person-hours";
					case 2:
						return "Person-days";
					case 3:
						return "Person-Months";
					case 4:
						return "Person-years";
					}
				} else {
					switch (row) {
					// TODO: fix with proper data
					case 0:
						return "Estimated time";
					case 1:
						return "1337";
					case 2:
						return "88";
					case 3:
						return "666";
					case 4:
						return "42";
					}
				}
				return new Integer((row + 1));
			}
		};
		table = new JTable(dataModel);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(table, BorderLayout.CENTER);

		JTextPane txtpnTheUsedSimilarity = new JTextPane();
		txtpnTheUsedSimilarity.setEditable(false);
		txtpnTheUsedSimilarity.setContentType("text/html");
		// TODO: Fix with proper data
		txtpnTheUsedSimilarity
				.setText("The used similarity was:<b> "
						+ similarity
						/ 100.0
						+ "</b> <br> ----<b>Other INFO</b>---- <br><big>  ----OTHER OTHER INFO----- </big>");
		frame.getContentPane().add(txtpnTheUsedSimilarity, BorderLayout.NORTH);

		btnClose = new JButton("Close");
		frame.getContentPane().add(btnClose, BorderLayout.SOUTH);
		btnClose.addActionListener(new CloseListener());
	}

	public JFrame getFrame() {
		return frame;
	}

}
