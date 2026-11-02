import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test

    public void testGetMake() {
        Plane plane = new Plane();

        assertEquals("Ascend", plane.getMake());
    }

    @Test
    public void testGetModel() {
        Plane plane = new Plane();
        assertEquals("Ataraxia", plane.getModel());
    }

    @Test
    public void testGetNumber() {
        Plane plane = new Plane();
        assertEquals(1023, plane.getNumber());
    }

    @Test
    public void testGetLandingGear() {
        Plane plane = new Plane();
        assertTrue(plane.getLandingGearEnabled());
    }

    @Test
    public void testGetMaxAltitudeMeters() {
        Plane plane = new Plane();
        assertEquals(12000, plane.getMaxAltitudeMeters());
    }

    @Test
    public void testGetCurrentAltitudeMeters() {
        Plane plane = new Plane();
        assertEquals(0, plane.getCurrentAltitudeMeters());
    }

    @Test
    public void testDisableLandingGear() {
        Plane plane = new Plane();

        plane.disableLandingGear();
        assertTrue(plane.getLandingGearEnabled());

        plane.changeAltitude(100);

        plane.disableLandingGear();
        assertFalse(plane.getLandingGearEnabled());
    }

    @Test
    public void testEnableLandingGear() {
        Plane plane = new Plane();
        plane.changeAltitude(100);
        plane.disableLandingGear();

        plane.changeAltitude(100);

        plane.enableLandingGear();
        assertFalse(plane.getLandingGearEnabled());

        plane.changeAltitude(-100);

        plane.enableLandingGear();
        assertTrue(plane.getLandingGearEnabled());
    }

    @Test
    public void testAltitudeBelowZero() {
        Plane plane = new Plane();
        assertFalse(plane.changeAltitude(-50));
        assertEquals(0, plane.getCurrentAltitudeMeters());
    }

    @Test
    public void testMaxAltitude() {
        Plane plane = new Plane();

        plane.changeAltitude(100);
        plane.disableLandingGear();

        assertFalse(plane.changeAltitude(15000));
        assertEquals(12000, plane.getCurrentAltitudeMeters());
    }

    @Test
    public void testAltitudewithLandingGearEnabled() {
        Plane plane = new Plane();
        assertFalse(plane.changeAltitude(500));
        assertEquals(100, plane.getCurrentAltitudeMeters());
        assertTrue(plane.getLandingGearEnabled());
    }

    @Test
    public void testAltitudeWithLandingGearDisabled() {
        Plane plane = new Plane();
        plane.changeAltitude(100);
        plane.disableLandingGear();
        plane.changeAltitude(100);
        assertFalse(plane.changeAltitude(-150));
        assertEquals(100, plane.getCurrentAltitudeMeters());
        assertFalse(plane.getLandingGearEnabled());
    }

    @Test
    public void testSuccessfulAltitudeChange() {
        Plane plane = new Plane();
        assertTrue(plane.changeAltitude(50));
        assertEquals(50, plane.getCurrentAltitudeMeters());

        assertTrue(plane.changeAltitude(-20));
        assertEquals(30, plane.getCurrentAltitudeMeters());
    }
    @Test
    public void testPlaneDetails(){

    Plane plane = new Plane();
    plane.planeDetails();
}
}

