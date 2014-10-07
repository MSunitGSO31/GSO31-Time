/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author  Specification:   Martijn
 * @author  Implementation:  Sam
 */
public class Appointment {
    
    private String subject;
    private IPeriod period;
    
    private ArrayList<Contact> contactList;
    
    public Appointment(String subject, IPeriod period){
        this.subject = subject;
        this.period = period;
        contactList = new ArrayList<Contact>();
    }
    
    /**
     * 
     * @return String of the subject
     */
    public String getSubject(){
        return subject;
    }
    
    /**
     * 
     * @return This period
     */
    public IPeriod getPeriod(){
        return period;
    }
    
    /**
     * 
     * @return Iterator with type: Contact.
     */
    public Iterator<Contact> invitees(){
        return contactList.iterator();
    }
    
    /**
     * 
     * @param c Contact to add
     * @return True if contact is added else return false.
     */
    public boolean addContact(Contact c){
        if(c.addAppointment(this) == true){
            contactList.add(c);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Removes contact
     * @param c Contact to remove
     */
    public void removeContact(Contact c){
        ArrayList<Contact> removeContactList = new ArrayList<Contact>();
        for(Contact contact : contactList){
            if(contact == c){
                removeContactList.add(contact);
            }
        }
        for(Contact contact : removeContactList){
            contactList.remove(contact);
        }       
    }
}
