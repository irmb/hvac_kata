package irmb;

public class HVACSpy implements HVAC {

    private boolean heating = true;
    private boolean cooling = true;
    private boolean blowing = true;
    private int temperature;

    public boolean isBlowing() {
        return blowing;
    }

    public boolean isCooling() {
        return cooling;
    }

    public boolean isHeating() {
        return heating;
    }

    @Override
    public void stopHeating() {
        heating = false;
    }

    @Override
    public void stopCooling() {
        cooling = false;
    }

    @Override
    public void stopBlowing() {
        blowing = false;
    }

    @Override
    public void startCooling() {
        cooling = true;
    }

    @Override
    public void startBlowing() {
        blowing = true;
    }

    public void setTemperature(int i) {
        temperature = i;
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void startHeating() {
        heating = true;
        
    }
}
