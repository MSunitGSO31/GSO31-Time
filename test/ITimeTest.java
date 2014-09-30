/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    public ITimeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * @Author Sam
     */
    @Test
    public void testTime() {
        //Test correct Time object creation

        time = new Time(2014, 9, 30, 10, 0);

        assertEquals(2014, time.getYear());
        assertEquals(9, time.getMonth());
        assertEquals(30, time.getDay());
        assertEquals(10, time.getHours());
        assertEquals(0, time.getMinutes());

        
        //Test false Time object creation
        time = new Time(2014, 14, 35, 88, 800);
    
        assertNotSame(2014, time.getYear());
        assertNotSame(14, time.getMonth());
        assertNotSame(35, time.getDay());
        assertNotSame(88, time.getHours());
        assertNotSame(800, time.getMinutes());
    }
}
