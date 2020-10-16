package gui;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class OwnerFrame extends JFrame
implements ActionListener{
	 
	private Container content;
	private JLabel ownerID;
	private JTextField ownerIDText;
	private JLabel vehModel;
	private JTextField vehModelText;
	private JLabel vehColor;
	private JComboBox vehColorBox;
	private JLabel vehLicense;
	private JTextField vehLicenseText;
	//approximate days & months for vehicle residency
	private JLabel approxRes;
	private JLabel approxDaysTitle;
	private JLabel approxMonsTitle;
	private JComboBox approxDays;
	private JComboBox approxMons;
	private JButton submit;
	private int xPosAlignLeft = 100;
	private int xPosAlignRight = 300;
	private String[] colors= {"White", "Black", "Grey", "Silver", "Green", "Red", "Blue", "Yellow", "Purple", "Pink", "Orange", "Other"};
	
	public OwnerFrame() {
		setTitle("Vehicle Owner Interface");
		setBounds(500, 90, 700, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        content = getContentPane();
        content.setLayout(null);
        
        ownerID = new JLabel("Owner ID");
        ownerID.setFont(new Font("Arial", Font.BOLD, 15));
        ownerID.setSize(150, 20);
        ownerID.setLocation(xPosAlignLeft, 50);
        content.add(ownerID);
        
        ownerIDText = new JTextField();
        ownerIDText.setFont(new Font("Arial", Font.PLAIN, 18));
        ownerIDText.setSize(90, 20);
        ownerIDText.setLocation(xPosAlignRight, 50);
        content.add(ownerIDText);
        
        vehModel = new JLabel("Vehicle Model");
        vehModel.setFont(new Font("Arial", Font.BOLD, 15));
        vehModel.setSize(150, 20);
        vehModel.setLocation(xPosAlignLeft, 130);
        content.add(vehModel);
        
        vehModelText = new JTextField();
        vehModelText.setFont(new Font("Arial", Font.PLAIN, 18));
        vehModelText.setSize(175, 20);
        vehModelText.setLocation(xPosAlignRight, 130);
        content.add(vehModelText);
        
        vehColor = new JLabel("Vehicle Color");
        vehColor.setFont(new Font("Arial", Font.BOLD, 15));
        vehColor.setSize(150, 20);
        vehColor.setLocation(xPosAlignLeft, 185);
        content.add(vehColor);
        
        vehColorBox = new JComboBox();
        vehColorBox.setFont(new Font("Arial", Font.PLAIN, 18));
        vehColorBox.setSize(100, 25);
        vehColorBox.setLocation(xPosAlignRight, 185);
        insertColors(vehColorBox);
        content.add(vehColorBox);
        
        vehLicense = new JLabel("Vehicle Plate #");
        vehLicense.setFont(new Font("Arial", Font.BOLD, 15));
        vehLicense.setSize(150, 20);
        vehLicense.setLocation(xPosAlignLeft, 255);
        content.add(vehLicense);
        
        vehLicenseText = new JTextField();
        vehLicenseText.setFont(new Font("Arial", Font.PLAIN, 18));
        vehLicenseText.setSize(100, 20);
        vehLicenseText.setLocation(xPosAlignRight, 255);
        content.add(vehLicenseText);
        
        approxRes = new JLabel("Approx. Residency");
        approxRes.setFont(new Font("Arial", Font.BOLD, 15));
        approxRes.setSize(150, 20);
        approxRes.setLocation(xPosAlignLeft, 315);
        content.add(approxRes);
        
        approxDaysTitle = new JLabel("Days");
        approxDaysTitle.setFont(new Font("Arial", Font.PLAIN, 10));
        approxDaysTitle.setSize(60, 20);
        approxDaysTitle.setLocation(xPosAlignRight, 295);
        content.add(approxDaysTitle);
        
        approxMonsTitle = new JLabel("Months");
        approxMonsTitle.setFont(new Font("Arial", Font.PLAIN, 10));
        approxMonsTitle.setSize(60, 20);
        approxMonsTitle.setLocation(xPosAlignRight+65, 295);
        content.add(approxMonsTitle);
        
        approxDays = new JComboBox();
        approxDays.setFont(new Font("Arial", Font.PLAIN, 18));
        approxDays.setSize(60, 25);
        approxDays.setLocation(xPosAlignRight, 315);
        approxMons = new JComboBox();
        approxMons.setFont(new Font("Arial", Font.PLAIN, 18));
        approxMons.setSize(60, 25);
        approxMons.setLocation(xPosAlignRight+65, 315);
        generateComboBoxVals(approxDays, approxMons);
        content.add(approxDays);
        content.add(approxMons);
 
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 18));
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
			System.out.println("Owner ID: ");
			System.out.println(ownerIDText.getText() + '\n');
			System.out.println("Vehicle Model: ");
			System.out.println(vehModelText.getText() + '\n');
			System.out.println("Vehicle Color: " + vehColorBox.getSelectedItem() + '\n');
			System.out.println("Vehicle Plate #: "+ vehLicenseText.getText() + '\n');
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
	
	private void insertColors(JComboBox vehColorBox) {
		for(int i=0; i<colors.length; i++) {
			vehColorBox.addItem(colors[i]);
		}
	}
}
