package epn.edu.redes.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {
	
	private static int PORT= 9091;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		DatagramSocket serverSocket = new DatagramSocket(PORT);
		//System.err.println("Servidor listo en el puerto "+ PORT+ " usando conexion UDP \n");
		System.out.println("Servidor listo en el puerto "+ PORT+ " usando conexion UDP \n");
		
		try{
			while(true){
			//Recibir el paquete
				byte bufferReceive[]= new byte[128];
				DatagramPacket receivePacket = new DatagramPacket(bufferReceive, bufferReceive.length);
				serverSocket.receive(receivePacket);
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				System.out.println("Puerto del cliente: "+ clientPort+"\n");
				
				
				//Enviar paquete
				String msg= " Mensaje del servidor";
				byte bufferSend[]= msg.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(bufferSend, bufferSend.length,clientAddress, clientPort);
				serverSocket.send(sendPacket);
				
				serverSocket.close();
			}
		}catch(SocketException e){
			
		}
		
		/*finally{
			serverSocket.close();
		}
		*/
		

	}

}
