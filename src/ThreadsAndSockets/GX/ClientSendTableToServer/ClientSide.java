package ThreadsAndSockets.GX.ClientSendTableToServer;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    Socket socket = null;
    final static int port = 3333;

    InputStream in = null;
    OutputStream out = null;

    public ClientSide() throws IOException {
        socket = new Socket("127.0.0.1", port);

        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    private void sendData(int[] table) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(table);

        System.out.println("tableau envoyé au serveur");
    }

    private void receiveData() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Object obj = objectInputStream.readObject();


        System.out.println("Donnée reçu : " + obj);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientSide clientSide = new ClientSide();

        int[] table = {1, 2, 3, 4, 5};
        clientSide.sendData(table);
        clientSide.receiveData();
    }
}
