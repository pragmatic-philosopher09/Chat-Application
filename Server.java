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

        startReading();
        startWriting();
    }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void startReading()
    {
       // thread - will read and return

       Runnable r1 = () -> {
          
         System.out.println("READER STARTED...");

         while(true)
         {
          
            try {
               String message = br.readLine();

                if(message.equals("Quit!"))
            {
                System.out.println("CLIENT HAS TERMINATED CHAT!!");
                break;
            }
            System.out.println("CLIENT :"+message);
            } 
            
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
         }
       };

       new Thread(r1).start();
    }

    public void startWriting()
    {
         //thread - takes from user and sends to client
        Runnable r2 = () -> {
          
            while(true)
            {

                try{

                    System.out.println("WRITER STARTED...");
                    
                   BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

                   String content = br1.readLine();

                   out.println(content);
                   out.flush();

                }

                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r2).start();
    }
    public static void main(String args[])
    {
        System.out.println("This Is Server...Going To Start!!");
        new Server();
    }
}