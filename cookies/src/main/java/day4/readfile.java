package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class readfile {

    private String cookieIs = null;

    public String readCookie(String fileName)
    {
        String pathName = "/Users/wensun/Desktop/JAVA/workshop/myCookies.txt";
        BufferedReader br = null;

        List<String> cookieList = new ArrayList<>();
        

        try {
            FileReader myFile = new FileReader((pathName));
            br = new BufferedReader(myFile);
            String line = null;

            while ((line = br.readLine())!=null) 
            {
                // System.out.println("Your worlds for today is "+ line);
                cookieList.add(line);
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try 
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        Collections.shuffle(cookieList);
        cookieIs = cookieList.get(0);

        return cookieIs;

    }
    
}
