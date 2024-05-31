package Question2;

import java.util.Random;

public class Flight extends Thread{

    private Airport departureAirport;

    private Airport arrivalAirport;

    private int flightNumber;

    private final int TIME = 5 * 1000;

    public Flight(Airport departureAirport, Airport arrivalAirport, int flightNumber) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightNumber = flightNumber;
    }

    public void run() {
        int flightDepartRunway = departureAirport.depart(flightNumber);

        System.out.println("Departure from " + departureAirport.getAirportName() + " started for flight number " + flightNumber);
        waitRandomTime();

        departureAirport.freeRunway(flightNumber, flightDepartRunway);
        System.out.println(flightNumber + " Flying, Hope you enjoy our multimedia!");
        waitRandomTime();

        int flightLandRunway = arrivalAirport.land(flightNumber);

        System.out.println("Landing towards " + arrivalAirport.getAirportName() + " started!");
        waitRandomTime();

        arrivalAirport.freeRunway(flightNumber, flightLandRunway);
        System.out.println("Landed in " + arrivalAirport.getAirportName() + "! Hope you enjoyed your flight! ");
    }

    public void waitRandomTime() {
        Random r = new Random();
        try {
            sleep(r.nextInt(TIME));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
