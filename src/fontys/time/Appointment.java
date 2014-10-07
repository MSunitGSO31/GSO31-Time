/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fontys.time;

import java.util.Iterator;

/**
 *
 * @author Sam + Martijn
 */
public class Appointment {
    
    public Appointment(String subject, IPeriod period){
        
    }
    
    /**
     * 
     * @return String of the subject
     */
    public String getSubject(){
        throw new UnsupportedOperationException("Not supported yet!");
    }
    
    /**
     * 
     * @return This period
     */
    public IPeriod getPeriod(){
        throw new UnsupportedOperationException("Not supported yet!");
    }
    
    /**
     * 
     * @return Iterator with type: Contact.
     */
    public Iterator<Contact> invitees(){
        throw new UnsupportedOperationException("Not supported yet!");
    }
    
    /**
     * 
     * @param c Contact to add
     * @return True if contact is added else return false.
     */
    public boolean addContact(Contact c){
        throw new UnsupportedOperationException("Not supported yet!");
    }
    
    /**
     * Removes contact
     * @param c Contact to remove
     */
    public void removeContact(Contact c){
        throw new UnsupportedOperationException("Not supported yet!");
    }
}
