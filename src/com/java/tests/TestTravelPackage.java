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

public class TestTravelPackage {
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
    public void testMaxPassengers() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("You can't add more passengers to this travel package");
        Passenger p1 = new Passenger("Aryan", "437483", 24224, "Basic", t2);
        Passenger p2 = new Passenger("Ishaan", "437493", 24224, "Basic", t2);
        Passenger p3 = new Passenger("Ishita", "437403", 24224, "Basic", t2);
    }

    @Test
    public void testMaxActivities() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("No empty seats available for this activity");
        Passenger p1 = new Passenger("Aryan", "437483", 24224, "Basic", t2);
        Passenger p2 = new Passenger("Ishaan", "43743", 24224, "Basic", t2);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        p2.enrollActivity(1);
        p2.enrollActivity(2);
    }

    @Test
    public void testBalanceLeftBasic() throws Exception {
        Passenger p1 = new Passenger("Aryan", "437483", 24224, "Basic", t2);
        Passenger p2 = new Passenger("Ishaan", "43743", 24224, "Basic", t2);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        p2.enrollActivity(1);

        assertEquals((14224), p1.getBalance());
    }

    @Test
    public void testBalanceLeftPremium() throws Exception {
        Passenger p1 = new Passenger("Aryan", "437483", 24224, "Premium", t2);
        Passenger p2 = new Passenger("Ishaan", "43743", 24224, "Basic", t2);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        p2.enrollActivity(1);

        assertEquals((24224), p1.getBalance());
    }

    @Test
    public void testActivitiesLeft() throws Exception {
        Passenger p1 = new Passenger("Aryan", "437483", 24224, "Premium", t2);
        Passenger p2 = new Passenger("Ishaan", "43743", 24224, "Basic", t2);
        p1.enrollActivity(1);
        p1.enrollActivity(2);
        p2.enrollActivity(1);
        int available = 0;
        for (int i = 0; i < t2.getAllActivities().size(); i++) {
            if (t2.getAllActivities().get(i).checkAvailabilty())
                available++;
        }
        assertEquals(0, available);
    }
}
