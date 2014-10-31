package fontys.time;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fontys.time.DayInWeek;
import fontys.time.Time;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sam
 */
public class ITimeTest {

    private Time time;
    private Time time2;

    public ITimeTest() {
    }


    /**
     * @Author Sam
     */
    @Test
    public void testTimeMethods() {
        //Test "dayInWeek" method
        time = new Time(2014, 9, 29, 10, 0);

        assertEquals(DayInWeek.MON, time.getDayInWeek());

        //Test "Plus" method
        time = new Time(2014, 9, 29, 10, 0);
        time2 = new Time(2014, 9, 30, 11, 10);

        time.plus(1510);

        assertEquals("Plus method is not working correctly", 0, time.compareTo(time2));

        //Test "difference" method
        time = new Time(2014, 9, 30, 10, 0);
        time2 = new Time(2014, 9, 30, 10, 10);

        assertEquals("Difference method is not working correctly", 10, time.difference(time2));

        //Test "compareTo" method
        time = new Time(2014, 9, 30, 10, 0);
        time2 = new Time(2014, 9, 30, 10, 10);
        assertEquals("CompareTo method is not working correctly", -1, time.compareTo(time2));

        time = new Time(2014, 9, 30, 10, 10);
        time2 = new Time(2014, 9, 30, 10, 0);
        assertEquals("CompareTo method is not working correctly", 1, time.compareTo(time2));

        time = new Time(2014, 9, 30, 10, 0);
        time2 = new Time(2014, 9, 30, 10, 0);
        assertEquals("CompareTo method is not working correctly", 0, time.compareTo(time2));

    }

    @Test
    public void testConstructorSimpleErrors() {
        //Check 1 ≤ m ≤ 12
        try {
            time = new Time(2014, -2, 20, 10, 0);
            fail("Able to submit a non existing Month (Month < 1)");
        } catch (IllegalArgumentException e) {
        }

        try {
            time = new Time(2014, 0, 20, 10, 0);
            fail("Able to submit a non existing Month (Month > 12)");
        } catch (IllegalArgumentException e) {
        }

        //Check 1 ≤ d ≤ 31 
        try {
            time = new Time(2014, 10, 40, 10, 0);
            fail("Able to submit a non existing Day (Day < 1)");
        } catch (IllegalArgumentException e) {
        }

        try {
            time = new Time(2014, 10, 0, 10, 0);
            fail("Able to submit a non existing Day (Day > 31)");
        } catch (IllegalArgumentException e) {
        }

        //Check 0 ≤ h ≤ 23 
        try {
            time = new Time(2014, 10, 20, -1, 0);
            fail("Able to submit a non existing Hour (Hour < 0)");
        } catch (IllegalArgumentException e) {
        }

        try {
            time = new Time(2014, 10, 20, 25, 0);
            fail("Able to submit a non existing Hour (Hour > 23)");
        } catch (IllegalArgumentException e) {
        }

        //Check 0 ≤ min ≤ 59 
        try {
            time = new Time(2014, 10, 20, 10, -1);
            fail("Able to submit a non existing Minute (Minute < 0)");
        } catch (IllegalArgumentException e) {
        }

        try {
            time = new Time(2014, 10, 20, 10, 61);
            fail("Able to submit a non existing Minute (Minute > 59)");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorComplexErrors() {

        //Check y-m-d refers to real time
        try {
            time = new Time(2014, 4, 31, 10, 0);
            fail("Submitted y-m-d cannot exist together");
        } catch (IllegalArgumentException e) {
        }

        try {
            time = new Time(2014, 2, 30, 10, 0);
            fail("Submitted y-m-d cannot exist together (February)");
        } catch (IllegalArgumentException e) {
        }
    }
}
