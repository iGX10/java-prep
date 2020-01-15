package com.company.sockets;
import com.company.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final static int port = 3000;
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
    }
    /*
    public void getData() throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(inputStream);
        int somme = 0;
        int[] tableau = (int[]) objectInputStream.readObject();
        System.out.println(tableau);
        for (int value : tableau) {
            somme += value;
        }
        sendData(somme);
    }

    public void sendData(int somme) throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(somme);

    }
    */
    public void acceptConnection() throws IOException, ClassNotFoundException {
        socket = serverSocket.accept();


        ServerThread serverThread = new ServerThread(socket);
        System.out.println(serverThread.getName());
        serverThread.start();


    /*public void getData() throws IOException, ClassNotFoundException{
        Client client = (Client) objectInputStream.readObject();
        objectOutputStream.writeObject("Client envyoyé avec succès");
        System.out.println(client);
    }*/
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        System.out.println("Server Connected ....");
        while(true) {
            server.acceptConnection();
            //server.getData();
        }

    }

}
