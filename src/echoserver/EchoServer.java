package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6013);

      while (true) {
        System.out.println("Got a request!");
        Socket client = sock.accept();
        InputStream input  = client.getInputStream(); //InputStream to receive the bytes from client
        OutputStream output = client.getOutputStream(); //OutputStream to send bytes to client
        byte[] buffer = new byte[1]; //Buffer with size one so we can read byte by byte

        while(input.read(buffer)!=-1){
          output.write(buffer); //Sends the same byte back to the client
          output.flush();
        }
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
