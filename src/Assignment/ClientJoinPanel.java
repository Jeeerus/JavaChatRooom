/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Jairus
 */
public class ClientJoinPanel extends JPanel{
    private JButton joinButton;
    private JTextField clientName;
    private JLabel nameLabel;
    
    public ClientJoinPanel(String name){
        setLayout(null);
        setSize(300, 500);
        
        // Asset Settings and Placements
        nameLabel = new JLabel("Client Name");
        nameLabel.setBounds(113, 220, 150, 25);
        
        clientName = new JTextField(name);
        clientName.setPreferredSize(new Dimension(100,30));
        clientName.setBounds(75,250,150,25);
        
        joinButton = new JButton("Join");
        joinButton.setBounds(100, 300, 100, 30);
        
        add(nameLabel);
        add(clientName);
        add(joinButton);
    }

    public JButton getJoinButton() {
        return joinButton;
    }

    public void setJoinButton(JButton joinButton) {
        this.joinButton = joinButton;
    }

    public JTextField getClientName() {
        return clientName;
    }

    public void setClientName(JTextField clientName) {
        this.clientName = clientName;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }
    
    
    
}
