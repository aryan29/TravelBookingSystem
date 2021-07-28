package com.java.travel;

import java.util.ArrayList;

/**
 * Class storing information for a single destination
 */
public class Destination {

    /**
     * Name of destination
     */
    private String name;

    /**
     * All activities available at particlar destination
     */
    private ArrayList<Activity> activities;

    /**
     * Constructor
     * 
     * @param name       Name of destination
     * @param activities All activities available at particlar destination
     */
    public Destination(String name, ArrayList<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    /*-----------------Getters----------------*/
    public String getName() {
        return name;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }
    /*------------------------------------------------ */
}
