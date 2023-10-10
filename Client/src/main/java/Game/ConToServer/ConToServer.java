package Game.ConToServer;

import Game.model.Data;

import java.io.IOException;
import java.net.Socket;

public class ConToServer {
    public final Integer PORT;
    public final String IP_ADDRESS;
    private Socket socket = null;
    public static Data data = new Data();


    public ConToServer(final Integer PORT,
                       final String IP_ADDRESS) {
        this.PORT = PORT;
        this.IP_ADDRESS = IP_ADDRESS;
    }

    public Socket init() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return socket;
    }

    public void closeSocket() {
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}