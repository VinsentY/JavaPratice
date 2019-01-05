package five;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	
	private Socket s;

	public SendThread(Socket socket) {
		super();
		this.s = socket;
	}
	
	public void run() {
		try {
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				dos.writeUTF(sc.next());
			}
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
