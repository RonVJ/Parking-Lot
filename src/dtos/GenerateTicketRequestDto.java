package dtos;

import models.Gate;
import models.Vehicle;
import models.VehicleType;

public class GenerateTicketRequestDto {
    private String  vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getEntryGateId() {
        return entryGateId;
    }

    public void setEntryGateId(Long entryGateId) {
        this.entryGateId = entryGateId;
    }
}
