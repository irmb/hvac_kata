package irmb;

public interface HVAC {
    
    void stopHeating();
    void stopCooling();
    void stopBlowing();
    void startCooling();
    void startBlowing();
    int getTemperature();
	void startHeating();
}
