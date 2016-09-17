package socket;
import java.io.IOException;
import java.net.*;
import socket.ServerThread;
public class server {

	public static void main(String[] args)
	{
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket =new ServerSocket(3333);
			Socket socket=null;
			while(true)
			{
				socket=serverSocket.accept();
				ServerThread serverThread=new ServerThread(socket);
				serverThread.start();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
