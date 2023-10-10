package Game;


import Game.ConToServer.ConToServer;
import Game.ConToServer.GetOnlineMove;
import Game.ConToServer.MakeOnlineMove;
import Game.service.*;

import java.net.Socket;

public final class Launcher {
    private static final Integer PORT = 8988;
    private static final String IP_ADDRESS = "localhost";
    private static Socket socket;

    public static void main(String[] args) {


        ConToServer conToServer = new ConToServer(PORT, IP_ADDRESS);

        // TODO: Пробросить исключения, чтобы закрыть порты
        socket = conToServer.init();

        // MakeOnlineMove makeOnlineMove =new MakeOnlineMove(socket);
        GetOnlineMove getOnlineMove = new GetOnlineMove(socket);

//        Game game = new Game(new ComputerMove(),
//                new DataPrinter(),
//                new UserMove(),
//                new WinnerVerifier(),
//                new CellVerifier());

        Game game = new Game(getOnlineMove,
                new DataPrinter(),
                new MakeOnlineMove(socket),
                new WinnerVerifier(),
                new CellVerifier(),
                new FirstStepOnline
                        (getOnlineMove.getObjectInputStream()));


        //
        game.start();

    }


}

