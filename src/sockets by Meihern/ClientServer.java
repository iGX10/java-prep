package com.company.sockets;

import com.company.Client;

import java.io.*;
import java.net.Socket;

public class ClientServer {
    private final static int port = 3000;
    private final static String address = "127.0.0.1";
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

     ClientServer() throws IOException {
        socket = new Socket(address, port);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();

    }

     void sendData(int[] tableau) throws IOException {
        /*client = new Client(1,"Achir", "Youssef");
        System.out.println(client);*/
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(tableau);
        //System.out.println(objectOutputStream);

    }



    void getData() throws IOException, ClassNotFoundException{
        objectInputStream = new ObjectInputStream(inputStream);
        //String string = (String) objectInputStream.readObject();
        System.out.println(objectInputStream.readObject());
      //  close();
    }

    /*void close() throws IOException {
        outputStream.flush();
        objectOutputStream.close();
    }*/


}
