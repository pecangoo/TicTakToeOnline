package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;

public class Listener extends  Thread{
    Data data = null;
    private  ObjectOutputStream outObject = null;
    private InputStream inStream= null;
    private ObjectInputStream inObject= null;
    ObjectMapper objectMapper = null;
    Boolean isFirst = null;
 //   private Socket secondSocket;
  //  private Socket firstSocket;
//  Слушает Один сокет, ПРОТИВОЛОЖНЫЙ

    Listener(InputStream inputStream,
             ObjectOutputStream outputStream,
             Boolean inFirst) {
        System.out.println("Listener Start ");
        this.inStream = inputStream;
        this.outObject = outputStream;
        objectMapper = new ObjectMapper();

    }

    @Override
    public void run(){
        // Cлушаем in
        // Поулчаем дата и перенаправлеям на другой сокет
        try {
            inObject = new ObjectInputStream(inStream);

            while(true) {
                if (inStream.available() != 0) {


                    // TODO: Передача потока без десериализации
                    String json = (String) inObject.readObject();
                    outObject.writeObject(json);
                    // Читаем данные из первого потока и отправляем их во второй поток
                    outObject.flush();
                }
                Thread.currentThread().sleep(500);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // RESEND
    }
}
