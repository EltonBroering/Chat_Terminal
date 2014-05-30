
import java.io.*;
import java.net.*;
 
class Cliente_Desafio
{
    //Declare class variables to be used 
     
    String sent="",recieved=null;
    ObjectInputStream ois=null;
    ObjectOutputStream oos=null;
    BufferedReader br=null;
    Socket s=null;
    String ip;
    int porta;
    
    Cliente_Desafio(String ip,String porta){
    	this.ip=ip;
    	this.porta=Integer.parseInt(porta);
    }
     
    public void runCli()
    {
     
        try
        {
            s=new Socket(this.ip,this.porta);
             
            System.out.println("Client-Server Chat \n-----------------------------------------------------------\nPress Alt+F4 to quit this application.");
             
            System.out.println("\nSuccessfully connected to Server-"+s.getInetAddress()+":"+s.getLocalPort()+"\n");
            ois=new ObjectInputStream(s.getInputStream());
            oos=new ObjectOutputStream(s.getOutputStream());
            br=new BufferedReader(new InputStreamReader(System.in));
             
             
                 
            while(true)
            {
                System.out.println("Enter message: ");
                sendMessage();
                 
                System.out.println("Waiting for response.. ");
                receiveMessage();
                 
                             
            }
        }
         
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     
    void sendMessage()
    {
        try
        {
            System.out.println("(Type y and press enter to terminate the message)");
            String temp=null;
            sent="";
             
            while(true)
            {
                temp=br.readLine();
                if(temp.equalsIgnoreCase("y"))
                    break;
                else
                    sent=sent+temp+"\n";
                 
            } 
            oos.writeObject(sent);
            oos.flush();
        }
         
        catch(Exception e)
        {
            System.out.println(e);
             
        }
    }
     
    void receiveMessage()
    {
        try
        {
            recieved=(String)ois.readObject();
            System.out.println("\nServer->");
            System.out.println(recieved);
             
        }
         
        catch(Exception e)
        {
            System.out.println(e);
             
        }
         
    }
}