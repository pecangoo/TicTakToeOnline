package Game.ConToServer;

import Game.model.Cell;
import Game.model.GameField;
import Game.service.Move;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeOnlineMove implements Move {
    private OutputStream outputStream = null;
    private ObjectOutputStream objectOutputStream = null;
    private ObjectMapper objectMapper = null;

    public MakeOnlineMove(final Socket socket) {
        try {
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void make(GameField gameField) {
        ConToServer.data.step = changeField(gameField);
        sendStream();
    }

    public void sendStream() {
        objectMapper = new ObjectMapper();
        try {
            String json =
                    objectMapper.writeValueAsString(ConToServer.data);
            objectOutputStream.writeObject(json);
            objectOutputStream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer changeField(GameField gameField) {
        Integer step = 0;
        System.out.println("Player step");
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please type number between 1 and 9:\n");
            try {
                Integer in = scanner.nextInt();
                if (!(in >= 1 && in <= 9)) continue;
                step = in;
                final int row = (in - 1) / 3;
                int col = (in - 1) % 3;
                System.out.println(row + " " + col);
                final Cell randomCell = new Cell(row, col);
                if (gameField.isEmpty(randomCell)) {
                    gameField.setSign(randomCell, 'X');
                    break;
                } else {
                    System.out.println("Can't make a move," +
                            " because the cell is not free! Try again!");
                    continue;
                }
            } catch (InputMismatchException ex) {
                scanner.nextLine();
            }
        }
        return step;
    }
}
