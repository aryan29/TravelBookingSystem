package com.java.travel;

import java.util.HashSet;
import java.util.Objects;

/**
 * Class storing information for one passenger
 */
public class Passenger {

    /**
     * Class storing information for one activity enrolled by partiular passenger
     */
    private class ActivityEnrolled {

        /**
         * Actvity enrolled
         */
        private Activity activity;

        /**
         * Price paid for that activity
         */
        private int pricePaid = 0;

        /**
         * Constructor
         * 
         * @param activity Acitvity object
         */
        ActivityEnrolled(Activity activity) {
            this.activity = activity;

            this.pricePaid = activity.getCost();
            if (mySubscription == SubscriptionType.Gold) {
                this.pricePaid -= this.pricePaid * 10 / 100;
            } else if (mySubscription == SubscriptionType.Premium) {
                this.pricePaid = 0;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(activity.getName());
        }

        @Override
        public boolean equals(Object obj) {
            ActivityEnrolled act = (ActivityEnrolled) obj;
            return (this.activity.getName().equals(act.activity.getName()));
        }

        /*-----------------Getters/Setters----------------*/
        public Activity getActivity() {
            return activity;
        }

        public int getPricePaid() {
            return pricePaid;
        }
        /*------------------------------------------------ */

    }

    /**
     * Enum for type of subscription passenger have
     */
    enum SubscriptionType {
        Basic, Gold, Premium;
    }

    /**
     * Name of passenger
     */
    private String name;

    /**
     * Passenger number
     */
    private String passengerNumber;

    /**
     * Current balance of passenger
     */
    private int balance;

    /**
     * Travel package of this passenger
     */
    private TravelPackage travelPackage;

    /**
     * Subscription type for this passenger
     */
    private SubscriptionType mySubscription;

    /**
     * List of activites this passenger is enrolled for
     */
    HashSet<ActivityEnrolled> activitesEnrolled = new HashSet<ActivityEnrolled>();

    /**
     * Constructor
     * 
     * @param name            Name of passenger
     * @param passengerNumber Passenger number
     * @param balance         Balance of passenger
     * @param subsciption     Subscription type for this passenger
     * @param travelPackage   Object of Travelling package
     * @throws Exception If subsciption type provided is invalid
     */
    public Passenger(String name, String passengerNumber, int balance, String subsciption, TravelPackage travelPackage)
            throws Exception {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        if (travelPackage != null)
            travelPackage.addPassenger(this);
        setSubscription(subsciption);
    }

    /**
     * Prints name of passenger
     */
    public void name() {
        System.out.println("Name :- " + name);
    }

    /**
     * Prints passenger number
     */
    public void passengerNumber() {
        System.out.println("Passenger Number :- " + passengerNumber);
    }

    /**
     * Prints current balance
     */
    public void balance() {
        System.out.println("Purse Balance :- " + balance);
    }

    /**
     * Prints list of actvities the passenger is enrolled for and the price he paid
     * for each activity
     */
    public void activitesEnrolled() {
        for (ActivityEnrolled activity : activitesEnrolled) {
            System.out.println("Actvity Name :- " + activity.getActivity().getName());
            System.out.println("Price Paid :- " + activity.getPricePaid());
        }
    }

    /**
     * Print all details of passenger
     */
    public void details() {
        name();
        passengerNumber();
        balance();
        activitesEnrolled();
    }

    /**
     * Sets subsciptions
     * 
     * @param subsciption Type of subscription
     * @throws Exception Raise exception if subscription provided is invalid
     */
    private void setSubscription(String subsciption) throws Exception {
        if (subsciption.equalsIgnoreCase("Basic")) {
            mySubscription = SubscriptionType.Basic;
        } else if (subsciption.equalsIgnoreCase("Gold")) {
            mySubscription = SubscriptionType.Gold;
        } else if (subsciption.equalsIgnoreCase("Premium")) {
            mySubscription = SubscriptionType.Premium;
        } else {
            throw new Exception("Invalid subscription type");
        }
    }

    /**
     * Sets Travel package
     * @param travelPackage TravelPackage object
     */
    public void setTravelPackage(TravelPackage travelPackage){
        this.travelPackage = travelPackage;
    }

    /**
     * Check if you have sufficient balance to enroll in activity or not
     * @param money Money required to enroll in Activity 
     * @return true if yes
     * @throws Exception Raise exception in case you dont have sufficient money
     */
    private boolean checkSufficientBalance(int money) throws Exception{
        if (balance >= money){
            return true;
        }
        else{
            throw new Exception("You don't have sufficient balance to get enrolled in the activity");
        }
    }
    /**
     * Used to Enroll in particular activity
     * 
     * @param activityId Activity ID for this activity is TravelPackage
     * @throws Exception In case of invalid enroll
     */
    public void enrollActivity(int activityId) throws Exception {
        try {
            Activity activity = travelPackage.getActivity(activityId - 1);
            ActivityEnrolled current_activity = new ActivityEnrolled(activity);
            if (activitesEnrolled.contains(current_activity)) {
                throw new Exception("You are already enrolled in this activity");
            } else {
                if (checkSufficientBalance(current_activity.pricePaid)) {
                    activity.bookActivity();
                    balance -= current_activity.pricePaid;
                    activitesEnrolled.add(current_activity);
                }
            }

        } catch (IndexOutOfBoundsException e) {
            throw new Exception("No such activity in the travel pacakge enrolled");
        }
    }

    /*-----------------Getters----------------*/
    public int getBalance() {
        return balance;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }
    /*------------------------------------------------ */

}
