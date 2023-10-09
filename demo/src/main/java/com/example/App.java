package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server code
 *
 */
public class App {
    /**
     * @param args
     */
    public static void main( String[] args ) {
        try {
            boolean exit=true;
                while(exit==true){
                    System.out.println("Il server si è svegliato");
                    ServerSocket servsock=new ServerSocket(3000); 

                    Socket s=servsock.accept();

                    BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
                    DataOutputStream out=new DataOutputStream(s.getOutputStream());

                    System.out.println("attesa di un messaggio da parte del client...");

                    String clientmessage=in.readLine();

                        if(clientmessage.equals("q")){
                            exit=false;
                        }

                    System.out.println("ecco il messaggio ricevuto dal client: " + clientmessage);

                    System.out.println("adesso invio la stringa modificata al client...");

                    String messagetosend=clientmessage.toUpperCase();

                    out.writeBytes(messagetosend + "\n");
                    
                    s.close();
                    servsock.close();
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
