package socket;
import java.io.*;
import java.net.Socket;
public class ServerThread extends Thread{

	Socket socket=null;
	public ServerThread(Socket socket)
	{
		this.socket=socket;
	}
	public void run()
	{
		InputStream inputStream=null;
		InputStreamReader reader=null;
		BufferedReader bufferedReader=null;
		OutputStream outputStream=null;
		PrintWriter writer=null;
		try {
			inputStream=socket.getInputStream();
			reader=new InputStreamReader(inputStream);
			bufferedReader=new BufferedReader(reader);
			String str=null;
			str=bufferedReader.readLine();
		    System.out.println("·þÎñÆ÷¶Ë"+invert(str));
			
			socket.shutdownInput();
			outputStream=socket.getOutputStream();
			writer=new PrintWriter(outputStream);
			writer.write(invert(str));
			writer.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null)
				{
					writer.close();
				}
				if(outputStream!=null)
				{
					outputStream.close();
				}
				if(bufferedReader!=null)
				{
					bufferedReader.close();
				}
				if(inputStream!=null)
				{
					inputStream.close();
				}
				if(reader!=null)
				{
					reader.close();
				}
				if(socket!=null)
				{
					socket.close();
				}
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public String invert(String str)
	{
		char info[]=new char[str.length()];
		int j=0;
		for(int i=str.length()-1;i>=0;i--)
		{
			info[j++]=str.charAt(i);
		}
		return new String(info);
	}
}
