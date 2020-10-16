package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option extends JFrame implements ActionListener {

	JPanel firstPanel, secondPanel, thirdPanel;
	private JButton client, owner, submit1, submit2, help, back;
	// Owners button
	private JLabel ownerID, vehInfoTitle, approxRes, approxDaysTitle, approxMonsTitle, TEST2;
	// Clients button
	private JLabel clientID, approxJobTime, approxJobHoursLabel, approxJobMinLabel, deadline, deadlineHoursLabel,
			deadlineMinLabel;
	private JTextField ownerIDText, clientIDText;
	private JTextArea vehInfo;
	private JComboBox approxDays, approxMons, approxJobHours, approxJobMin, deadlineHours, deadlineMin;
	private int xPosAlignLeft = 100;
	private int xPosAlignRight = 270;
	CardLayout swap;
	private Container content;

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

		approxJobTime = new JLabel("Approx. Job Time");
		approxJobTime.setFont(new Font("Arial", Font.PLAIN, 15));
		approxJobTime.setSize(125, 20);
		approxJobTime.setLocation(xPosAlignLeft, 115);
		secondPanel.add(approxJobTime);

		approxJobHoursLabel = new JLabel("Hours");
		approxJobHoursLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		approxJobHoursLabel.setSize(60, 20);
		approxJobHoursLabel.setLocation(xPosAlignRight, 115);
		secondPanel.add(approxJobHoursLabel);

		approxJobMinLabel = new JLabel("Minutes");
		approxJobMinLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		approxJobMinLabel.setSize(60, 20);
		approxJobMinLabel.setLocation(xPosAlignRight + 65, 115);
		secondPanel.add(approxJobMinLabel);

		approxJobHours = new JComboBox();
		approxJobHours.setFont(new Font("Arial", Font.PLAIN, 20));
		approxJobHours.setSize(60, 25);
		approxJobHours.setLocation(xPosAlignRight, 130);
		approxJobMin = new JComboBox();
		approxJobMin.setFont(new Font("Arial", Font.PLAIN, 20));
		approxJobMin.setSize(60, 25);
		approxJobMin.setLocation(xPosAlignRight + 65, 130);

		deadline = new JLabel("Deadline");
		deadline.setFont(new Font("Arial", Font.PLAIN, 15));
		deadline.setSize(125, 20);
		deadline.setLocation(xPosAlignLeft, 175);
		secondPanel.add(deadline);

		deadlineHoursLabel = new JLabel("Hours");
		deadlineHoursLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		deadlineHoursLabel.setSize(60, 20);
		deadlineHoursLabel.setLocation(xPosAlignRight, 150);
		secondPanel.add(deadlineHoursLabel);

		deadlineMinLabel = new JLabel("Minutes");
		deadlineMinLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		deadlineMinLabel.setSize(60, 20);
		deadlineMinLabel.setLocation(xPosAlignRight + 65, 150);
		secondPanel.add(deadlineMinLabel);

		deadlineHours = new JComboBox();
		deadlineHours.setFont(new Font("Arial", Font.PLAIN, 20));
		deadlineHours.setSize(60, 25);
		deadlineHours.setLocation(xPosAlignRight, 175);
		deadlineMin = new JComboBox();
		deadlineMin.setFont(new Font("Arial", Font.PLAIN, 20));
		deadlineMin.setSize(60, 25);
		deadlineMin.setLocation(xPosAlignRight + 65, 175);

		generateComboBoxVals(approxJobHours, deadlineHours, approxJobMin, deadlineMin);
		secondPanel.add(approxJobHours);
		secondPanel.add(approxJobMin);
		secondPanel.add(deadlineHours);
		secondPanel.add(deadlineMin);

		submit1 = new JButton("Submit");

		submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Success!");
				System.out.println("Client ID:");
				System.out.println(clientIDText.getText() + '\n');
				System.out.println("Expected job time: " + approxJobHours.getSelectedItem() + " hours | "
						+ approxJobMin.getSelectedItem() + " minutes.");
				System.out.println("Deadline: " + deadlineHours.getSelectedItem() + " hours | "
						+ deadlineMin.getSelectedItem() + " minutes.");
				
				//resets info for next use
				clearInfo();
			}
		});

		submit1.setFont(new Font("Arial", Font.PLAIN, 20));
		submit1.setLocation(xPosAlignLeft, 300);
		submit1.setSize(100, 20);
		secondPanel.add(submit1);

		createBackButton();
		back.setLocation(250, 300);
		secondPanel.add(back);
	}

	// Owner submit information
	public void ownerPanel() {
		thirdPanel = new JPanel();
		thirdPanel.setLayout(null);
		ownerID = new JLabel("Owner ID");
		ownerID.setFont(new Font("Arial", Font.PLAIN, 15));
		ownerID.setSize(150, 20);
		ownerID.setLocation(xPosAlignLeft, 50);
		thirdPanel.add(ownerID);

		ownerIDText = new JTextField();
		ownerIDText.setFont(new Font("Arial", Font.PLAIN, 20));
		ownerIDText.setSize(90, 20);
		ownerIDText.setLocation(xPosAlignRight, 50);
		thirdPanel.add(ownerIDText);

		vehInfoTitle = new JLabel("Vehicle Information");
		vehInfoTitle.setFont(new Font("Arial", Font.PLAIN, 15));
		vehInfoTitle.setSize(150, 20);
		vehInfoTitle.setLocation(xPosAlignLeft, 130);
		thirdPanel.add(vehInfoTitle);

		vehInfo = new JTextArea();
		vehInfo.setFont(new Font("Arial", Font.PLAIN, 12));
		vehInfo.setSize(300, 75);
		vehInfo.setLocation(xPosAlignRight, 130);
		thirdPanel.add(vehInfo);

		approxRes = new JLabel("Approx. Residency");
		approxRes.setFont(new Font("Arial", Font.PLAIN, 15));
		approxRes.setSize(125, 20);
		approxRes.setLocation(xPosAlignLeft, 280);
		thirdPanel.add(approxRes);

		approxDaysTitle = new JLabel("Days");
		approxDaysTitle.setFont(new Font("Arial", Font.PLAIN, 10));
		approxDaysTitle.setSize(60, 20);
		approxDaysTitle.setLocation(xPosAlignRight, 255);
		thirdPanel.add(approxDaysTitle);

		approxMonsTitle = new JLabel("Months");
		approxMonsTitle.setFont(new Font("Arial", Font.PLAIN, 10));
		approxMonsTitle.setSize(60, 20);
		approxMonsTitle.setLocation(xPosAlignRight + 65, 255);
		thirdPanel.add(approxMonsTitle);

		approxDays = new JComboBox();
		approxDays.setFont(new Font("Arial", Font.PLAIN, 20));
		approxDays.setSize(60, 25);
		approxDays.setLocation(xPosAlignRight, 280);
		thirdPanel.add(approxDays);
		approxMons = new JComboBox();
		approxMons.setFont(new Font("Arial", Font.PLAIN, 20));
		approxMons.setSize(60, 25);
		approxMons.setLocation(xPosAlignRight + 65, 280);
		thirdPanel.add(approxMons);
		generateComboBoxVals(approxDays, approxMons);

		submit2 = new JButton("Submit");

		submit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				System.out.println("Success!");
				System.out.println("Owner ID:");
				System.out.println(ownerIDText.getText() + '\n');
				System.out.println("Vehicle Info:");
				System.out.println(vehInfo.getText() + '\n');
				System.out.println("Expected days: " + approxDays.getSelectedItem() + " | Expected Months: "
						+ approxMons.getSelectedItem());
				
				//resets information for next use
				clearInfo();

			}
		});

		submit2.setFont(new Font("Arial", Font.PLAIN, 20));
		submit2.setLocation(xPosAlignLeft, 400);
		submit2.setSize(100, 20);
		thirdPanel.add(submit2);

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
		submit1.addActionListener(this);
		submit1.setActionCommand("Submit");
		submit2.addActionListener(this);
		submit2.setActionCommand("Submit");
	}

	public Option() {
		this.setTitle("Milestone 2");
		this.setLocation(610, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

	@Override
	// GUI navigation
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
	
	private void clearInfo() {
		//client info clear
		clientIDText.setText(null);
		approxJobHours.setSelectedIndex(0);
		approxJobMin.setSelectedIndex(0);
		deadlineHours.setSelectedIndex(0);
		deadlineMin.setSelectedIndex(0);
		
		//owner info clear
		ownerIDText.setText(null);
		vehInfo.setText(null);
		approxDays.setSelectedIndex(0);
		approxMons.setSelectedIndex(0);
	}

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
}
