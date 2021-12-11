package day4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client1b 
{
    
    public static void main(String[] args) 
        throws UnknownHostException, IOException
    {
        Socket socket = new Socket("Localhost", 12345);
        System.out.println("Server Connected");
        System.out.println("Waiting for your words today? Please key in cookies.");

        BufferedReader serverMsgIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter clientMessageOut = new PrintWriter(socket.getOutputStream(), true);

        Scanner clientInput = new Scanner(System.in);
        String clientToServer = clientInput.nextLine();

        String serverMsg = "";

        while (!"close".equals(clientToServer))
        {
            clientMessageOut.println(clientToServer);
            clientMessageOut.flush();
            serverMsg = serverMsgIn.readLine();
            System.out.println(serverMsg);
            clientToServer = clientInput.nextLine();
        }

        
        socket.close();
        clientInput.close();
    }
    
}

