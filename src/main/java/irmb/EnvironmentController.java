package irmb;


public class EnvironmentController {

    private HVAC hvac;
    private int desiredTemperature;
    private int temperatureDelta;
    
    public EnvironmentController(HVAC hvac) {
        this.hvac = hvac;
        switchOffHvac();
    }

    private void switchOffHvac() {
        hvac.stopHeating();
        hvac.stopCooling();
        hvac.stopBlowing();
    }

    public void checkTemperature() {
        if(isItTooCold()){
            hvac.startHeating();
            hvac.startBlowing();
        } else if (isItTooHot()){
            hvac.startCooling();
            hvac.startBlowing();
        } else {
            switchOffHvac();
        }
    }

    private boolean isItTooCold()
    {
        return hvac.getTemperature() < desiredTemperature - temperatureDelta;
    }

    private boolean isItTooHot()
    {
        return hvac.getTemperature() > desiredTemperature + temperatureDelta;
    }

    public void setDesiredTemperature(int i) {
        desiredTemperature = i;
    }

    public void setTemperatureDelta(int i) {
        temperatureDelta = i;
    }

}
