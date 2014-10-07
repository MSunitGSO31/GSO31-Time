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
 * @author Specification: Sam
 * @author Implementation: Martijn
 */
public class Contact {

    private String name;
    private ArrayList<Appointment> appointmentList;

    public Contact(String name) {
        this.name = name;
        appointmentList = new ArrayList<Appointment>();
    }

    /**
     *
     * @param a Appointment to add
     * @return true if add is succesfull. Test for overlap between appointments.
     * If there is overlap the appointmet will not be added.
     */
    public boolean addAppointment(Appointment a) {
        if (appointmentList.isEmpty() == false) {
            boolean canAdd = true;
            for (Appointment app : appointmentList) {
                if (app.getPeriod().intersectionWith(a.getPeriod()) != null) {
                    canAdd = false;
                }
            }
            if(canAdd == true){
                appointmentList.add(a);
                return  true;
            } else {
                return false;
            }
        }
        else
        {
            appointmentList.add(a);
            return true;
        }
    }

    /**
     *
     * @param a Appointment to remove
     */
    public void removeAppointment(Appointment a) {
        appointmentList.remove(a);
    }

    /**
     *
     * @return an interator of appointmentList
     */
    public Iterator<Appointment> appointments() {
        return appointmentList.iterator();
    }

    /**
     *
     * @return name of the contact
     */
    public String getName() {
        return this.name;
    }
}
