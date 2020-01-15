package ThreadsAndSockets.GX.TwoClientsSendTableToServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    Socket socket;
    final static int port = 3333;

    InputStream in;
    OutputStream out;

    public ClientSide() throws IOException {
        socket = new Socket("127.0.0.1", port);

        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    private void sendData() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int taille = -1;
        int[] table;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        while(taille != 0) {
            System.out.println("Donner la taille d'un tableau (0 pour finir) : ");
            taille = scanner.nextInt();
            if(taille != 0) {
                table = new int[taille];

                for(int i = 0; i<taille; i++) {
                    table[i] = i;
                }

                objectOutputStream.writeObject(table);

                // recevoir la somme
                System.out.println(receiveDate());
            }
            else {
                objectOutputStream.writeObject(null);
            }
        }
    }

    public String receiveDate() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        return (String)objectInputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientSide clientSide = new ClientSide();
        clientSide.sendData();
    }
}
