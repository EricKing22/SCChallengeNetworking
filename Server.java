package week4;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server extends Thread{

    Socket socket;
    ServerSocket serverSocket;


    static ArrayList<Socket> sockets;

    public Server() throws IOException {
        serverSocket = new ServerSocket(4399);
        sockets = new ArrayList<>();
    }

    @Override
    public void run() {
        while(true) {
            try {
                socket = serverSocket.accept();
                System.out.println("A new client is connected");
                sockets.add(socket);
                System.out.println("Number of activating users: " + sockets.size());
                // Thread
                Handler handler = new Handler(socket);
                new Thread(handler).start();
            } catch (Exception e) {

            }
        }


    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start();




    }
}
