package socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WorkThread implements Runnable {

	public Scanner sc = new Scanner(System.in);

	private Socket socket;

	public WorkThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		System.out.println("Processing: " + socket);
		synchronized (socket) {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				while (socket.isConnected()) {

					String result = reader.readLine(); // Doc du lieu gui toi tu client
					System.out.println("\t\t" + result);
					String data = sc.nextLine();
					writer.write(data); // Gui du lieu toi client
					writer.newLine();
					writer.flush();

				}
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
