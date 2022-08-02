import java.net.*;
import java.io.*;
class Server
{
    
    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    ////Constructor for Server
    public Server()
    {
        try{
        server = new ServerSocket(7777); //7777: port to specify which program is run by client
        System.out.println("Server Is Ready To Accept Connection");
        System.out.println("Server Is Waiting...");
        socket = server.accept();  //Accepting connection from client side
        
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out = new PrintWriter(socket.getOutputStream());
    }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        System.out.println("This Is Server...Going To Start!!");
        new Server();
    }
}