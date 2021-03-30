/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jairus
 */
public class ClientChatPanel extends JPanel {
    private JTextField messageField;
    private JButton sendButton;
    
    public ClientChatPanel(){
        setSize(300,500);
        setLayout(null);
        setVisible(false);
        
        messageField = new JTextField();
        messageField.setPreferredSize(new Dimension(100,30));
        messageField.setBounds(50,50,100,30);
        
        sendButton = new JButton(">");
        sendButton.setPreferredSize(new Dimension(30,30));
        sendButton.setBounds(10,10,30,30);
        
        add(messageField);
        add(sendButton);
    }

    public JTextField getMessageField() {
        return messageField;
    }

    public void setMessageField(JTextField messageField) {
        this.messageField = messageField;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }
    
    
}
