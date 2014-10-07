
import fontys.time.Period2;
import fontys.time.Time;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sam
 */
public class Period2Test {

    private Period2 period2;

    public Period2Test() {

    }

    @Before
    public void setUp() {
        period2 = new Period2(new Time(2014, 1, 1, 12, 00), new Time(2014, 1, 1, 12, 30));

    }

    @Test
    public void testPeriod() {
        // Check lenght difference of 30 minutes.
        assertEquals(30, period2.length());

        Period2 p = new Period2(new Time(2014, 1, 1, 12, 00), new Time(2014, 1, 1, 12, 40));
        // Union return null
        assertNull(period2.unionWith(p));
    }

    @Test
    public void constructorPeriodTest() {
        // Begin time is later then end time
        try {
            Period2 pc = new Period2(new Time(2014, 1, 1, 12, 30), new Time(2014, 1, 1, 12, 00));
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void getTimeTest() {
        Period2 testPeriod = new Period2(period2.getBeginTime(), period2.getEndTime());
        // Begin time equals to 1-1-2014 12:00
        assertEquals(testPeriod.getBeginTime(), period2.getBeginTime());

        // End time equals to 1-1-2014 12:30
        assertEquals(testPeriod.getEndTime(), period2.getEndTime());
    }

    @Test
    public void setTimeTest() {

        // Set begin time after end time. 
        try {
            period2.setBeginTime(new Time(2014, 1, 1, 13, 00));
            fail();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        // Set end time before begin time.
        try {
            period2.setEndTime(new Time(2014, 1, 1, 11, 00));
            fail();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    @Test
    public void lenghtTest() {
        // Change lenght with -60.
        // End time is set before Begin time.

        try {
            period2.changeLengthWith(-60);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

}
