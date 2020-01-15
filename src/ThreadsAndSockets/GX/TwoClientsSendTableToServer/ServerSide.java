package ThreadsAndSockets.GX.TwoClientsSendTableToServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

public class ServerSide {
    ServerSocket serverSocket;
    final static int port = 3333;

    public ServerSide() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Serveur est démarré");
    }

    public void acceptConnection() throws IOException {
        System.out.println("En attendant une connexion ...");
        new ServerThread(serverSocket.accept());
    }

    public static void main(String[] args) throws IOException {
        ServerSide serverSide = new ServerSide();

        while(true) {
            serverSide.acceptConnection();
        }
    }
}
