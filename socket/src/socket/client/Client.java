package socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static Scanner sc = new Scanner(System.in);

	public static String SERVER_IP = "127.0.0.1";
	public static int SERVER_PORT = 8080;

	public static void main(String[] args) throws InterruptedException, IOException {

		Socket socket = null;
		try {

			socket = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("Connected: " + socket);

			BufferedWriter writerdata = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			synchronized (socket) {
				for (int i = 0; i < 9; i++) {

					String data = sc.nextLine(); // Nhap du lieu

					writerdata.write(data); // Gui data toi server
					writerdata.newLine();
					writerdata.flush();

					String result = reader.readLine(); // Nhan du lieu tu server tra ve
					System.out.println("\t\t" + result);

					Thread.sleep(1000); // wait
				}
			}

		} catch (IOException e) {
			System.out.println("Can't connect to server");
		} finally {
			if (socket != null)
				socket.close();
		}

	}

}
