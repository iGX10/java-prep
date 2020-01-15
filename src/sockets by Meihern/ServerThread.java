package com.company.sockets;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }
    private int[] getData() throws IOException, ClassNotFoundException {
        objectInputStream = new ObjectInputStream(inputStream);
        return (int[]) objectInputStream.readObject();
    }

    private void sendData(int somme) throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject("Somme = "+somme);
    }

    private void closeThread() throws IOException {
        outputStream.close();
        inputStream.close();
        objectInputStream.close();
        objectOutputStream.close();
        socket.close();
    }

    @Override
    public void run(){
        int somme = 0;
        try {
            int[] tableau = getData();
            for (int value : tableau) {
                somme += value;
            }
            sendData(somme);
            //closeThread();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
