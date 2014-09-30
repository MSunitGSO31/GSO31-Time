/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fontys.time;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Sam
 */
public class Time implements ITime{

    private GregorianCalendar calendar;
    
    public Time(int y, int m, int d, int h, int min){
//        if((h >= 0) && (h < 24) && (m >= 0) && (m < 59)){
//            if((m == 1) && (m == 3) && (m == 5) && (m == 7) && (m == 8) && (m == 8) && (m == 10) && (m == 12)){
//                
//            }
//        }
//        if((m > 0) && (m < 13) && (d > 0) && (d < 32) )
            calendar = new GregorianCalendar(y, m, d, h, min);

    }
    
    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH) - 1;
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    @Override
    public int getHours() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    @Override
    public int getMinutes() {
       
    }

    @Override
    public DayInWeek getDayInWeek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITime plus(int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int difference(ITime time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(ITime o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
