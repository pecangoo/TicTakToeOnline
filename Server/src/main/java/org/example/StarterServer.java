package org.example;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StarterServer extends Thread{

    Socket socket = null;

    ServerSocket serverSocket = null;

    Map<UUID, GameSession> gameSessionMap =
            new ConcurrentHashMap<>();
    StarterServer (final Integer port) {
        // Открываем сокет и находим двух клиентов

        TwoSockets twoSockets = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Цикл сканирования новых подключений
        while (true) {
            twoSockets = new TwoSockets();
            while (true) {
                try {
                    socket = serverSocket.accept();
                    UUID uuid = UUID.randomUUID();
                    System.out.println("Client connected");
                    if (twoSockets.addPlayer(socket) == 1) {
                        //TODO : Разделить отвественность addPlayer

                        GameSession gameSession =
                                new GameSession(serverSocket,
                                        twoSockets,
                                        uuid);
                        gameSessionMap.put(uuid, gameSession);
                        gameSession.start();
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Неудалось добавить двух игроков");
                    throw new RuntimeException(e);
                }
            }
        }


    }

    @Override
    public  void run() {
//
//
//        try {
//
//            socket = serverSocket.accept();
//            out = socket.getOutputStream();
//            objectOutputStreamOut = new ObjectOutputStream(out);
//            objectOutputStreamOut.writeObject(data);
//            objectOutputStreamOut.flush();
//
//            for (int i = 0; i < 100 ;  i ++) {
//                Thread.currentThread().sleep(500);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//
//
//            socket.close();
//
//        }


    }
}