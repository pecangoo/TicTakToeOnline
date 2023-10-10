package Game.model;

import java.io.Serializable;

public class Data implements Serializable {

    public Integer step;
    //    enum STATUS{
//        WAIT,
//        ACTIVE,
//        END
//    }
    // private TwoSockets twoSockets;
    private Integer currentStep = 0;
    private Boolean first = null;

    public Data() {

    }


    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }


    public Integer getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(Integer currentStep) {
        this.currentStep = currentStep;
    }

}