package models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private Long spotNumber;
    private Vehicle currentVehicle;
    private List<VehicleType> supportedVehicleTypes;
    private SpotStatus spotStatus;

    public Long getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Long spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }
}
