package day4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class server1b 
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Connecting to port 12345...");

        String inputFile = "";
        
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
    
        System.out.println("Client is connected.");

        PrintWriter messageOutClient = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader messageIn = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        String msgToServer = messageIn.readLine();

        

        while (!"close".equals(msgToServer) && null != msgToServer)
        {
            System.out.println("we received " + msgToServer + "."); //sever end will print out

            try
            {
                
                if ("cookies".equals(msgToServer)){
                    System.out.println("Generating coookie...");
                    messageOutClient.println("Your words of the day is " +
                        new readfile().readCookie(inputFile));
                    messageOutClient.flush();
                    msgToServer = messageIn.readLine();
                       

                }
                else {
                    messageOutClient.println ("Server received message is " + msgToServer);
                    messageOutClient.flush();
                    msgToServer = messageIn.readLine();
                }
                       
                  
            }
            catch (IOException e)
            {
                e.printStackTrace();
                break;
                 
            }

        }
            
        
            
        socket.close();
        serverSocket.close();

    }
    
}
