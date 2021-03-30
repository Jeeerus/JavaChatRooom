/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jairus
 */
public class ChatServer {
    ArrayList<Socket> clientConnections;
    ArrayList<Client> clientList;
    public static final int PORT = 19908;
    private boolean stopServer;
    
    public ChatServer(){
        this.clientConnections = new ArrayList<Socket>();
        this.clientList = new ArrayList<Client>();
        this.stopServer = false;
    }
    
    public void startServer() {
        ServerSocket serverSocket = null;
        
        // Starts the public server
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started\n" + 
                    "Port: " + PORT + 
                    "\nIP: " + InetAddress.getLocalHost());
        } catch (IOException ex) {
            System.out.println("Server could not be made.");
            System.exit(-1);
        }
        
        // Keeps looping for Clients to connect. Keeps creating Sockets per Client Join
        try {
            while(!stopServer){
                Socket socket = serverSocket.accept();
                System.out.println("Connection Made With: " + 
                        socket.getInetAddress());
                clientConnections.add(socket);
                
                ServerThread st = new ServerThread(socket);
                Thread thread = new Thread(st);
                thread.start();
                
            }
        } catch (IOException e){
            System.out.println("Client Connection Could Not Be Made");
        }
    }
    
    // Thread for sending text to specified clients
    private class ServerThread implements Runnable {
        private Socket socket;
        private boolean stayConnected = true;
        
        public ServerThread(Socket s){
            this.socket = s;
        }

        @Override
        public void run() {
            PrintWriter outputStream;
            BufferedReader inputStream;
            
            try {
                outputStream = new PrintWriter(socket.getOutputStream(), true);
                inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                do {
                    outputStream.println("EEPEE");
                    String s = inputStream.readLine();
                
                    System.out.println(s);
                } while(stayConnected);
                
            } catch(IOException e){
                System.out.println("User has Disconnected : " + socket.getInetAddress());
            }    
        }
    }
    
    public static void main(String[] args) {
        ChatServer cs = new ChatServer();
        cs.startServer();
    }
}
