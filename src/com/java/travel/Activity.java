package com.java.travel;

/**
 * Class for single adventure activity available at some destination
 */
public class Activity {

    /**
     * Name of activity
     */
    private String name;

    /**
     * Description of actvity
     */
    private String description;

    /**
     * Cost for activity
     */
    private int cost;

    /**
     * Current capacity of activity , i.e. Number of People allowed for this activity at current time
     */
    private int capacity;

    /**
     * Constructor
     * 
     * @param name        Name of activity
     * @param description Description of actvity
     * @param cost        Cost for activity
     * @param capacity    Maximum people allowed for this activity
     */
    public Activity(String name, String description, int cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    /**
     * Check if we can enroll for this activity or not based on its current capacity
     * @return true or false
     */
    public boolean checkAvailabilty() {
        return capacity > 0;
    }

    /**
     * Book this activity
     * @throws Exception if no empty seats available for this activity
     */
    public void bookActivity() throws Exception {
        if (checkAvailabilty()) {
            capacity -= 1;
        }
        else {
            throw new Exception("No empty seats available for this activity");
        }
    }

    /*-----------------Getters----------------*/
    public String getName() {
        return name;
    }


    public int getCapacity() {
        return capacity;
    }


    public int getCost() {
        return cost;
    }

 
    public String getDescription() {
        return description;
    }
    /*------------------------------------------------ */


}
