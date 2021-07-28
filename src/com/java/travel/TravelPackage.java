package com.java.travel;

import java.util.ArrayList;

/**
 * Class storing information for one Travel Package
 */
public class TravelPackage {

    /**
     * Name of travel package
     */
    private String name;

    /**
     * Max number of passengers that can be enrolled in this travel package
     */
    private int capacity;

    /**
     * List of destinations that can be visited using this travel package
     */
    private ArrayList<Destination> destinations = new ArrayList<Destination>();

    /**
     * List of passengers enrolled in this travel package
     */
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    /**
     * List of all activities that a person can enjoy using this travel package
     */
    private ArrayList<Activity> allActivities = new ArrayList<Activity>();

    /**
     * Constructor
     * 
     * @param name         Name of travel package
     * @param capacity     Max number of passengers that can be enrolled in this
     *                     travel package
     * @param destinations List of destinations for this travel package
     */
    public TravelPackage(String name, int capacity, ArrayList<Destination> destinations) {
        this.name = name;
        this.capacity = capacity;
        this.destinations = destinations;
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                allActivities.add(activity);
            }
        }
    }

    /**
     * Prints name of this travel package
     */
    public void name() {
        System.out.println("Name of Travel Package :- " + name);
    }

    /**
     * Print description of this travel package
     */
    public void description() {
        name();
        System.out.println("Description of travel package");
        for (Destination destination : destinations) {
            System.out.println("Destination Name :- " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity Name :- " + activity.getName());
                System.out.println("Cost :- " + activity.getCost());
                System.out.println("Capacity :- " + activity.getCapacity());
                System.out.println("Description :- " + activity.getDescription());
                System.out.println();
            }
        }
    }

    /**
     * Prints all available actvities in this travel package
     */
    public void activitesAvailable() {
        System.out.println("Activities available in travel package "+name);
        int counter = 1;
        for (Activity activity : allActivities) {
            if (activity.checkAvailabilty()) {
                System.out.println("Activity ID :- " + counter);
                System.out.println("Name :- " + activity.getName());
                System.out.println("Cost :- " + activity.getCost());
                System.out.println("Capacity :- " + activity.getCapacity());
                System.out.println();
            }

            counter++;
        }
    }

    /**
     * Checks if we can add more passengers to this travel package or not
     * 
     * @return true or false
     */
    private boolean canAddPassenger() {
        return passengers.size() < capacity;
    }

    /**
     * Function for adding a passenger in travel package
     * 
     * @param passenger Passenger object
     * @throws Exception
     */
    public void addPassenger(Passenger passenger) throws Exception {
        if (canAddPassenger()) {
            passengers.add(passenger);
            passenger.setTravelPackage(this);
        } else {
            throw new Exception("You can't add more passengers to this travel package");
        }

    }

    /**
     * Prints passengers list for this travel package
     */
    public void passengersList() {
        name();
        System.out.println("Max capacity of Travel Package :- " + capacity);
        System.out.println("Number of passengers enrolled :- " + passengers.size());
        System.out.println("Passengers list");
        for (Passenger passenger : passengers) {
            passenger.name();
            passenger.passengerNumber();
            System.out.println();
        }
    }

    /*-----------------Getters----------------*/
    public ArrayList<Activity> getAllActivities() {
        return allActivities;
    }

    public Activity getActivity(int activityId) {
        return (allActivities.get(activityId));
    }
    /*------------------------------------------------ */

}
