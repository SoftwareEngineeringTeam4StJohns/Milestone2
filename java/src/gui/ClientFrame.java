package gui;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.UUID;
public class ClientFrame extends JFrame
implements ActionListener{
	private Container content;
	private JLabel clientID;
	private JTextField clientIDText;
	private JLabel jobInfo;
	private JTextArea jobInfoText;
	private JLabel approxJobTime;
	private JLabel approxJobHoursLabel;
	private JLabel approxJobMinLabel;
	private JComboBox approxJobHours;
	private JComboBox approxJobMin;
	private JLabel deadline;
	private JLabel deadlineHoursLabel;
	private JLabel deadlineMinLabel;
	private JComboBox deadlineHours;
	private JComboBox deadlineMin;
	private JButton submit; 
	private int xPosAlignLeft = 100;
	private int xPosAlignRight = 270;
	
	public ClientFrame() {
		setTitle("Client Job Interface");
		setBounds(500, 90, 700, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        content = getContentPane();
        content.setLayout(null);
		
        clientID = new JLabel("Client ID");
        clientID.setFont(new Font("Arial", Font.PLAIN, 15));
        clientID.setSize(150, 20);
        clientID.setLocation(xPosAlignLeft, 50);
        content.add(clientID);
        
        clientIDText = new JTextField();
        clientIDText.setFont(new Font("Arial", Font.PLAIN, 20));
        clientIDText.setSize(90, 20);
        clientIDText.setLocation(xPosAlignRight, 50);
        content.add(clientIDText);
        
        jobInfo = new JLabel("Job Info");
        jobInfo.setFont(new Font("Arial", Font.PLAIN, 15));
        jobInfo.setSize(150, 20);
        jobInfo.setLocation(xPosAlignLeft, 85);
        content.add(jobInfo);
        
        jobInfoText = new JTextArea();
        jobInfoText.setFont(new Font("Arial", Font.PLAIN, 20));
        jobInfoText.setSize(300, 90);
        jobInfoText.setLocation(xPosAlignRight, 85);
        content.add(jobInfoText);
        
        approxJobTime = new JLabel("Approx. Job Time");
        approxJobTime.setFont(new Font("Arial", Font.PLAIN, 15));
        approxJobTime.setSize(125, 20);
        approxJobTime.setLocation(xPosAlignLeft, 200);
        content.add(approxJobTime);
        
        approxJobHoursLabel = new JLabel("Hours");
        approxJobHoursLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        approxJobHoursLabel.setSize(60, 20);
        approxJobHoursLabel.setLocation(xPosAlignRight, 180);
        content.add(approxJobHoursLabel);
        
        approxJobMinLabel = new JLabel("Minutes");
        approxJobMinLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        approxJobMinLabel.setSize(60, 20);
        approxJobMinLabel.setLocation(xPosAlignRight+65, 180);
        content.add(approxJobMinLabel);
        
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
        content.add(deadline);
        
        deadlineHoursLabel = new JLabel("Hours");
        deadlineHoursLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        deadlineHoursLabel.setSize(60, 20);
        deadlineHoursLabel.setLocation(xPosAlignRight, 255);
        content.add(deadlineHoursLabel);
        
        deadlineMinLabel = new JLabel("Minutes");
        deadlineMinLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        deadlineMinLabel.setSize(60, 20);
        deadlineMinLabel.setLocation(xPosAlignRight+65, 255);
        content.add(deadlineMinLabel);
        
        deadlineHours = new JComboBox();
        deadlineHours.setFont(new Font("Arial", Font.PLAIN, 20));
        deadlineHours.setSize(60, 25);
        deadlineHours.setLocation(xPosAlignRight, 275);
        deadlineMin = new JComboBox();
        deadlineMin.setFont(new Font("Arial", Font.PLAIN, 20));
        deadlineMin.setSize(60, 25);
        deadlineMin.setLocation(xPosAlignRight+65, 275);
        
        
        
        generateComboBoxVals(approxJobHours, deadlineHours, approxJobMin, deadlineMin);
        content.add(approxJobHours);
        content.add(approxJobMin);
        content.add(deadlineHours);
        content.add(deadlineMin);
 
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setLocation(xPosAlignLeft, 400);
        submit.setSize(100, 20);
        submit.addActionListener(this);
        content.add(submit);
        setVisible(true);
        
        
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == submit) {
			System.out.println("Success!");
			System.out.println("Client ID: ");
			System.out.println(clientIDText.getText() + '\n');
			UUID jobID = UUID.randomUUID();
			System.out.println("Job ID: " + jobID + '\n');
			System.out.println("Job Information: ");
			System.out.println(jobInfoText.getText() + '\n');
			System.out.println("Expected job time: " + approxJobHours.getSelectedItem() 
			+ " hours | " + approxJobMin.getSelectedItem() + " minutes.");
			System.out.println("Deadline: " + deadlineHours.getSelectedItem() 
			+ " hours | " + deadlineMin.getSelectedItem() + " minutes.");
		}
		
	}

	private void generateComboBoxVals(JComboBox approxJobHours, JComboBox deadlineHours,
			JComboBox approxJobMin, JComboBox deadlineMin) {
		for(int i=0; i<=48; i++) {
			approxJobHours.addItem(Integer.toString(i));
			deadlineHours.addItem(Integer.toString(i));
		}
		for(int i=0; i<=59; i++) {
			approxJobMin.addItem(Integer.toString(i));
			deadlineMin.addItem(Integer.toString(i));
		}
	}
}
