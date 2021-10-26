package practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serSocket = new ServerSocket(9999); // create a server socket
		System.out.println("waiting for client....");
		
		Socket sock = serSocket.accept();  // waiting for a client request, separate socket
		System.out.println("client connected...");
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		byte[] buffer = new byte[1024]; // allocate 1024 byte array to store client msg
		in.read(buffer);
		
		String clientMessage = new String(buffer).trim();  // convert byte msg into string
		System.out.println("Recieved from client - "+ clientMessage);
		
		out.write("Hello from server....".getBytes());
		
		
		sock.close();
		serSocket.close();
	}

}
