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
public class Time implements ITime {

    public GregorianCalendar calendar;

    public Time(int y, int m, int d, int h, int min) {
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
        switch (day) {
            case 1:
                diwEnum = DayInWeek.MON;
            case 2:
                diwEnum = DayInWeek.TUE;
            case 3:
                diwEnum = DayInWeek.WED;
            case 4:
                diwEnum = DayInWeek.THU;
            case 5:
                diwEnum = DayInWeek.FRI;
            case 6:
                diwEnum = DayInWeek.SAT;
            case 7:
                diwEnum = DayInWeek.SUN;
        }
        return diwEnum;
    }

    @Override
    public ITime plus(int minutes) {
        int newMinutes = calendar.get(Calendar.MINUTE);
        newMinutes = newMinutes + minutes;
        return new Time(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_YEAR), calendar.get(Calendar.HOUR_OF_DAY), newMinutes);
    }

    @Override
    public int difference(ITime time) {
//        long diff = calendar.getTime().getTime() - time.calendar.getTime().getTime();
//        if (diff < 0){
//            diff = diff + (diff*2);
//        }
//        diff = diff / 60000;
//        return (int) diff;
        return 0;
    }

    @Override
    public int compareTo(ITime o) {
        return 0;
    }

}
