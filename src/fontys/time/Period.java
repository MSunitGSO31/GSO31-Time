/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author martijn
 */
public class Period implements IPeriod {

    ITime BT;
    ITime ET;

    /**
     * creation of a period with begin time bt and end time et
     *
     * @param bt begin time bt must be earlier than end time et
     * @param et
     */
    public Period(ITime bt, ITime et) {
        if (bt.getMinutes() < et.getMinutes()) {
            this.BT = bt;
            this.ET = et;
        } else {
            throw new IllegalArgumentException("Begint time is equal or bigger then End time");
        }
    }

    @Override
    public ITime getBeginTime() {
        return BT;
    }

    @Override
    public ITime getEndTime() {
        return ET;
    }

    @Override
    public int length() {
        return ET.getMinutes() - BT.getMinutes();
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        if (ET.difference(beginTime) > 0) {
            BT = beginTime;
        } else {
            throw new IllegalArgumentException("Begin time after End Time!");
        }
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (BT.difference(endTime) > 0) {
            ET = endTime;
        } else {
            throw new IllegalArgumentException("Begint time earlier then Begin Time!");
        }
    }

    @Override
    public void move(int minutes) {
        ET.plus(minutes);
        BT.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if ((minutes + this.length()) > 0) {
            ET.plus(minutes);
        } else {
            throw new IllegalArgumentException("Length became negative!");
        }
    }

    @Override
    public boolean isPartOf(IPeriod period) 
    {
        if (BT.compareTo(period.getBeginTime()) == -1 || BT.compareTo(period.getBeginTime()) == 0) {
            return ET.compareTo(period.getEndTime()) == 1;
        } 
        else 
        {
            return false;
        }
    }

    @Override
    public IPeriod unionWith(IPeriod period) {
        if (period.intersectionWith(this) == this) {
            return period;
        }
        return null;
    }

    @Override
    public IPeriod intersectionWith(IPeriod period) {
        if (period.length() > this.length()) {
            return period;
        }
        return this;
    }

}
