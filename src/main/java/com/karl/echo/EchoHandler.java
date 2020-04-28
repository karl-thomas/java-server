package com.karl.echo;

import java.io.BufferedReader;
import com.karl.wrappers.Connectable;

public class EchoHandler implements Runnable {
  public Connectable connection;

  public EchoHandler(Connectable connection) {
    this.connection = connection;
  }

  public void run() {
    try {
      final BufferedReader requestReader = connection.getReader();
      String inputLine;
      while ((inputLine = requestReader.readLine()) != null) {
        connection.write(inputLine + "\n");
      }
      connection.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}
