package epn.edu.redes.udp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class ClienteUDP {
	
	public static int SERVER_PORT= 9091;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String serverAddress= JOptionPane.showInputDialog("Ingrese dirección IP de la máquina que corra el servicio"
				+ SERVER_PORT+":");
		
		//Envia paquete(REQUEST)
		DatagramSocket clientSocket = new DatagramSocket();
		byte bufferSend[]= serverAddress.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(bufferSend, bufferSend.length, InetAddress.getByName(serverAddress), SERVER_PORT);
		clientSocket.send(sendPacket);
		
		
		
		//Recibir paquete
		byte bufferReceive[]= new byte[128];
		DatagramPacket receivePacket= new DatagramPacket(bufferReceive, bufferReceive.length);
		clientSocket.receive(receivePacket);
		
		
		//transformar bytes a String
		InputStream myInputStream= new ByteArrayInputStream(receivePacket.getData());
		BufferedReader input= new BufferedReader(new InputStreamReader(myInputStream));
		String answer= input.readLine();
		
		
		//Desplegar mensaje
		JOptionPane.showMessageDialog(null, answer);
		clientSocket.close();
		System.exit(0);
	}

}
