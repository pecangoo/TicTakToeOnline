package org.example;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TwoSockets {

    private  Socket PlayerOne = null;
    private  Socket PlayerTwo = null;

    public Socket getPlayerOne() {
        return PlayerOne;
    }

    public void setPlayerOne(Socket playerOne) {
        PlayerOne = playerOne;
    }

    public Socket getPlayerTwo() {
        return PlayerTwo;
    }

    public void setPlayerTwo(Socket playerTwo) {
        PlayerTwo = playerTwo;
    }


    public int addPlayer(Socket socket){
        if (PlayerOne == null) {
            PlayerOne = socket;
        } else if (PlayerTwo == null) {
            PlayerTwo = socket;
            return 1;
        } else {
            return -1;
        }
        return  0;
    }

    public List<Socket>  getListSockets(){
        List<Socket> listSocktes = new ArrayList<>();
        listSocktes.add(getPlayerOne());
        listSocktes.add(getPlayerTwo());
        return listSocktes;
    }

    public Socket getOtherSocket(Socket socket){
        if (socket.equals(PlayerOne)) return  PlayerTwo;
        else return  PlayerOne;
    }

}
