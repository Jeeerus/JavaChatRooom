/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Jairus
 */
public class Client extends JFrame {
    public static final String HOST_NAME = "localhost";
    public static final int HOST_PORT = 19908;
    private ClientJoinPanel clientJoinPanel;
    private ClientChatPanel clientChatPanel;
    private String name;
    private PrintWriter outputStream;
    private BufferedReader inputStream;
    
    public Client(){
        super("Chat Room");
        setSize(300,500);
        
        this.name = "Guest";
        
        clientJoinPanel = new ClientJoinPanel(name);
        clientChatPanel = new ClientChatPanel();
        clientChatPanel.setVisible(false);
        
        add(clientJoinPanel);
        add(clientChatPanel);
        
        
        clientActionListeners();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void clientActionListeners() {
        clientJoinPanel.getJoinButton().addActionListener((ActionEvent ae) -> {
            System.out.println("Join Pressed");
            clientJoinPanel.setVisible(false);
            clientChatPanel.setVisible(true);
            connectToServer();
        });
        
        clientChatPanel.getSendButton().addActionListener((ActionEvent ae) -> {
            System.out.println("Send MSG Pressed");
            String msg = clientChatPanel.getMessageField().getText();
            clientChatPanel.getMessageField().setText("");
            sendMessage(msg);
        });
    }
    
    // Connects the Client to the server once the user has clicked Join
    public void connectToServer(){
        Socket socket = null;
        
        // Try to make a connection with the server
        try {
            socket = new Socket(HOST_NAME, HOST_PORT);
        } catch (IOException e){
            System.out.println("You could not connect :(");
            System.exit(-1);
        }
        System.out.println("Connected??");
        boolean isConnected = true;
        
        // Creating the IO Streams
        try {
            outputStream = new PrintWriter(socket.getOutputStream(), true);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch(IOException e){
            System.out.println("Server Connection Error");
        }
    }
    
    private void sendMessage(String msg){
        try{
            outputStream.println("Client: " + msg);
            outputStream.flush();
        } catch(Exception e){
            System.out.println("Error Sending Message");
        }
        
    }
    
    public static void main(String[] args) {
        Client c = new Client();
        c.setVisible(true);
    }
}
