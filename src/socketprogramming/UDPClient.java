/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 *
 * @author ih_hira
 */
public class UDPClient {

    public static void main(String[] args) {
        try {
            DatagramSocket clientUDPSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] receiveByte = new byte[1024];
            //byte [] sendByte = new byte[1024];
            String sentence = "Hello";
            byte[] sendByte = sentence.getBytes();
            DatagramPacket sendDatagramPacket = new DatagramPacket(sendByte, sendByte.length, IPAddress, 9877);
            clientUDPSocket.send(sendDatagramPacket);
            
            DatagramPacket receiveDatagramPacket = new DatagramPacket(receiveByte, receiveByte.length);
            String response = new String(receiveDatagramPacket.getData());
            System.out.println(response);
            clientUDPSocket.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
