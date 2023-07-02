package strategies.spotassignmentstrategy;

import models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        for(ParkingFloor parkingFloor: parkingLot.getFloors()) {
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if(parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE)
                && parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
