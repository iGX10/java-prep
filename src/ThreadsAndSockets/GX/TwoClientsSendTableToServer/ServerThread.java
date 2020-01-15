package ThreadsAndSockets.GX.TwoClientsSendTableToServer;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket;

    InputStream in;
    OutputStream out;

    public ServerThread(Socket socket) throws IOException {
        System.out.println("Client : " + socket + " est connecté!");
        this.socket = socket;

        in = this.socket.getInputStream();
        out = this.socket.getOutputStream();

        start();
    }

    private void endConnection() throws IOException {
        out.close();
        socket.close();
        System.out.println("ServerThread : " + socket + " ended!");
    }

    public void receiveData() throws IOException, ClassNotFoundException {
        int tableSum;
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Object object = objectInputStream.readObject();
        while(object != null) {
            int[] table = (int[])object;
            //System.out.println("Tableau reçu : ");
            //for(int e: table)
            //    System.out.println(e);
            tableSum = sum(table);

            // send data back
            sendDate(tableSum);
            object = objectInputStream.readObject();
        }
    }

    private int sum(int[] table) {
        int sum = 0;
        for(int e: table)
            sum += e;

        return sum;
    }

    private void sendDate(int sum) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject("La somme du tableau : " + sum);
    }

    @Override
    public void run() {
        try {
            receiveData();
            endConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
