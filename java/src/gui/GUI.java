package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	                    
    private void initComponents() {

        root = new JPanel();
        sideNavigation = new JPanel();
        homeNavButton = new JButton();
        clientNavButton = new JButton();
        ownerNavButton = new JButton();
        helpButton = new JButton();
        focusedPanel = new JPanel();
        homePanel = new JPanel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel15 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        Home1 = new JButton();
        Client1 = new JButton();
        Owner1 = new JButton();
        Help = new JButton();
        clientPanel = new JPanel();
        clientIDLabel = new JLabel();
        clientID = new JTextField();
        jobInfoLabel = new JLabel();
        jobInfo = new java.awt.TextArea();
        approxTimeLabel = new JLabel();
        hourLabel = new JLabel();
        minuteLabel = new JLabel();
        deadlineLabel = new JLabel();
        approxJobHours = new JComboBox<>();
        approxJobMin = new JComboBox<>();
        deadlineHours = new JComboBox<>();
        deadlineMin = new JComboBox<>();
        clientSubmit = new JButton();
        ownerPanel = new JPanel();
        ownerIDLabel = new JLabel();
        ownerID = new JTextField();
        vehModelLabel = new JLabel();
        vehModel = new JTextField();
        vehPlateLabel = new JLabel();
        vehPlate = new JTextField();
        vehColorLabel = new JLabel();
        vehColor = new JComboBox<>();
        approxResLabel = new JLabel();
        approxMonsLabel = new JLabel();
        approxMons = new JComboBox<>();
        approxDaysLabel = new JLabel();
        approxDays = new JComboBox<>();
        ownerSubmit = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        root.setBackground(new java.awt.Color(34, 40, 44));
        root.setLayout(new java.awt.BorderLayout());

        sideNavigation.setBackground(new java.awt.Color(21, 25, 28));
        sideNavigation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sideNavigation.setPreferredSize(new java.awt.Dimension(80, 0));
        sideNavigation.setRequestFocusEnabled(false);

        homeNavButton.setBackground(new java.awt.Color(34, 40, 44));
        homeNavButton.setForeground(new java.awt.Color(250, 0, 0));
        homeNavButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_home_100px.png"))); // NOI18N
        homeNavButton.setPreferredSize(new java.awt.Dimension(60, 60));
        homeNavButton.setActionCommand("HOME");
        homeNavButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homeNavButtonActionPerformed(evt);
            }
        });
        homeNavButton.addActionListener(this);
        sideNavigation.add(homeNavButton);

        clientNavButton.setBackground(new java.awt.Color(34, 40, 44));
        clientNavButton.setForeground(new java.awt.Color(250, 0, 0));
        clientNavButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_person_70px_1.png"))); // NOI18N
        clientNavButton.setPreferredSize(new java.awt.Dimension(60, 60));
        clientNavButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        clientNavButton.setActionCommand("CLIENT");
        clientNavButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clientNavButtonActionPerformed(evt);
            }
        });
        clientNavButton.addActionListener(this);
        sideNavigation.add(clientNavButton);

        ownerNavButton.setBackground(new java.awt.Color(34, 40, 44));
        ownerNavButton.setForeground(new java.awt.Color(250, 0, 0));
        ownerNavButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_car_70px.png"))); // NOI18N
        ownerNavButton.setPreferredSize(new java.awt.Dimension(60, 60));
        ownerNavButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        ownerNavButton.setActionCommand("OWNER");
        ownerNavButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ownerNavButtonActionPerformed(evt);
            }
        });
        ownerNavButton.addActionListener(this);
        sideNavigation.add(ownerNavButton);

        helpButton.setBackground(new java.awt.Color(34, 40, 44));
        helpButton.setForeground(new java.awt.Color(250, 0, 0));
        helpButton.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_help_70px.png"))); // NOI18N
        helpButton.setPreferredSize(new java.awt.Dimension(60, 60));
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        sideNavigation.add(helpButton);

        root.add(sideNavigation, java.awt.BorderLayout.LINE_START);

        focusedPanel.setBackground(new java.awt.Color(34, 40, 44));
        focusedPanel.setPreferredSize(new java.awt.Dimension(1153, 582));
        focusedPanel.setLayout(new java.awt.CardLayout());
        
        
        
        homePanel.setBackground(new java.awt.Color(34, 40, 44));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Heres the Icon Key Code:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Welcome to Milestone 2");

        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Help");

        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Vehicle owner");

        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Home(this screen)");

        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Client");

        Home1.setBackground(new java.awt.Color(34, 40, 44));
        Home1.setForeground(new java.awt.Color(250, 0, 0));
        Home1.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_home_100px.png"))); // NOI18N
        Home1.setPreferredSize(new java.awt.Dimension(60, 60));
        Home1.setActionCommand("HOME");
        Home1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });
        Home1.addActionListener(this);

        Client1.setBackground(new java.awt.Color(34, 40, 44));
        Client1.setForeground(new java.awt.Color(250, 0, 0));
        Client1.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_person_70px_1.png"))); // NOI18N
        Client1.setPreferredSize(new java.awt.Dimension(60, 60));
        Client1.setVerticalTextPosition(SwingConstants.BOTTOM);
        Client1.setActionCommand("CLIENT");
        Client1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Client1ActionPerformed(evt);
            }
        });
        Client1.addActionListener(this);

        Owner1.setBackground(new java.awt.Color(34, 40, 44));
        Owner1.setForeground(new java.awt.Color(250, 0, 0));
        Owner1.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_car_70px.png"))); // NOI18N
        Owner1.setPreferredSize(new java.awt.Dimension(60, 60));
        Owner1.setVerticalTextPosition(SwingConstants.BOTTOM);
        Owner1.setActionCommand("OWNER");
        Owner1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Owner1ActionPerformed(evt);
            }
        });
        Owner1.addActionListener(this);

        Help.setBackground(new java.awt.Color(34, 40, 44));
        Help.setForeground(new java.awt.Color(250, 0, 0));
        Help.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_help_70px.png"))); // NOI18N
        Help.setPreferredSize(new java.awt.Dimension(60, 60));
        Help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	helpButtonActionPerformed(evt);
            }
        });
        Help.addActionListener(this);
        
        GroupLayout homePanelLayout = new GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel17))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel16))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(Home1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Client1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Owner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel15))
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Help, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(490, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15))
                .addGap(39, 39, 39)
                .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(Owner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Client1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Help, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(Home1, GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
                        .addGap(131, 131, 131))))
        );

        focusedPanel.add(homePanel, "HOME");
      
        clientPanel.setBackground(new java.awt.Color(34, 40, 44));
        clientIDLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clientIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        clientIDLabel.setText("Client ID:");

        jobInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jobInfoLabel.setForeground(new java.awt.Color(204, 204, 204));
        jobInfoLabel.setText("Job Info");

        approxTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        approxTimeLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxTimeLabel.setText("Estimated Job Time");
        approxTimeLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        hourLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hourLabel.setForeground(new java.awt.Color(204, 204, 204));
        hourLabel.setText("Hours");
        hourLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        minuteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minuteLabel.setForeground(new java.awt.Color(204, 204, 204));
        minuteLabel.setText("Minutes");
        minuteLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        deadlineLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deadlineLabel.setForeground(new java.awt.Color(204, 204, 204));
        deadlineLabel.setText("Deadline");
        deadlineLabel.setPreferredSize(new java.awt.Dimension(130, 29));

        approxJobHours.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        approxJobHours.setSelectedItem(approxJobHours);

        approxJobMin.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        approxJobMin.setSelectedItem(approxJobMin);

        deadlineHours.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        deadlineHours.setSelectedItem(deadlineHours);

        deadlineMin.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
        deadlineMin.setSelectedItem(deadlineMin);

        clientSubmit.setBackground(new java.awt.Color(34, 40, 44));
        clientSubmit.setForeground(new java.awt.Color(250, 0, 0));
        clientSubmit.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_submit_for_approval_100px_1.png"))); // NOI18N
        clientSubmit.setOpaque(false);
        clientSubmit.setPreferredSize(new java.awt.Dimension(60, 60));
        clientSubmit.setVerticalTextPosition(SwingConstants.BOTTOM);
        clientSubmit.setActionCommand("HOME");
        clientSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clientSubmitActionPerformed(evt);
            }
        });
        clientSubmit.addActionListener(this);

        GroupLayout clientPanelLayout = new GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(clientIDLabel)
                            .addComponent(jobInfoLabel))
                        .addGap(60, 60, 60)
                        .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(clientID)
                            .addComponent(jobInfo, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(approxTimeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                            .addComponent(deadlineLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                        .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(clientPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(deadlineHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deadlineMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(clientPanelLayout.createSequentialGroup()
                                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(clientPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(hourLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(clientPanelLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(approxJobHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(clientPanelLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(clientPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(approxJobMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(582, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(clientSubmit, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(clientIDLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jobInfoLabel))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jobInfo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(hourLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(approxTimeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(approxJobMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(approxJobHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(clientPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(deadlineLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadlineHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadlineMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127)
                .addComponent(clientSubmit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        generateComboBoxVals(approxJobHours, deadlineHours, approxJobMin, deadlineMin);

        focusedPanel.add(clientPanel, "CLIENT");

        
        ownerPanel.setBackground(new java.awt.Color(34, 40, 44));
        ownerIDLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ownerIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        ownerIDLabel.setText("Owner ID:");

        vehModelLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehModelLabel.setForeground(new java.awt.Color(204, 204, 204));
        vehModelLabel.setText("Vehicle Model:");

        vehPlateLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehPlateLabel.setForeground(new java.awt.Color(204, 204, 204));
        vehPlateLabel.setText("Vehicle Plate#:");

        vehColorLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        vehColorLabel.setForeground(new java.awt.Color(204, 204, 204));
        vehColorLabel.setText("Color:");

        vehColor.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));

        approxResLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        approxResLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxResLabel.setText("Approx. Residency");

        approxMonsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        approxMonsLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxMonsLabel.setText("Months");

        approxMons.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));

        approxDaysLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        approxDaysLabel.setForeground(new java.awt.Color(204, 204, 204));
        approxDaysLabel.setText("Days");

        approxDays.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));

        ownerSubmit.setBackground(new java.awt.Color(34, 40, 44));
        ownerSubmit.setForeground(new java.awt.Color(250, 0, 0));
        ownerSubmit.setIcon(new ImageIcon(getClass().getResource("/icons/icons8_submit_for_approval_100px_1.png"))); // NOI18N
        ownerSubmit.setOpaque(false);
        ownerSubmit.setPreferredSize(new java.awt.Dimension(60, 60));
        ownerSubmit.setVerticalTextPosition(SwingConstants.BOTTOM);
        ownerSubmit.setActionCommand("HOME");
        ownerSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ownerSubmitActionPerformed(evt);
            }
        });
        ownerSubmit.addActionListener(this);

        GroupLayout ownerPanelLayout = new GroupLayout(ownerPanel);
        ownerPanel.setLayout(ownerPanelLayout);
        ownerPanelLayout.setHorizontalGroup(
            ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ownerPanelLayout.createSequentialGroup()
                .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(ownerPanelLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vehModelLabel)
                            .addComponent(ownerIDLabel)
                            .addComponent(vehPlateLabel)
                            .addComponent(vehColorLabel)
                            .addComponent(approxResLabel))
                        .addGap(28, 28, 28)
                        .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(ownerID, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vehModel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, ownerPanelLayout.createSequentialGroup()
                            .addGap(333, 333, 333)
                            .addComponent(vehPlate, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                        .addGroup(ownerPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(ownerPanelLayout.createSequentialGroup()
                                    .addComponent(approxMons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(approxDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(vehColor, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addGroup(ownerPanelLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(approxMonsLabel)
                                    .addGap(50, 50, 50)
                                    .addComponent(approxDaysLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(653, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, ownerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ownerSubmit, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        ownerPanelLayout.setVerticalGroup(
            ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ownerPanelLayout.createSequentialGroup()
                .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, ownerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(ownerIDLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerID, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114))
                    .addGroup(ownerPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(vehModel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(vehModelLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(vehPlate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehPlateLabel))
                .addGap(36, 36, 36)
                .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vehColorLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(approxDaysLabel)
                    .addComponent(approxMonsLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ownerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(approxResLabel)
                    .addComponent(approxMons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(approxDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(ownerSubmit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        generateComboBoxVals(vehColor,approxDays, approxMons);
        focusedPanel.add(ownerPanel, "OWNER");
        
        root.add(focusedPanel, java.awt.BorderLayout.LINE_END);
        getContentPane().add(root, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>                        

	
	private void helpButtonActionPerformed(ActionEvent evt) {                                           
		String message = "Select Client or Owner.\nSelect client if you want to submit a job.\n"
				+ "Select owner if you want to rent out your vehicle.";
		JOptionPane.showMessageDialog(focusedPanel, message);
	}                                          

	private void ownerNavButtonActionPerformed(ActionEvent evt) {                                               
	      
	}                                              

	private void Home1ActionPerformed(ActionEvent evt) {                                      
	        
	}                                     

	private void Client1ActionPerformed(ActionEvent evt) {                                        
	        
	}                                       

	private void Owner1ActionPerformed(ActionEvent evt) {                                       
	        
	}                                      
	
	    
	private void clientNavButtonActionPerformed(ActionEvent evt) {                                                
	       
	}                                               

	private void homeNavButtonActionPerformed(ActionEvent evt) {                                              
	        clearInfo();
	}                                             
	    
	    
	private void clientSubmitActionPerformed(ActionEvent evt) {                                             
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String[] tempArr = {clientID.getText(), jobInfo.getText(), (String)approxJobHours.getSelectedItem(), (String)approxJobMin.getSelectedItem(),
							(String)deadlineHours.getSelectedItem(), (String)deadlineMin.getSelectedItem(), timeStamp};
		clientEntries.add(tempArr);
		System.out.println("Success!");
		System.out.println("Client ID:");
		System.out.println(clientID.getText() + '\n');
		UUID jobID= UUID.randomUUID();
		System.out.println("Job ID: " + jobID + '\n');
		System.out.println("Job Information: " + jobInfo.getText() + '\n');
		System.out.println("Expected job time: " + approxJobHours.getSelectedItem() + " hours | "
				+ approxJobMin.getSelectedItem() + " minutes.");
		System.out.println("Deadline: " + deadlineHours.getSelectedItem() + " hours | "
				+ deadlineMin.getSelectedItem() + " minutes.");
		
		//resets info for next use
		clearInfo();
    }
	    
	    
	private void ownerSubmitActionPerformed(ActionEvent evt) {                                            
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String[] tempArr = {ownerID.getText(), vehModel.getText(), (String)vehColor.getSelectedItem(),
							vehPlate.getText(), (String)approxDays.getSelectedItem(), (String)approxMons.getSelectedItem(), timeStamp};
		//adding the temporary data array to the total client entries for file writing at later point 
		ownerEntries.add(tempArr);
		System.out.println("Success!");
		System.out.println("Owner ID: ");
		System.out.println(ownerID.getText() + '\n');
		System.out.println("Vehicle Model: ");
		System.out.println(vehModel.getText() + '\n');
		System.out.println("Vehicle Color: " + vehColor.getSelectedItem() + '\n');
		System.out.println("Vehicle Plate #: "+ vehPlate.getText() + '\n');
		System.out.println("Expected days: " + approxDays.getSelectedItem() 
				+ " | Expected Months: " + approxMons.getSelectedItem());
		//resets information for next use
		clearInfo();
	}                                           
	
	/*
	 * This function is implemented through the ActionListener interface and 
	 * will handle swapping jPanels through the card layout made implemented in the 
	 * focused content panel, for now
	 */
	
	@Override
	public void actionPerformed(ActionEvent event) {
		CardLayout cl = (CardLayout)(focusedPanel.getLayout());
	    cl.show(focusedPanel, (String)event.getActionCommand());
	}

	/*
	 * The constructor of the main GUI panel. 
	 */
	public GUI() {
		this.setTitle("Milestone 2");
		initComponents();
		//generate the logs upon the window to be exited.. save on I/O
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        generateLogs();
		    }
		});
		this.setVisible(true);
	}
	
	
	/*
	 * Handles clearing information after each entry
	 */
	private void clearInfo() {
		//client info clear
		clientID.setText(null);
		jobInfo.setText(null);
		approxJobHours.setSelectedIndex(0);
		approxJobMin.setSelectedIndex(0);
		deadlineHours.setSelectedIndex(0);
		deadlineMin.setSelectedIndex(0);
		
		//owner info clear
		ownerID.setText(null);
		vehModel.setText(null);
		vehPlate.setText(null);
		vehColor.setSelectedIndex(0);
		approxDays.setSelectedIndex(0);
		approxMons.setSelectedIndex(0);
	}

	
	/*
	 * Functions to automate the generation of integer dependent combo box values. 
	 */
	private void generateComboBoxVals(JComboBox vehColorBox, JComboBox approxDays, JComboBox approxMons) {
		for(int i=0; i<colors.length; i++) {
			vehColorBox.addItem(colors[i]);
		}
		
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
	
	/*
	 * Log generation for the Vehicle Cloud Controller. There is a dynamic file name therefore no file conflicts.
	 */
	public void generateLogs() {
		//client logs
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		if (clientEntries.isEmpty() != true) {		
			try {
				FileWriter csvWriter = new FileWriter("logs/CLIENT_LOGS_"+timeStamp+".csv");
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
		}
		//owner logs
		if (ownerEntries.isEmpty() != true) {
			try {		
				FileWriter csvWriter = new FileWriter("logs/OWNER_LOGS_"+timeStamp+".csv");
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
	
    // Variables declarations                 
    private JButton Client1;
    private JButton Help;
    private JButton Home1;
    private JButton Owner1;
    private JComboBox<String> approxDays;
    private JLabel approxDaysLabel;
    private JComboBox<String> approxJobHours;
    private JComboBox<String> approxJobMin;
    private JComboBox<String> approxMons;
    private JLabel approxMonsLabel;
    private JLabel approxResLabel;
    private JLabel approxTimeLabel;
    private JTextField clientID;
    private JLabel clientIDLabel;
    private JButton clientNavButton;
    private JPanel clientPanel;
    private JButton clientSubmit;
    private JComboBox<String> deadlineHours;
    private JLabel deadlineLabel;
    private JComboBox<String> deadlineMin;
    private JPanel focusedPanel;
    private JButton helpButton;
    private JButton homeNavButton;
    private JPanel homePanel;
    private JLabel hourLabel;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private TextArea jobInfo;
    private JLabel jobInfoLabel;
    private JLabel minuteLabel;
    private JTextField ownerID;
    private JLabel ownerIDLabel;
    private JButton ownerNavButton;
    private JPanel ownerPanel;
    private JButton ownerSubmit;
    private JPanel root;
    private JPanel sideNavigation;
    private JComboBox<String> vehColor;
    private JLabel vehColorLabel;
    private JTextField vehModel;
    private JLabel vehModelLabel;
    private JTextField vehPlate;
    private JLabel vehPlateLabel;
    private CardLayout panelSwapper;
    private String[] colors= {"White", "Black", "Grey", "Silver", "Green", "Red", "Blue", "Yellow", "Purple", "Pink", "Orange", "Other"};
	private ArrayList<String[]> ownerEntries = new ArrayList<>();
	private ArrayList<String[]> clientEntries = new ArrayList<>();
	
    // End of variables declaration                  


	
	
}
