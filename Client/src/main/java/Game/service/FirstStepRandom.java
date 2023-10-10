package Game.service;

import java.util.Random;

public class FirstStepRandom implements FirstStep {
    @Override
    public Boolean isFirstStep() {
        return new Random().nextBoolean();
    }
}
