package com.karl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  private Socket clientSocket;
  private PrintWriter responseWriter;
  private BufferedReader requestReader;

  public void connectTo(String ip, int port) throws IOException {
    clientSocket = new Socket(ip, port);
    responseWriter = new PrintWriter(clientSocket.getOutputStream(), true);
    requestReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  }

  public String sendMessage(String msg) throws IOException {
    responseWriter.println(msg);
    String resp = requestReader.readLine();
    return resp;
  }

  public void close() throws IOException {
    requestReader.close();
    responseWriter.close();
    clientSocket.close();
  }
}
