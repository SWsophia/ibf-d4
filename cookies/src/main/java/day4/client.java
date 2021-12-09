package day4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

    public static void main(String[] args) throws UnknownHostException, IOException
    {
        Socket socket = new Socket("Localhost", 12345);

        try (OutputStream os = socket.getOutputStream())
        {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msg = "";

            while (msg.equals("cookie"))
            {
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            }
        }
        
        socket.close();
    }
    
}
