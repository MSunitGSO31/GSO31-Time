

import fontys.time.Appointment;
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
public class AppointmentTest {
    Appointment app;
    
    @Before
    public void setUp() {
        app = new Appointment("SubjectTest",new Period(new Time(2014,1,1,12,00),new Time(2014,1,1,12,30)));
        
    }
    
    @Test
    public void getTest()
    {
        // Check if subject equals to "SubjectTest"
        assertEquals("SubjectTest",app.getSubject());
        
        // Check if period 
    }
    
    
    
}
