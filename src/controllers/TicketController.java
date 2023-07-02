package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import dtos.ResponseStatus;
import exceptions.InvalidGateException;
import exceptions.SpotNotAvailableException;
import models.*;
import services.TicketService;

import java.util.Date;

public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
        GenerateTicketResponseDto response = new GenerateTicketResponseDto();
        Ticket ticket = null;

        String vehicleNumber = request.getVehicleNumber();
        Long entryGateId = request.getEntryGateId();
        VehicleType vehicleType = request.getVehicleType();

        try {
            ticket = ticketService.generateTicket(entryGateId
                    , vehicleType
                    , vehicleNumber);
        }
        catch (InvalidGateException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("Gate ID is invalid");
        } catch (SpotNotAvailableException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage("No parking spot available");
        }

        response.setTicketId(ticket.getId());
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setOperatorName(ticket.getTicketIssuer().getName());
        response.setSpotNumber(ticket.getParkingSpot().getSpotNumber());

        return response;
    }
}
