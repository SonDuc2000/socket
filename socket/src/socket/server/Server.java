package socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static Scanner sc = new Scanner(System.in);

	public final static int SERVER_PORT = 8080;
	public final static int MAX_CLIENT = 5;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null; // Tao doi tuong server
		ExecutorService executorService = Executors.newFixedThreadPool(MAX_CLIENT);
		try {

			System.out.println("Binding to port: " + SERVER_PORT + " please wait...");
			serverSocket = new ServerSocket(SERVER_PORT); // Khoi tao server voi port
			System.out.println("Server started!");
			System.out.println("Waiting for a client...");

			while (true) {
				try {

					Socket socket = serverSocket.accept();
					System.out.println("Client accepted " + socket);

					WorkThread thread = new WorkThread(socket);
					executorService.execute(thread);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null)
				serverSocket.close();
		}

	}

}
