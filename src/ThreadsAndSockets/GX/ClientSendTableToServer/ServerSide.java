package ThreadsAndSockets.GX.ClientSendTableToServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    ServerSocket serverSocket = null;
    Socket socket;
    final static int port = 3333;

    InputStream in = null;
    OutputStream out = null;

    public ServerSide() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Serveur est demarré");
    }

    public void acceptConnection() throws IOException {
        System.out.println("attendant d'une connexion...");
        socket = serverSocket.accept();

        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    public void endConnection() throws IOException {
        serverSocket.close();
    }

    public void receiveData() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        int[] table = (int[])objectInputStream.readObject();

        System.out.println("tableau reçu :");
        int tableSum = 0;
        for(int e: table) {
            System.out.println(e);
            tableSum += e;
        }

        sendData(tableSum);
    }

    public void sendData(int tableSum) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(tableSum);

        System.out.println("la somme du tableau est envoyé au client");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSide serverSide = new ServerSide();
        serverSide.acceptConnection();

        serverSide.receiveData();

        serverSide.endConnection();
    }
}
