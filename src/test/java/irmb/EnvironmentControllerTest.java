package irmb;

import static org.junit.Assert.assertTrue;

import org.junit.After;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;

public class EnvironmentControllerTest 
{
    private HVACSpy hvac;
    private EnvironmentController sut;

    @Before
    public void setUp()
    {
        hvac = new HVACSpy();
        sut = new EnvironmentController(hvac);

        sut.setDesiredTemperature(22);
        sut.setTemperatureDelta(2);
    }

    @Test
    public void uponConstruction_everythingShouldBeOff() {
        assertIsOff();
    }

    @Test
    public void whenItsTooHot_itShouldStartCooling() {
        makeItTooHot();

        sut.checkTemperature();

        assertIsCooling();
    }

    @Test
    public void whenItsTooCold_itShouldStartHeating(){
        makeItTooCold();

        sut.checkTemperature();
        
        assertIsHeating();
    }

    @Test
    public void givenItsCooling_whenItsComfortable_ItShouldStartIdle() {
        makeItTooHot();
        sut.checkTemperature();
        makeItComfortable();

        sut.checkTemperature();

        assertIsOff();
    }

    private void makeItTooHot() {
        hvac.setTemperature(25);
    }

    private void makeItTooCold() {
        hvac.setTemperature(19);
    }

    private void makeItComfortable() {
        hvac.setTemperature(22);
    }

    private void assertIsOff(){
        assertFalse(hvac.isBlowing());
        assertFalse(hvac.isCooling());
        assertFalse(hvac.isHeating());
    }

    private void assertIsCooling(){
        assertTrue(hvac.isBlowing());
        assertTrue(hvac.isCooling());
        assertFalse(hvac.isHeating());
    }

    private void assertIsHeating(){
        assertTrue(hvac.isBlowing());
        assertFalse(hvac.isCooling());
        assertTrue(hvac.isHeating());
    }



}
