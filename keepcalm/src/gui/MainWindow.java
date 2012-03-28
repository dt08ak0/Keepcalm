package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JSlider;

public class MainWindow {

	private JFrame frame;
	private JTextField databaseTextField;
	private JLabel lblUseDatabase;
	private JButton btnBrowseForDatabase;
	private JLabel lblProjectToEstimate;
	private JTextField projectTextField;
	private JButton btnBrowseForProject;
	private JSeparator separator;
	private JLabel infoLabel;
	private JButton btnEstimate;
	private JLabel seperatorLabel1;
	private JLabel seperatorLabel2;
	private ActionListener findDatabaseListner;
	private ActionListener findProjectListner;
	private ActionListener estimateListner;
	private JSlider slider;
	private JLabel lblUseThisPrecision;
	private JLabel lblDefault;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
	}

	/*
	 * - The person should be able to set the similarity threshold for the
	 * similarity function on a scale [0,1] - If the achieved similarity is
	 * below the threshold the user shall be informed. - The program should be
	 * completely in English
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 550, 398);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setTitle("Calculate an estimated time to finish a project");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		getFrame().getContentPane().setLayout(gridBagLayout);

		lblUseDatabase = new JLabel("Use database:");
		GridBagConstraints gbc_lblUseDatabase = new GridBagConstraints();
		gbc_lblUseDatabase.insets = new Insets(0, 0, 5, 0);
		gbc_lblUseDatabase.gridx = 0;
		gbc_lblUseDatabase.gridy = 3;
		getFrame().getContentPane().add(lblUseDatabase, gbc_lblUseDatabase);

		databaseTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 4;
		getFrame().getContentPane().add(databaseTextField, gbc_textField);
		databaseTextField.setColumns(10);

		btnBrowseForDatabase = new JButton("Browse for database:");
		GridBagConstraints gbc_btnBrowseForDatabase = new GridBagConstraints();
		gbc_btnBrowseForDatabase.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowseForDatabase.gridx = 0;
		gbc_btnBrowseForDatabase.gridy = 5;
		getFrame().getContentPane().add(btnBrowseForDatabase,
				gbc_btnBrowseForDatabase);
		findDatabaseListner = new FindListener(databaseTextField);
		btnBrowseForDatabase.addActionListener(findDatabaseListner);

		lblProjectToEstimate = new JLabel(
				"Project to estimate (browse or paste a complete project with several variables (up to 20)):");
		GridBagConstraints gbc_lblProjectToEstimate = new GridBagConstraints();
		gbc_lblProjectToEstimate.insets = new Insets(0, 0, 5, 0);
		gbc_lblProjectToEstimate.gridx = 0;
		gbc_lblProjectToEstimate.gridy = 7;
		getFrame().getContentPane().add(lblProjectToEstimate,
				gbc_lblProjectToEstimate);

		projectTextField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 8;
		getFrame().getContentPane().add(projectTextField, gbc_textField_1);
		projectTextField.setColumns(10);

		btnBrowseForProject = new JButton("Browse for project file");
		GridBagConstraints gbc_btnBrowseForProject = new GridBagConstraints();
		gbc_btnBrowseForProject.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowseForProject.gridx = 0;
		gbc_btnBrowseForProject.gridy = 9;
		getFrame().getContentPane().add(btnBrowseForProject,
				gbc_btnBrowseForProject);
		findDatabaseListner = new FindListener(projectTextField);
		btnBrowseForProject.addActionListener(findDatabaseListner);

		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.SOUTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 10;
		getFrame().getContentPane().add(separator, gbc_separator);

		seperatorLabel1 = new JLabel(
				"---------------------------------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
		gbc_lblNewLabel1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel1.gridx = 0;
		gbc_lblNewLabel1.gridy = 11;
		getFrame().getContentPane().add(seperatorLabel1, gbc_lblNewLabel1);

		lblUseThisPrecision = new JLabel(
				"Use this similarity threshold or drag it to 0 for none");
		GridBagConstraints gbc_lblUseThisPrecision = new GridBagConstraints();
		gbc_lblUseThisPrecision.insets = new Insets(0, 0, 5, 0);
		gbc_lblUseThisPrecision.gridx = 0;
		gbc_lblUseThisPrecision.gridy = 12;
		getFrame().getContentPane().add(lblUseThisPrecision,
				gbc_lblUseThisPrecision);

		lblDefault = new JLabel("Current: None");
		GridBagConstraints gbc_lblDefault = new GridBagConstraints();
		gbc_lblDefault.insets = new Insets(0, 0, 5, 0);
		gbc_lblDefault.gridx = 0;
		gbc_lblDefault.gridy = 13;
		getFrame().getContentPane().add(lblDefault, gbc_lblDefault);

		slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		slider.setPaintTicks(true);
		slider.setValue(0);
		slider.addChangeListener(new SliderListener(lblDefault, slider));
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 0);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 14;
		getFrame().getContentPane().add(slider, gbc_slider);

		seperatorLabel2 = new JLabel(
				"---------------------------------------------------------------------------------------------------------------------");
		GridBagConstraints gbc_lblNewLabel2 = new GridBagConstraints();
		gbc_lblNewLabel2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel2.gridx = 0;
		gbc_lblNewLabel2.gridy = 15;
		getFrame().getContentPane().add(seperatorLabel2, gbc_lblNewLabel2);

		btnEstimate = new JButton("Estimate!");
		GridBagConstraints gbc_btnEstimate = new GridBagConstraints();
		gbc_btnEstimate.insets = new Insets(0, 0, 5, 0);
		gbc_btnEstimate.gridx = 0;
		gbc_btnEstimate.gridy = 16;
		getFrame().getContentPane().add(btnEstimate, gbc_btnEstimate);
		estimateListner = new EstimateListner(this);
		btnEstimate.addActionListener(estimateListner);

		infoLabel = new JLabel(
				"Choose your database and your project to estimate");
		infoLabel.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblChooseYourDatabase = new GridBagConstraints();
		gbc_lblChooseYourDatabase.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseYourDatabase.gridx = 0;
		gbc_lblChooseYourDatabase.gridy = 17;
		getFrame().getContentPane().add(infoLabel, gbc_lblChooseYourDatabase);
	}

	private void setFrame(JFrame jFrame) {
		frame = jFrame;
	}

	private JFrame getFrame() {
		return frame;
	}

	// Gets the path to the database file. CAN RETURN NULL
	public String getDatabasePath() {
		return findDatabaseListner.toString();
	}

	// Gets the path to the project file OR the complete project. CAN RETURN
	// NULL
	public String getProjectPath() {
		return findProjectListner.toString();
	}

	// Useful for warnings
	public void setInfoLabel(String text, Color color) {
		infoLabel.setForeground(color);
		infoLabel.setText(text);
	}

	public String[] getSettings() {
		String[] temp = new String[3];
		temp[0] = databaseTextField.getText();
		temp[1] = projectTextField.getText();
		temp[2] = Integer.toString(slider.getValue());
		System.out.println(temp[0] + " <-test -> " + temp[1]);
		if (temp[0].compareTo("") == 0) {
			if (temp[1].compareTo("") == 0) {
				setInfoLabel(
						"Please specify what database to use and what project to estimate",
						Color.RED);
			} else {
				setInfoLabel("Please specify what database to use", Color.RED);
			}
			return null;
		} else if (temp[1].compareTo("") == 0) {
			setInfoLabel("Please specify what project to investigate",
					Color.RED);
			return null;
		}
		return temp;
	}
}
