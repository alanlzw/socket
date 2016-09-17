import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class client {

	public static void main(String[] args)
	{
		try {
			Socket socket=new Socket("127.0.0.1", 3333);
			OutputStream outputStream=socket.getOutputStream();
			PrintWriter pWriter=new PrintWriter(outputStream);
			@SuppressWarnings("resource")
			Scanner in=new Scanner(System.in);
			String str=in.next();
			pWriter.write(str);
			pWriter.flush();
			socket.shutdownOutput();
			
			InputStream inputStream=socket.getInputStream();
			BufferedReader buff=new BufferedReader(new InputStreamReader(inputStream));
			String info=null;
			while((info=buff.readLine())!=null)
			{
				System.out.println("¿Í»§¶Ë"+info);
			}
			buff.close();	
			inputStream.close();
			pWriter.close();
			outputStream.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
