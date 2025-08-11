import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main{
	public static void main(String args[]) throws IOException{
		HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
		server.createContext("/", new MyHandler());
		server.setExecutor(null);
		server.start();
		System.out.println("Java backend is running on port 8080");
	}

	static class MyHandler implements HttpHandler{
		public void handle(HttpExchange exchange) throws IOException{
			String response = "Hello from Java Backend";
			exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
			exchange.sendResponseHeaders(200,response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}
	