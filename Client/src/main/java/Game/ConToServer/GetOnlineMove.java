package Game.ConToServer;

import Game.model.Cell;
import Game.model.Data;
import Game.model.GameField;
import Game.service.Move;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class GetOnlineMove implements Move {
    private final InputStream inputStream;
    private final ObjectInputStream objectInputStream;
    private final ObjectMapper objectMapper;

    public GetOnlineMove
            (final Socket socket) {
        try {
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(
                    socket.getInputStream());
            objectMapper = new ObjectMapper();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObjectInputStream getObjectInputStream() {
        System.out.println("Get In Stream: " +
                inputStream.toString());
        return objectInputStream;
    }

    @Override
    public void make(GameField gameField) {

        try {
            // byte[] bytes = inputStream.readAllBytes();
            //  System.out.println("Длина массива Bytes: "  + bytes.length);
            //ConToServer.data = objectMapper.readValue(bytes, Data.class);
            //System.out.println("Get : 35");

            String json = (String) objectInputStream.readObject();
            ConToServer.data =
                    objectMapper.readValue(json, Data.class);

            Integer step = ConToServer.data.step;

            changeGameField(gameField, step);
            //System.out.println("Get : 38");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeGameField(GameField gameField,
                                 Integer step) {
        System.out.println("Opponent step");

        int row = (step - 1) / 3;
        int col = (step - 1) % 3;

        while (true) {
            final Cell randomCell = new Cell(row, col);
            if (gameField.isEmpty(randomCell)) {
                gameField.setSign(randomCell, '0');
                return;
            }
        }
    }
}

