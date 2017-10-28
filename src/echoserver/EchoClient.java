package echoserver;
import java.net.*;
import java.io.*;


public class EchoClient {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 6013);
      // You can change 127.0.0.1 to a machine name if you want to try this across
      // the network to another machine.
      // Socket socket = new Socket("some.machine.edu", 6013);
      InputStream in = new DataInputStream(System.in); //Reads data from the standart input
      OutputStream out = socket.getOutputStream(); //OutputStream to send bytes to server
      InputStream input = socket.getInputStream(); //InputStream to receive bytes from server
      byte[] inBuffer = new byte[1]; //Buffer with size one so we can read byte by byte
      byte[] outBuffer = new byte[1]; //Buffer with size one so we can receive byte by byte

      while(in.read(inBuffer)!=-1){ //Once we reach end of the standart input we stop
        out.write(inBuffer); //Sends byte to the server
        out.flush();
        input.read(outBuffer); //Receives the byte from the server
        System.out.write(outBuffer, 0, 1); //Prints out this byte
      }
      socket.close();
    } catch (IOException ioe) {
      System.out.println("We caught an exception");
      System.err.println(ioe);
    }
  }
}
