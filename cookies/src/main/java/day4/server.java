package day4;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server 
{

    public static void main(String[] args) throws IOException
    {
        System.out.println("Listening at port 12345...");
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        try (InputStream is = socket.getInputStream())
        {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
            String msg = "";

            while (msg.equals("Cookies"))
            {
                msg = dis.readUTF();
                System.out.println("");
            }
        }

        socket.close();
        serverSocket.close();

    }
    
    

    
}
