package gui;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class OwnerFrame extends JFrame
implements ActionListener{
	
	private Container content;
	private JLabel ownerID;
	private JTextField ownerIDText;
	private JLabel vehInfoTitle;
	private JTextArea vehInfo;
	//approximate days & months for vehicle residency
	private JLabel approxRes;
	private JLabel approxDaysTitle;
	private JLabel approxMonsTitle;
	private JComboBox approxDays;
	private JComboBox approxMons;
	private JButton submit;
	private int xPosAlignLeft = 100;
	private int xPosAlignRight = 270;
	
	public OwnerFrame() {
		setTitle("Vehicle Owner Interface");
		setBounds(500, 90, 700, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        
        content = getContentPane();
        content.setLayout(null);
        
        ownerID = new JLabel("Owner ID");
        ownerID.setFont(new Font("Arial", Font.PLAIN, 15));
        ownerID.setSize(150, 20);
        ownerID.setLocation(xPosAlignLeft, 50);
        content.add(ownerID);
        
        ownerIDText = new JTextField();
        ownerIDText.setFont(new Font("Arial", Font.PLAIN, 20));
        ownerIDText.setSize(90, 20);
        ownerIDText.setLocation(xPosAlignRight, 50);
        content.add(ownerIDText);
        
        vehInfoTitle = new JLabel("Vehicle Information");
        vehInfoTitle.setFont(new Font("Arial", Font.PLAIN, 15));
        vehInfoTitle.setSize(150, 20);
        vehInfoTitle.setLocation(xPosAlignLeft, 130);
        content.add(vehInfoTitle);
        
        vehInfo = new JTextArea();
        vehInfo.setFont(new Font("Arial", Font.PLAIN, 12));
        vehInfo.setSize(300, 75);
        vehInfo.setLocation(xPosAlignRight, 130);
        content.add(vehInfo);
        
        approxRes = new JLabel("Approx. Residency");
        approxRes.setFont(new Font("Arial", Font.PLAIN, 15));
        approxRes.setSize(125, 20);
        approxRes.setLocation(xPosAlignLeft, 280);
        content.add(approxRes);
        
        approxDaysTitle = new JLabel("Days");
        approxDaysTitle.setFont(new Font("Arial", Font.PLAIN, 10));
        approxDaysTitle.setSize(60, 20);
        approxDaysTitle.setLocation(xPosAlignRight, 255);
        content.add(approxDaysTitle);
        
        approxMonsTitle = new JLabel("Months");
        approxMonsTitle.setFont(new Font("Arial", Font.PLAIN, 10));
        approxMonsTitle.setSize(60, 20);
        approxMonsTitle.setLocation(xPosAlignRight+65, 255);
        content.add(approxMonsTitle);
        
        approxDays = new JComboBox();
        approxDays.setFont(new Font("Arial", Font.PLAIN, 20));
        approxDays.setSize(60, 25);
        approxDays.setLocation(xPosAlignRight, 280);
        approxMons = new JComboBox();
        approxMons.setFont(new Font("Arial", Font.PLAIN, 20));
        approxMons.setSize(60, 25);
        approxMons.setLocation(xPosAlignRight+65, 280);
        generateComboBoxVals(approxDays, approxMons);
        content.add(approxDays);
        content.add(approxMons);
 
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
			System.out.println("Owner ID:");
			System.out.println(ownerIDText.getText() + '\n');
			System.out.println("Vehicle Info:");
			System.out.println(vehInfo.getText() + '\n');
			System.out.println("Expected days: " + approxDays.getSelectedItem() 
					+ " | Expected Months: " + approxMons.getSelectedItem());
		}
		
	}
	
	
	private void generateComboBoxVals(JComboBox approxDays, JComboBox approxMons) {
		for(int i=0; i<=30; i++) {
			approxDays.addItem(Integer.toString(i));
		}
		
		for(int i=0; i<=24; i++) {
			approxMons.addItem(Integer.toString(i));
		}
	}
	

}
