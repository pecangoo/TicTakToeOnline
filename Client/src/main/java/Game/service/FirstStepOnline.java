package Game.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInputStream;

public class FirstStepOnline implements FirstStep {
    private final Boolean isFirst;
    private final ObjectMapper objectMapper;

    public FirstStepOnline(ObjectInputStream objectInputStream) {
        try {
            objectMapper = new ObjectMapper();

            String json =
                    (String) objectInputStream.readObject();

            isFirst =
                    objectMapper.readValue(json, Boolean.class);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public Boolean isFirstStep() {
        return isFirst;
    }
}
