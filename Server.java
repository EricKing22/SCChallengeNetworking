import java.io.IOException;
import java.net.*;
import  java.io.*;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4399);
        Socket s = ss.accept();

        System.out.println("client connected");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String line = bf.readLine();
        System.out.println("Client" + line);
    }
}
