/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Sam
 */
public class Time implements ITime {

    public GregorianCalendar calendar;

    public Time(int y, int m, int d, int h, int min) {

        if ((m < 1) || (m > 12)) {
            throw new IllegalArgumentException("Invalid month");
        }

        if ((d < 1) || (d > 31)) {
            throw new IllegalArgumentException("Invalid day");
        }

        if ((h < 0) || (h > 23)) {
            throw new IllegalArgumentException("Invalid hour");
        }

        if ((min < 0) || (min > 59)) {
            throw new IllegalArgumentException("Invalid minute");
        }

        if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
            if (d > 30) {
                throw new IllegalArgumentException("Invalid combination of y-m-d");
            }
        } else if (m == 2) {
            if (d > 29) {
                throw new IllegalArgumentException("Invalid combination of y-m-d (In february)");
            }
        }

        calendar = new GregorianCalendar(y, m, d, h, min);

    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getHours() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    @Override
    public int getMinutes() {
        return calendar.get(Calendar.MINUTE);
    }
    
    @Override
    public DayInWeek getDayInWeek() {
        DayInWeek diwEnum = null;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);

        
        if(day == 1){
            diwEnum = DayInWeek.SUN;
        } else if (day == 2){
            diwEnum = DayInWeek.MON;
        } else if (day == 3){
            diwEnum = DayInWeek.TUE;
        } else if (day == 4){
            diwEnum = DayInWeek.WED;
        } else if (day == 5){
            diwEnum = DayInWeek.THU;
        } else if (day == 6){
            diwEnum = DayInWeek.FRI;
        } else if (day == 7){
            diwEnum = DayInWeek.SAT;
        } 
        return diwEnum;
    }

    @Override
    public ITime plus(int minutes) {
        calendar.add(Calendar.MINUTE, minutes);
        return this;
    }

    @Override
    public int difference(ITime time) {
        Time timeObj = (Time) time;
        long diff = calendar.getTime().getTime() - timeObj.getCalendar().getTime().getTime();

        diff = diff / 60000;
        int intDiff = (int) diff;
        if (intDiff < 10) {
            intDiff = intDiff + (intDiff * -2);
        }
        return intDiff;
    }

    @Override
    public int compareTo(ITime o) {
        Time timeObj = (Time) o;
        if (calendar.getTime().getTime() < timeObj.getCalendar().getTime().getTime()) {
            return -1;
        } else if (calendar.getTime().getTime() == timeObj.getCalendar().getTime().getTime()) {
            return 0;
        } else {
            return 1;
        }
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

}
