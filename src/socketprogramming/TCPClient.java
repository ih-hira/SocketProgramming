/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 *
 * @author ih_hira
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket clientsocket = new Socket("localhost", 6778); //ip will be server ip

            //Write on output stream
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String message = bf.readLine();

            DataOutputStream dataoutputStream = new DataOutputStream(clientsocket.getOutputStream());

            dataoutputStream.writeBytes(message + "\n");

            //Read from input stream
            BufferedReader bfClient = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

            String fromServer = bfClient.readLine();

            System.out.println(fromServer);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
