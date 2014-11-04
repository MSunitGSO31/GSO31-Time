package fontys.time;



import fontys.time.Period;
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
 * @author martijn
 */
public class PeriodTest {
    private Period period;
    
    public PeriodTest()
    {
        
    }
    
    @Before
    public void setUp() {
        period = new Period(new Time(2014,1,1,12,00),new Time(2014,1,1,12,30));
        
    }
    
    @Test
    public void testPeriod()
    {
        // Check lenght difference of 30 minutes.
        assertEquals("Lenght difference isn't 30 minutes",30, period.length());
        
        
        Period p = new Period(new Time(2014,1,1,12,00),new Time(2014,1,1,12,40));
        // Union return null
        assertNull("Period is not null",period.unionWith(p));
    }
    
    @Test
    public void constructorPeriodTest()
    {
        // Begin time is later then end time
        try
        {
            Period pc = new Period(new Time(2014,1,1,12,30),new Time(2014,1,1,12,00));
            fail("End time before begin time");
        }
        catch(IllegalArgumentException e)
        {
            
        }
    }
    
    @Test
    public void getTimeTest()
    {
        Period testPeriod = new Period(period.getBeginTime(),period.getEndTime());
        // Begin time equals to 1-1-2014 12:00
        assertEquals("Begin time is not equal",testPeriod.getBeginTime(), period.getBeginTime());
        
        // End time equals to 1-1-2014 12:30
        assertEquals("End time is not equal",testPeriod.getEndTime(), period.getEndTime());
    }
    
    @Test
    public void setTimeTest()
    {
        
        // Set begin time after end time. 
        try
        {
            period.setBeginTime(new Time(2014,1,1,13,00));
            fail("Begin time set after end time");
        } 
        catch(IllegalArgumentException e)
        {
            e.getMessage();
        }
        
        // Set end time before begin time.
        try
        {
            period.setEndTime(new Time(2014,1,1,11,00));
            fail("End time before begin time");
        } 
        catch(IllegalArgumentException e)
        {
            e.getMessage();
        }
    }
    
    @Test
    public void lenghtTest()
    {
        // Change lenght with -60.
        // End time is set before Begin time.
        
        try
        {
            period.changeLengthWith(-60);
            fail("End time changed to -> before begin time");
        }
        catch(IllegalArgumentException e)
        {
            
        }
    }
    
    
    
}
