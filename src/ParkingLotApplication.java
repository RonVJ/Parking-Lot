import controllers.TicketController;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import strategies.spotassignmentstrategy.SpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService = new TicketService(gateRepository
                                            , vehicleRepository
                                            , parkingLotRepository
                                            , ticketRepository
                                            , spotAssignmentStrategy);

        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Application has started");
    }
}
