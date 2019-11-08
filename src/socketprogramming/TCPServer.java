/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ih_hira
 */
public class TCPServer implements Runnable {

    private Thread t;
    private  String tName;
    private Socket clientsocket;
    private static int clientNum = 0;
    public TCPServer(Socket clientsocket,String tName) {
        this.clientsocket = clientsocket;
        this.tName = tName;
    }

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serversocket = new ServerSocket(6778);
            
            while (true) {
                Socket clientsocket = serversocket.accept();
                clientNum++;
                String tName = "Client"+clientNum;
                TCPServer c1ient = new TCPServer(clientsocket, tName);
                c1ient.start();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void run() {
        //To change body of generated methods, choose Tools | Templates.
        try {
            //Read from input stream
            BufferedReader bf = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            String fromClient = bf.readLine();
            String toClient = fromClient.toUpperCase();
            DataOutputStream dataOutputStream = new DataOutputStream(clientsocket.getOutputStream());
            dataOutputStream.writeBytes(toClient + "\n");
            clientNum--;
            clientsocket.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
    
    public void start(){
        if (t == null) {
         t = new Thread (this, tName);
         t.start ();
      }
    }
}
