package com.company.sockets;

import com.company.Client;

import java.io.IOException;

public class ClientMain1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientServer clientServer = new ClientServer();
        int[] tableau = {1, 5 , 6, 10, 17};
        clientServer.sendData(tableau);
        clientServer.getData();
    }
}
