package socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.w3schools.com/");
			URLConnection connection = url.openConnection();
			//show url
			System.out.println("URL: " + url.toString());
			//getprotocol
			System.out.println("Protocol: " + url.getProtocol());
			//get Authority
			System.out.println("Authority: " + url.getAuthority());
			//get file name
			System.out.println("File name: " + url.getFile());
			//get Port
			System.out.println("Port: " + url.getPort());
			//get Local
			System.out.println("Local: " + url.getHost());
			//URL Collection
			//get Content
			System.out.println("Content: " + connection.getContent());
			//get inputStream
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = new String();
			while ((line = inputStream.readLine()) != null) {
				
				builder.append(line + "\n");
				
			}
			System.out.println(builder);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
