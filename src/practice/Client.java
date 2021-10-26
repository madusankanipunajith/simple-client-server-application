package practice;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket sock = new Socket("localhost", 9999); // this is client side socket. we should know the server socket's port
		
		// this is client side socket's input and output streams
		InputStream in = sock.getInputStream();
		OutputStream out = sock.getOutputStream();
		
		out.write("Hello from client...".getBytes());
		
		byte[] response = new byte[1024];
		in.read(response); // client read the server message and stored into the byte array called response
		
		String serverMessage = new String(response).trim();
		
		System.out.println("Recieved from server..."+ serverMessage);
		
		sock.close();
	}

}
