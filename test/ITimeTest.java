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
        if(time.getYear())
        //assertNotNull(time);


        //Test false Time object creation

        time = new Time(2014, 14, 30, 10, 27);
        time = new Time(2014, 9, 35, 10, 27);
        time = new Time(2014, 9, 30, -12, 27);
        time = new Time(2014, 9, 30, 10, 800);
            //assertNull(time);

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
