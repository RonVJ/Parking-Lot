package services;

import exceptions.InvalidGateException;
import exceptions.SpotNotAvailableException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;
    SpotAssignmentStrategy spotAssignmentStrategy;
    TicketRepository ticketRepository;



    public TicketService(GateRepository gateRepository
            , VehicleRepository vehicleRepository
            , ParkingLotRepository parkingLotRepository
            , TicketRepository ticketRepository
            , SpotAssignmentStrategy spotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Long entryGateId
            , VehicleType vehicleType
            , String vehicleNumber) throws InvalidGateException, SpotNotAvailableException {
        Optional<Gate> gateOptional = gateRepository.findGateById(entryGateId);
        if(gateOptional.isEmpty()) {
            throw new InvalidGateException();
        }
        Gate entryGate = gateOptional.get();
        Operator currentOperator = entryGate.getCurrentOperator();

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;

        if(vehicleOptional.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        }
        else {
            vehicle = vehicleOptional.get();
        }

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotofGate(entryGate);
        if(parkingLotOptional.isEmpty()) {
            throw new InvalidGateException();
        }
        ParkingLot parkingLot = parkingLotOptional.get();

        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.findSpot(vehicleType, parkingLot, entryGate);
        if(parkingSpotOptional.isEmpty()) {
            throw new SpotNotAvailableException();
        }
        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setTicketIssuer(currentOperator);
        ticket.setEntryGate(entryGate);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);

        return ticketRepository.save(ticket);
    }
}
