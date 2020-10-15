package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option extends JFrame implements ActionListener {
    JPanel firstPanel, secondPanel, thirdPanel;
    JButton client, owner, help, back;
    JLabel test1, test2;
    GridBagConstraints place = new GridBagConstraints();
    CardLayout swap;
    Container hold;
    
    public void panel1(){
        firstPanel = new JPanel();
        firstPanel.setLayout (new GridBagLayout());
        client = new JButton("Client");
        owner = new JButton("Owner");
        place.gridx = 0;
        place.gridy = 0;
        place.anchor = GridBagConstraints.CENTER;
        firstPanel.add(client, place);
        place.gridx--;
        place.gridy++;
        firstPanel.add(owner, place);
        
        createHelpButton();
        place.gridy++;
        firstPanel.add(help, place);
    }
    
    public void panel2(){
        secondPanel = new JPanel();
        secondPanel.setLayout (new GridBagLayout());
        test1 = new JLabel("Client area");
        place.gridx = 0;
        place.gridy = 0;
        secondPanel.add(test1, place);
        
        //button to return to the first panel
        createBackButton();
        place.gridy++;
        secondPanel.add(back, place);
        
    }
    
    public void panel3(){
        thirdPanel = new JPanel();
        thirdPanel.setLayout (new GridBagLayout());
        test2 = new JLabel("Owner area");
        place.gridx = 0;
        place.gridy = 0;
        thirdPanel.add(test2, place);
        
        //button to return to the first panel
        createBackButton();
        place.gridy++;
        thirdPanel.add(back, place);
        
    }
    
    //help instructions on first panel
    public void createHelpButton(){
    	help = new JButton("Help");
        help.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent event) {
        		String message = "Select Client or Owner.\nSelect client if you want to submit a job.\n"
        				+ "Select owner if you want to rent out your vehicle.";
        		JOptionPane.showMessageDialog(firstPanel, message);	
        	}
        });  
    }
    
    //back button
    public void createBackButton() {
    	back = new JButton("Back");
    	back.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent event) {
        		swap.first(hold);
        	}
        });
    }

    
    public void seeAction() {
        client.addActionListener(this);
        client.setActionCommand("Client");
        owner.addActionListener(this);
        owner.setActionCommand("Owner");
 
    }
    
    public Option() {
        this.setTitle("Milestone 2");
        this.setLocation(710, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel1();
        panel2();
        panel3();
        swap = new CardLayout();
        hold = getContentPane();
        hold.setLayout(swap);
        
        seeAction();

        this.setSize(500, 400);
        hold.add(firstPanel);
        hold.add(secondPanel);
        hold.add(thirdPanel);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Client":
                swap.next(hold);
                    break;
            case "Owner":
                swap.next(hold);
                swap.next(hold);
                break;
        }
    }
}
