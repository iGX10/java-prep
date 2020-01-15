package com.company.sockets;

import java.io.IOException;

public class ClientMain2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientServer clientServer = new ClientServer();
        int[] tableau = {20, 17, 56, 10, 17};
        clientServer.sendData(tableau);
        clientServer.getData();
    }
}
