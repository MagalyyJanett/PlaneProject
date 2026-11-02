public class Plane {
    // plane attributes
    private String make;
    private String model;
    private int number;
    private boolean landingGearEnabled;
    private int maxAltitudeMeters;
    private int currentAltitudeMeters;

    // constructor - no return types
    public Plane() {
        make = "Ascend";
        model = "Ataraxia";
        number = 1023;
        landingGearEnabled = true;
        maxAltitudeMeters = 12000;
        currentAltitudeMeters = 0;
    }
    // print plane details
    public void planeDetails() {
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Number: " + getNumber());
        System.out.println("System Gear Enabled: " + getLandingGearEnabled());
        System.out.println("Maximum Altitude: " + getMaxAltitudeMeters());
      System.out.println("Current Altitude: " + getCurrentAltitudeMeters());
    }

    // setting up getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }

    public boolean getLandingGearEnabled() {
        return landingGearEnabled;
    }

    public int getMaxAltitudeMeters() {
        return maxAltitudeMeters;
    }

    public int getCurrentAltitudeMeters() {
        return currentAltitudeMeters;
    }

    // landing
    public void disableLandingGear() {
        if (currentAltitudeMeters >= 100) {
            landingGearEnabled = false;
        }
    }

    public void enableLandingGear() {
        if (currentAltitudeMeters <= 100) {
            landingGearEnabled = true;
        }
    }

    // restrictions for altitudes
    public boolean changeAltitude(int elevationChange) {
        if (landingGearEnabled && currentAltitudeMeters + elevationChange > 100) {
            currentAltitudeMeters = 100;
            return false;
        }
        if (!landingGearEnabled && currentAltitudeMeters + elevationChange < 100) {
            currentAltitudeMeters = 100;
            return false;
        }
        if (currentAltitudeMeters + elevationChange < 0) {
            currentAltitudeMeters = 0;
            return false;
        }
        if (currentAltitudeMeters + elevationChange > maxAltitudeMeters) {
            currentAltitudeMeters = maxAltitudeMeters;
            return false;
        }
        currentAltitudeMeters += elevationChange;
        return true;
    }
}
