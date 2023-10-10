package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class GameSession extends Thread{
    TwoSockets twoSockets = null;
    UUID idSession = null;
    Data data = null;
    OutputStream outStream = null;
    ObjectOutputStream outObject = null;
    ServerSocket serverSocket = null;
    GameSession(ServerSocket serverSocket,
                TwoSockets twoSockets,
                UUID id){

        this.twoSockets = twoSockets;
        this.idSession = id;
        this.serverSocket = serverSocket;
        //twoSockets.getPlayerOne().getOutputStream()
    }

    @Override
    public void run(){
        // Отсылаем игрокам номер игровой сессии
        // Запускаем игровую сессию в поток
        initData();
        Boolean isFirst = true;
        System.out.println("Run Server");
        // TEST
        for(Socket socket : twoSockets.getListSockets()) {

            Listener listener = null;
            System.out.println("35");
            try {

                outStream = twoSockets.getOtherSocket(socket)
                        .getOutputStream();

                outObject = new ObjectOutputStream(outStream);

                System.out.println(twoSockets
                        .getOtherSocket(socket)
                        .getInputStream());

                var inStream = socket
                        .getInputStream();

                System.out.println("38");



                ObjectMapper objectMapper = new ObjectMapper();
                // objectMapper.writeValueAsBytes(isFirst);
                String json = objectMapper.writeValueAsString(isFirst);
                outObject.writeObject(json);
                outObject.flush();

                System.out.println("43");

                listener = new Listener(inStream,
                        outObject,
                        isFirst);
                listener.start();
                isFirst = false;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
           // listener.start();

        }
       // Дальше слушаем сокеты и правим Data
    }

    public Data initData(){
        this.data = new Data();
        return  this.data;
    }


}
