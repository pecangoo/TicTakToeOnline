package org.example;

import java.io.IOException;

public class ServerMain {
    private static final int PORT = 8988;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        StarterServer serverMain = new StarterServer(PORT);
        serverMain.run();
    }

}
