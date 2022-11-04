import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    String username;
    String in_message;
    Socket s;


    public Client() throws IOException {
        System.out.println("Welcome. Please enter your username:");
        Scanner scanner = new Scanner(System.in);
        this.username = scanner.nextLine();
        this.in_message = "";
        s = new Socket("localhost", 4399);
    }

    public void run(){
        try{
            while(true) {
                PrintWriter printer = new PrintWriter(this.s.getOutputStream());
                System.out.println("Input your message:");
                Scanner scanner = new Scanner(System.in);
                this.in_message = scanner.nextLine();
                // If user wants to quit
                if (in_message.equals("quit")){
                    printer.println("<<[" + this.username + "] " + "has left>>");
                    printer.close();
                    break;
                }

                printer.println("[" + this.username + "]: " + this.in_message);
                printer.flush();
            }
        }
        catch (Exception e){

        }


    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.run();
    }
}
