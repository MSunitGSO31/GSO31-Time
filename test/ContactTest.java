
import fontys.time.Appointment;
import fontys.time.Contact;
import fontys.time.Period;
import fontys.time.Time;
import static org.junit.Assert.*;
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
public class ContactTest {

    public Contact contact;

    @Test
    public void testContactConstructor() {

        //Test creation of Contact object.
        contact = new Contact("Henk");
        assertEquals("Henk", contact.getName());
    }

    @Test
    public void testAddAppointment() {
        
        //Test if appointment can be added
        contact = new Contact("Henk");
        assertTrue(contact.addAppointment(new Appointment("Vergadering", new Period(new Time(2014, 10, 7, 10, 0), new Time(2014, 10, 7, 11, 0)))));

        
        //Test that an overlapping appointment won't be added 
        assertFalse(contact.addAppointment(new Appointment("Vergadering", new Period(new Time(2014, 10, 7, 10, 30), new Time(2014, 10, 7, 11, 30)))));
    }

    @Test
    public void testRemoveAppointment() {
        
        //Test the removal of an appointment
        contact = new Contact("Henk");
        Appointment ap = new Appointment("Vergadering", new Period(new Time(2014, 10, 7, 10, 0), new Time(2014, 10, 7, 11, 0)));
        
        contact.addAppointment(ap);
        
        contact.removeAppointment(ap);
    }

}
