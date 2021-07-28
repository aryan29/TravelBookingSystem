package com.java.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.java.travel.Activity;
import org.junit.Test;
public class TestActivity {
    @Test(expected = Exception.class)
    public void testBookActivityOne() throws Exception {
        Activity a = new Activity("Para", "ad", 400, 2);
        a.bookActivity();
        a.bookActivity();
        a.bookActivity();
        assertEquals(0, a.getCapacity());
    }

    @Test
    public void testBookActivityTwo() throws Exception {
        Activity a = new Activity("Para", "ad", 400, 3);
        a.bookActivity();
        a.bookActivity();
        assertEquals(1, a.getCapacity());
    }
}
