package com.java.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import com.java.travel.Activity;
import com.java.travel.Destination;
import com.java.travel.Passenger;
import com.java.travel.TravelPackage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestPassenger {

    public TravelPackage t1, t2;
    public Activity a1, a2, a3, a4, a5, a6, a7;
    public Destination d1, d2, d3, d4, d5;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        a1 = new Activity("Paragliding", "XYZ", 3000, 2);
        a2 = new Activity("Rock Climbing", "XYZ", 1000, 2);
        a3 = new Activity("Bungee Jumping", "XYZ", 2000, 3);
        a4 = new Activity("Zip Line", "XYZ", 500, 4);
        a5 = new Activity("Air Balling", "XYZ", 1500, 2);
        a6 = new Activity("Para Sailing", "XYZ", 4000, 2);
        a7 = new Activity("See Diving", "XYZ", 6000, 1);
        d1 = new Destination("Bheemtaal", new ArrayList<Activity>(Arrays.asList(a1, a2)));
        d2 = new Destination("Manali", new ArrayList<Activity>(Arrays.asList(a3)));
        d3 = new Destination("Narkanda", new ArrayList<Activity>(Arrays.asList(a4, a5)));
        d4 = new Destination("Goa", new ArrayList<Activity>(Arrays.asList(a6)));
        d5 = new Destination("Pune", new ArrayList<Activity>(Arrays.asList(a7)));
        t1 = new TravelPackage("Trip to Mountains", 4, new ArrayList<Destination>(Arrays.asList(d1, d2, d3)));
        t2 = new TravelPackage("Trip to Seas", 2, new ArrayList<Destination>(Arrays.asList(d4, d5)));
    }

    @Test
    public void testInvalidSubscription() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Invalid subscription type");
        new Passenger("Aryan", "3238", 2327, "goldd",t1);
    }

    @Test
    public void testDuplicateActivitiesEnrolled() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("You are already enrolled in this activity");
        Passenger p1 = new Passenger("Aryan", "3238", 4327, "Gold",t1);
        p1.enrollActivity(1);
        p1.enrollActivity(1);
    }

    @Test
    public void testCorrectBalance() throws Exception {
        Passenger p1 = new Passenger("Aryan", "3238", 4327, "Gold",t1);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        assertEquals(727, p1.getBalance());
    }

    @Test
    public void TestInsufficientBalance() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("You don't have sufficient balance to get enrolled in the activity");
        Passenger p1 = new Passenger("Aryan", "3238", 4327, "Gold",t1);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        p1.enrollActivity(3);
    }

    @Test
    public void TestCaseOne() throws Exception {

        Passenger p1 = new Passenger("Aryan", "3238", 4327, "Gold",t1);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        Passenger p2 = new Passenger("Ishaan", "4500", 3871, "Premium", t1);
        Passenger p3 = new Passenger("Kushal", "9869", 1871, "Basic", t1);
        Passenger p4 = new Passenger("Shreyash", "3233", 3911, "Gold", t1);
        p2.enrollActivity(1);
        p2.enrollActivity(2);
        p3.enrollActivity(4);
        p4.enrollActivity(3);
        assertEquals(727, p1.getBalance());
        assertEquals(3871, p2.getBalance());
        assertEquals(1371, p3.getBalance());
        assertEquals(2111, p4.getBalance());
    }

}
