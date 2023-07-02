package repositories;

import models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new TreeMap<>();
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        if(vehicles.containsKey(vehicleNumber)) {
            return Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}
