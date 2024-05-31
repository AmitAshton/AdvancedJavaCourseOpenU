package Question2;

import java.util.ArrayList;

public class Airport {

    private final String airportName;

    private final int numOfRunways;

    private boolean[] freeRunways;

    private int empty;

    private ArrayList<Integer> flightsRequests;

    public Airport(String airportName, int numOfRunways) {
        this.airportName = airportName;
        this.numOfRunways = numOfRunways;
        this.freeRunways = new boolean[numOfRunways];

        for (int i = 0; i < numOfRunways; i++) {
            freeRunways[i] = true;
        }
        this.empty = numOfRunways;
        this.flightsRequests = new ArrayList<Integer>();
    }

    public synchronized int depart(int flightNumber){
        flightsRequests.add(flightNumber);
        while(empty == 0 && !flightsRequests.get(0).equals(flightNumber)){
            try {
                System.out.println("flight number " + flightNumber + " is waiting for a runway to depart in " + airportName);
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        for (int i = 0; i < freeRunways.length; i++) {
            if (freeRunways[i]) {
                empty--;
                freeRunways[i] = false;
                System.out.println("flight number " + flightNumber + " departs in runway number " + (i+1) + " in airport " + airportName);
                return i+1;
            }
        }

        return -1;
    }

    public synchronized int land(int flightNumber){
        flightsRequests.add(flightNumber);
        while(empty == 0 && !flightsRequests.get(0).equals(flightNumber)){
            try {
                System.out.println("flight number " + flightNumber + " is waiting for a runway to land in " + airportName);
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        for (int i = 0; i < freeRunways.length; i++) {
            if (freeRunways[i]) {
                empty--;
                freeRunways[i] = false;
                System.out.println("flight number " + flightNumber + " lands in runway number " + (i+1) + " in airport " + airportName);
                return i+1;
            }
        }
        return -1;
    }

    public synchronized void freeRunway(int flightNumber, int runwayNumber){
        System.out.println("flight number " + flightNumber + " finished with runway number " + runwayNumber + " in airport " + airportName);
        freeRunways[runwayNumber-1] = true;
        empty++;
        flightsRequests.remove((Integer) flightNumber);
        notifyAll();
    }

    public String getAirportName() {
        return airportName;
    }
}
