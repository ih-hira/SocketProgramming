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
public class UDPServer {

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9877);
            byte[] receiveByte = new byte[1024];
            //byte [] sendByte = new byte[1024];
            DatagramPacket receiveDatagramPacket = new DatagramPacket(receiveByte, receiveByte.length);

            serverSocket.receive(receiveDatagramPacket);
            String sentence = new String(receiveDatagramPacket.getData());
            // do something with the sentence
            System.out.println(sentence);
            
            byte[] sendByte = sentence.getBytes();
            InetAddress ipAddress = receiveDatagramPacket.getAddress();
            int port = receiveDatagramPacket.getPort();
            
            DatagramPacket sendDatagramPacket = new DatagramPacket(sendByte, sendByte.length, ipAddress, port);
            serverSocket.send(sendDatagramPacket);
            serverSocket.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
