package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class GUI extends JFrame implements ActionListener {

	private JPanel firstPanel, secondPanel, thirdPanel;
	private JButton client, owner, clientSubmit, ownerSubmit, help, back;
	// Owners button
	private JLabel ownerID, vehModel, vehColor, vehLicense, approxRes, approxDaysTitle, approxMonsTitle, TEST2;
	// Clients button
	private JLabel clientID, jobInfo, approxJobTime, approxJobHoursLabel, approxJobMinLabel, deadline, deadlineHoursLabel,
			deadlineMinLabel;
	private JTextField ownerIDText, vehModelText, vehLicenseText, clientIDText;
	private JTextArea jobInfoText;
	private JComboBox vehColorBox, approxDays, approxMons, approxJobHours, approxJobMin, deadlineHours, deadlineMin;
	private int xPosAlignLeft = 100;
	private int xPosAlignRight = 270;
	private CardLayout swap;
	private Container content;
	private String[] colors= {"White", "Black", "Grey", "Silver", "Green", "Red", "Blue", "Yellow", "Purple", "Pink", "Orange", "Other"};
	private ArrayList<String[]> ownerEntries = new ArrayList<>();
	private ArrayList<String[]> clientEntries = new ArrayList<>();
	
	
	// Opening frame to the GUI
	public void panel1() {
		firstPanel = new JPanel();
		firstPanel.setLayout(null);
		client = new JButton("Client");
		owner = new JButton("Owner");
		client.setSize(90, 20);
		client.setLocation(xPosAlignLeft, 50);
		owner.setSize(90, 20);
		owner.setLocation(xPosAlignLeft, 115);
		firstPanel.add(client);
		firstPanel.add(owner);
		createHelpButton();
		help.setSize(90, 20);
		help.setLocation(xPosAlignLeft, 180);
		firstPanel.add(help);
	}

	// Client submits information
	public void clientPanel() {
		secondPanel = new JPanel();
		secondPanel.setLayout(null);
        clientID = new JLabel("Client ID");
        clientID.setFont(new Font("Arial", Font.PLAIN, 15));
        clientID.setSize(150, 20);
        clientID.setLocation(xPosAlignLeft, 50);
        secondPanel.add(clientID);
        
        clientIDText = new JTextField();
        clientIDText.setFont(new Font("Arial", Font.PLAIN, 20));
        clientIDText.setSize(90, 20);
        clientIDText.setLocation(xPosAlignRight, 50);
        secondPanel.add(clientIDText);
        
        jobInfo = new JLabel("Job Info");
        jobInfo.setFont(new Font("Arial", Font.PLAIN, 15));
        jobInfo.setSize(150, 20);
        jobInfo.setLocation(xPosAlignLeft, 85);
        secondPanel.add(jobInfo);
        
        jobInfoText = new JTextArea();
        jobInfoText.setFont(new Font("Arial", Font.PLAIN, 20));
        jobInfoText.setSize(300, 90);
        jobInfoText.setLocation(xPosAlignRight, 85);
        secondPanel.add(jobInfoText);
        
        approxJobTime = new JLabel("Approx. Job Time");
        approxJobTime.setFont(new Font("Arial", Font.PLAIN, 15));
        approxJobTime.setSize(125, 20);
        approxJobTime.setLocation(xPosAlignLeft, 200);
        secondPanel.add(approxJobTime);
        
        approxJobHoursLabel = new JLabel("Hours");
        approxJobHoursLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        approxJobHoursLabel.setSize(60, 20);
        approxJobHoursLabel.setLocation(xPosAlignRight, 180);
        secondPanel.add(approxJobHoursLabel);
        
        approxJobMinLabel = new JLabel("Minutes");
        approxJobMinLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        approxJobMinLabel.setSize(60, 20);
        approxJobMinLabel.setLocation(xPosAlignRight+65, 180);
        secondPanel.add(approxJobMinLabel);
        
        approxJobHours = new JComboBox();
        approxJobHours.setFont(new Font("Arial", Font.PLAIN, 20));
        approxJobHours.setSize(60, 25);
        approxJobHours.setLocation(xPosAlignRight, 200);
        approxJobMin = new JComboBox();
        approxJobMin.setFont(new Font("Arial", Font.PLAIN, 20));
        approxJobMin.setSize(60, 25);
        approxJobMin.setLocation(xPosAlignRight+65, 200);
        
        
        deadline = new JLabel("Deadline");
        deadline.setFont(new Font("Arial", Font.PLAIN, 15));
        deadline.setSize(125, 20);
        deadline.setLocation(xPosAlignLeft, 275);
        secondPanel.add(deadline);
        
        deadlineHoursLabel = new JLabel("Hours");
        deadlineHoursLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        deadlineHoursLabel.setSize(60, 20);
        deadlineHoursLabel.setLocation(xPosAlignRight, 255);
        secondPanel.add(deadlineHoursLabel);
        
        deadlineMinLabel = new JLabel("Minutes");
        deadlineMinLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        deadlineMinLabel.setSize(60, 20);
        deadlineMinLabel.setLocation(xPosAlignRight+65, 255);
        secondPanel.add(deadlineMinLabel);
        
        deadlineHours = new JComboBox();
        deadlineHours.setFont(new Font("Arial", Font.PLAIN, 20));
        deadlineHours.setSize(60, 25);
        deadlineHours.setLocation(xPosAlignRight, 275);
        deadlineMin = new JComboBox();
        deadlineMin.setFont(new Font("Arial", Font.PLAIN, 20));
        deadlineMin.setSize(60, 25);
        deadlineMin.setLocation(xPosAlignRight+65, 275);


		generateComboBoxVals(approxJobHours, deadlineHours, approxJobMin, deadlineMin);
		secondPanel.add(approxJobHours);
		secondPanel.add(approxJobMin);
		secondPanel.add(deadlineHours);
		secondPanel.add(deadlineMin);

		clientSubmit = new JButton("Submit");

		clientSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				String[] tempArr = {clientIDText.getText(), jobInfoText.getText(), (String)approxJobHours.getSelectedItem(), (String)approxJobMin.getSelectedItem(),
									(String)deadlineHours.getSelectedItem(), (String)deadlineMin.getSelectedItem(), timeStamp};
				clientEntries.add(tempArr);
				System.out.println("Success!");
				System.out.println("Client ID:");
				System.out.println(clientIDText.getText() + '\n');
				UUID jobID= UUID.randomUUID();
				System.out.println("Job ID: " + jobID + '\n');
				System.out.println("Job Information: " + jobInfoText.getText() + '\n');
				System.out.println("Expected job time: " + approxJobHours.getSelectedItem() + " hours | "
						+ approxJobMin.getSelectedItem() + " minutes.");
				System.out.println("Deadline: " + deadlineHours.getSelectedItem() + " hours | "
						+ deadlineMin.getSelectedItem() + " minutes.");
				
				//resets info for next use
				clearInfo();
			}
		});

		clientSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
		clientSubmit.setLocation(xPosAlignLeft, 300);
		clientSubmit.setSize(100, 20);
		secondPanel.add(clientSubmit);

		createBackButton();
		back.setLocation(250, 300);
		secondPanel.add(back);
	}
	

	/*
	 * All paneling belonging to the owner 
	 */
	public void ownerPanel() {
		thirdPanel = new JPanel();
		thirdPanel.setLayout(null);
        ownerID = new JLabel("Owner ID");
        ownerID.setFont(new Font("Arial", Font.BOLD, 15));
        ownerID.setSize(150, 20);
        ownerID.setLocation(xPosAlignLeft, 50);
        thirdPanel.add(ownerID);
        
        ownerIDText = new JTextField();
        ownerIDText.setFont(new Font("Arial", Font.PLAIN, 18));
        ownerIDText.setSize(90, 20);
        ownerIDText.setLocation(xPosAlignRight, 50);
        thirdPanel.add(ownerIDText);
        
        vehModel = new JLabel("Vehicle Model");
        vehModel.setFont(new Font("Arial", Font.BOLD, 15));
        vehModel.setSize(150, 20);
        vehModel.setLocation(xPosAlignLeft, 130);
        thirdPanel.add(vehModel);
        
        vehModelText = new JTextField();
        vehModelText.setFont(new Font("Arial", Font.PLAIN, 18));
        vehModelText.setSize(175, 20);
        vehModelText.setLocation(xPosAlignRight, 130);
        thirdPanel.add(vehModelText);
        
        vehColor = new JLabel("Vehicle Color");
        vehColor.setFont(new Font("Arial", Font.BOLD, 15));
        vehColor.setSize(150, 20);
        vehColor.setLocation(xPosAlignLeft, 185);
        thirdPanel.add(vehColor);
        
        vehColorBox = new JComboBox();
        vehColorBox.setFont(new Font("Arial", Font.PLAIN, 18));
        vehColorBox.setSize(100, 25);
        vehColorBox.setLocation(xPosAlignRight, 185);
        insertColors(vehColorBox);
        thirdPanel.add(vehColorBox);
        
        vehLicense = new JLabel("Vehicle Plate #");
        vehLicense.setFont(new Font("Arial", Font.BOLD, 15));
        vehLicense.setSize(150, 20);
        vehLicense.setLocation(xPosAlignLeft, 255);
        thirdPanel.add(vehLicense);
        
        vehLicenseText = new JTextField();
        vehLicenseText.setFont(new Font("Arial", Font.PLAIN, 18));
        vehLicenseText.setSize(100, 20);
        vehLicenseText.setLocation(xPosAlignRight, 255);
        thirdPanel.add(vehLicenseText);
        
        approxRes = new JLabel("Approx. Residency");
        approxRes.setFont(new Font("Arial", Font.BOLD, 15));
        approxRes.setSize(150, 20);
        approxRes.setLocation(xPosAlignLeft, 315);
        thirdPanel.add(approxRes);
        
        approxDaysTitle = new JLabel("Days");
        approxDaysTitle.setFont(new Font("Arial", Font.PLAIN, 10));
        approxDaysTitle.setSize(60, 20);
        approxDaysTitle.setLocation(xPosAlignRight, 295);
        thirdPanel.add(approxDaysTitle);
        
        approxMonsTitle = new JLabel("Months");
        approxMonsTitle.setFont(new Font("Arial", Font.PLAIN, 10));
        approxMonsTitle.setSize(60, 20);
        approxMonsTitle.setLocation(xPosAlignRight+65, 295);
        thirdPanel.add(approxMonsTitle);
        
        approxDays = new JComboBox();
        approxDays.setFont(new Font("Arial", Font.PLAIN, 18));
        approxDays.setSize(60, 25);
        approxDays.setLocation(xPosAlignRight, 315);
        approxMons = new JComboBox();
        approxMons.setFont(new Font("Arial", Font.PLAIN, 18));
        approxMons.setSize(60, 25);
        approxMons.setLocation(xPosAlignRight+65, 315);
        generateComboBoxVals(approxDays, approxMons);
        thirdPanel.add(approxDays);
        thirdPanel.add(approxMons);


		ownerSubmit = new JButton("Submit");

		ownerSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				String[] tempArr = {ownerIDText.getText(), vehModelText.getText(), (String)vehColorBox.getSelectedItem(),
									vehLicenseText.getText(), (String)approxDays.getSelectedItem(), (String)approxMons.getSelectedItem(), timeStamp};
				//adding the temporary data array to the total client entries for file writing at later point 
				ownerEntries.add(tempArr);
				System.out.println("Success!");
				System.out.println("Owner ID: ");
				System.out.println(ownerIDText.getText() + '\n');
				System.out.println("Vehicle Model: ");
				System.out.println(vehModelText.getText() + '\n');
				System.out.println("Vehicle Color: " + vehColorBox.getSelectedItem() + '\n');
				System.out.println("Vehicle Plate #: "+ vehLicenseText.getText() + '\n');
				System.out.println("Expected days: " + approxDays.getSelectedItem() 
						+ " | Expected Months: " + approxMons.getSelectedItem());

				
				//resets information for next use
				clearInfo();

			}
		});

		ownerSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
		ownerSubmit.setLocation(xPosAlignLeft, 400);
		ownerSubmit.setSize(100, 20);
		thirdPanel.add(ownerSubmit);

		createBackButton();
		thirdPanel.add(back);
	}

	// help button
	public void createHelpButton() {
		help = new JButton("Help");
		help.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				String message = "Select Client or Owner.\nSelect client if you want to submit a job.\n"
						+ "Select owner if you want to rent out your vehicle.";
				JOptionPane.showMessageDialog(firstPanel, message);
			}
		});
	}

	// back button
	public void createBackButton() {
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				swap.first(content);
			}
		});
		back.setFont(new Font("Arial", Font.PLAIN, 20));
		back.setLocation(250, 400);
		back.setSize(100, 20);

	}

	// adds functionality to the buttons
	public void seeAction() {
		client.addActionListener(this);
		client.setActionCommand("Client");
		owner.addActionListener(this);
		owner.setActionCommand("Owner");
		clientSubmit.addActionListener(this);
		clientSubmit.setActionCommand("Submit");
		ownerSubmit.addActionListener(this);
		ownerSubmit.setActionCommand("Submit");
	}
	/*
	 * The constructor of the main GUI panel. 
	 */
	public GUI() {
		this.setTitle("Milestone 2");
		this.setLocation(610, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        generateLogs();
		    }
		});
		panel1();
		clientPanel();
		ownerPanel();
		firstPanel.setBackground(Color.LIGHT_GRAY);
		secondPanel.setBackground(Color.LIGHT_GRAY);
		thirdPanel.setBackground(Color.LIGHT_GRAY);
		swap = new CardLayout();
		content = getContentPane();
		content.setLayout(swap);

		seeAction();
		
		this.setSize(700, 500);
		content.add(firstPanel);
		content.add(secondPanel);
		content.add(thirdPanel);
		this.setVisible(true);
	}
	// GUI navigation
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Client":
			swap.next(content);
			break;
		case "Owner":
			swap.next(content);
			swap.next(content);
			break;
		case "Submit":
			swap.first(content);
			break;

		}
	}
	
	/*
	 * Handles clearing information after each entry
	 */
	private void clearInfo() {
		//client info clear
		clientIDText.setText(null);
		jobInfoText.setText(null);
		approxJobHours.setSelectedIndex(0);
		approxJobMin.setSelectedIndex(0);
		deadlineHours.setSelectedIndex(0);
		deadlineMin.setSelectedIndex(0);
		
		//owner info clear
		ownerIDText.setText(null);
		vehModelText.setText(null);
		vehLicenseText.setText(null);
		vehColorBox.setSelectedIndex(0);
		approxDays.setSelectedIndex(0);
		approxMons.setSelectedIndex(0);
	}

	
	private void insertColors(JComboBox vehColorBox) {
		for(int i=0; i<colors.length; i++) {
			vehColorBox.addItem(colors[i]);
		}
	}

	/*
	 * Functions to automate the generation of integer dependent combo box values. 
	 */
	private void generateComboBoxVals(JComboBox approxDays, JComboBox approxMons) {
		for (int i = 0; i <= 30; i++) {
			approxDays.addItem(Integer.toString(i));
		}

		for (int i = 0; i <= 24; i++) {
			approxMons.addItem(Integer.toString(i));
		}
	}

	private void generateComboBoxVals(JComboBox approxJobHours, JComboBox deadlineHours, JComboBox approxJobMin,
			JComboBox deadlineMin) {
		for (int i = 0; i <= 48; i++) {
			approxJobHours.addItem(Integer.toString(i));
			deadlineHours.addItem(Integer.toString(i));
		}
		for (int i = 0; i <= 59; i++) {
			approxJobMin.addItem(Integer.toString(i));
			deadlineMin.addItem(Integer.toString(i));
		}
	}
	
	
	public void generateLogs() {
		//log generation for clients
		try {
			
			FileWriter csvWriter = new FileWriter("clientLog.csv");
			csvWriter.append("Client id");
			csvWriter.append(",");
			csvWriter.append("Job Info.");
			csvWriter.append(",");
			csvWriter.append("Approx. Job Hours");
			csvWriter.append(",");
			csvWriter.append("Approx. Job Min.");
			csvWriter.append(",");
			csvWriter.append("Deadline Hours");
			csvWriter.append(",");
			csvWriter.append("Deadline Min.");
			csvWriter.append(",");
			csvWriter.append("Timestamp");
			csvWriter.append("\n");
			
			for(String[] entry: clientEntries) {
				System.out.println(String.join(",", entry));
				csvWriter.append(String.join(",", entry));
				csvWriter.append("\n");
			}
			csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//log generation for owners
		try {
			
			FileWriter csvWriter = new FileWriter("ownerLog.csv");
			csvWriter.append("Owner id");
			csvWriter.append(",");
			csvWriter.append("Vehicle Model");
			csvWriter.append(",");
			csvWriter.append("Vehicle Color");
			csvWriter.append(",");
			csvWriter.append("Vehicle Plate Number");
			csvWriter.append(",");
			csvWriter.append("Approx. Residency Days");
			csvWriter.append(",");
			csvWriter.append("Approx Residency Months");
			csvWriter.append(",");
			csvWriter.append("Timestamp");
			csvWriter.append("\n");
			
			for(String[] entry: ownerEntries) {
				System.out.println(String.join(",", entry));
				csvWriter.append(String.join(",", entry));
				csvWriter.append("\n");
			}
			csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
