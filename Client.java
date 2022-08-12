import java.net.*;

import java.io.*;

public class Client {

    Socket socket;
    
    BufferedReader br;
    PrintWriter out;
    public Client()
    {
        try{

            System.out.println("SENDING REQUEST TO SERVER ...");

            socket = new Socket("127.0.0.1",7777);

            System.out.println("CONNECTION DONE!");



        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("This Is Client...");
    }
    
}
