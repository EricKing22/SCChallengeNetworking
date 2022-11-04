package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Handler implements Runnable {
    Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        while (true) {
            try {
                InputStreamReader ir = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(ir);
                String out_message = br.readLine();
                if (out_message != null) {
                    System.out.println(out_message);
                }
            } catch (Exception e) {

            }
        }
    }
}
