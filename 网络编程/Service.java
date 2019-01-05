package Service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Service {
	
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(521);
			
			System.out.println("¼àÌýÔÚ¶Ë¿ÚºÅ£º521");
			Socket s = ss.accept();
			
			new SendThread(s).start();
			
			new RecieveThred(s).start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
