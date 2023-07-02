package repositories;

import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();
    public Optional<ParkingLot> getParkingLotofGate(Gate gate) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if(parkingLot.getGates().contains(gate)) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
