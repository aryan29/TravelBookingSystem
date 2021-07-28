
import java.util.ArrayList;
import java.util.Arrays;

import com.java.travel.Activity;
import com.java.travel.Destination;
import com.java.travel.Passenger;
import com.java.travel.TravelPackage;

public class Example {

    public static void main(String args[]) throws Exception {
        Activity a1 = new Activity("Paragliding", "XYZ", 3000, 2);
        Activity a2 = new Activity("Rock Climbing", "XYZ", 1000, 2);
        Activity a3 = new Activity("Bungee Jumping", "XYZ", 2000, 3);
        Activity a4 = new Activity("Zip Line", "XYZ", 500, 4);
        Activity a5 = new Activity("Air Balling", "XYZ", 1500, 2);
        Activity a6 = new Activity("Para Sailing", "XYZ", 4000, 2);
        Activity a7 = new Activity("See Diving", "XYZ", 6000, 1);
        Destination d1 = new Destination("Bheemtaal", new ArrayList<Activity>(Arrays.asList(a1, a2)));
        Destination d2 = new Destination("Manali", new ArrayList<Activity>(Arrays.asList(a3)));
        Destination d3 = new Destination("Narkanda", new ArrayList<Activity>(Arrays.asList(a4, a5)));
        Destination d4 = new Destination("Goa", new ArrayList<Activity>(Arrays.asList(a6)));
        Destination d5 = new Destination("Pune", new ArrayList<Activity>(Arrays.asList(a7)));
        TravelPackage t1 = new TravelPackage("Trip to Mountains", 4,
                new ArrayList<Destination>(Arrays.asList(d1, d2, d3)));
        TravelPackage t2 = new TravelPackage("Trip to Seas", 2, new ArrayList<Destination>(Arrays.asList(d4, d5)));
        t1.description();
        Passenger p1 = new Passenger("Aryan", "3238", 4327, "Gold",t1);
        p1.enrollActivity(1);
        System.out.println(p1.getBalance());
        p1.enrollActivity(2);
        System.out.println(p1.getBalance());
        p1.details();
        Passenger p2 = new Passenger("Ishaan", "4500", 3871, "Premium", t1);
        p2.details();
        Passenger p3 = new Passenger("Kushal", "9869", 1871, "Basic", t1);
        p3.details();
        Passenger p4 = new Passenger("Shreyash", "3233", 3911, "Basic", t1);
        p4.details();
        Passenger p5 = new Passenger("Vibhu", "2233", 2911, "Basic",t2);
        p5.details();

        p2.enrollActivity(1);
        p1.balance();
        p1.activitesEnrolled();
        p2.balance();
        p2.activitesEnrolled();
        p3.balance();
        p3.activitesEnrolled();
        t1.activitesAvailable();
        p4.balance();
        p4.enrollActivity(2);
        p4.balance();
        t1.passengersList();
        p1.details();
        t1.activitesAvailable();
    }
}
