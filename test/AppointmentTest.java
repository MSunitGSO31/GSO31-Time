

import fontys.time.Appointment;
import fontys.time.Contact;
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
    Period p;
    
    @Before
    public void setUp() {
        p = new Period(new Time(2014,1,1,12,00),new Time(2014,1,1,12,30));
        app = new Appointment("SubjectTest",p);
        
    }
    
    @Test
    public void appTest()
    {
        // Check if subject equals to "SubjectTest"
        assertEquals("SubjectTest",app.getSubject());
        
        // Check if period p equals to current period.
        assertEquals(p,app.getPeriod());
        
        Contact c = new Contact("TestContact");
        
        // Succesfully add a contact with name: TestContact
        assertTrue(app.addContact(c));
        
        // Remove existing contact added to appointment
        app.removeContact(c);
        
    }
    
    
    
}
