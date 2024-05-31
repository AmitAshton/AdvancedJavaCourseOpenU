package Question2;

import java.util.Random;

public class Simulation {

    private static final int SIZE = 12;
    private static final int FLIGHT_NUMBER_STARTER = 100;

    public static void main(String[] args) {
        Airport TLV = new Airport("TLV", 3);
        Airport JFK = new Airport("JFK", 3);

        Random rand = new Random();
        Flight[] flights = new Flight[SIZE];

        for (int i = 0; i < SIZE; i++) {
            Airport departureAirport = rand.nextBoolean() ? TLV : JFK;

            Airport arrivalAirport = departureAirport == TLV ? JFK : TLV;

            int flightNumber = FLIGHT_NUMBER_STARTER + i;
            flights[i] = new Flight(departureAirport, arrivalAirport, flightNumber);
        }

        for (Flight flight : flights) {
            flight.start();
        }
    }
}
