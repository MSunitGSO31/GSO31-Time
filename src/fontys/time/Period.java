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

    private ITime bt;
    private ITime et;

    /**
     * creation of a period with begin time bt and end time et
     *
     * @param bt begin time bt must be earlier than end time et
     * @param et
     */
    public Period(ITime bt, ITime et) {
        if (bt.compareTo(et) == -1) {
            this.bt = bt;
            this.et = et;
        } else {
            throw new IllegalArgumentException("Begint time is equal or bigger then End time");
        }
    }

    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        return et;
    }

    @Override
    public int length() {
        return bt.difference(et);
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        if (et.compareTo(beginTime) == 1) {
            bt = beginTime;
        } else {
            throw new IllegalArgumentException("Begin time after End Time!");
        }
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (bt.compareTo(endTime) == -1) {
            et = endTime;
        } else {
            throw new IllegalArgumentException("Begint time earlier then Begin Time!");
        }
    }

    @Override
    public void move(int minutes) {
        et.plus(minutes);
        bt.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if ((minutes + this.length()) > 0) {
            et.plus(minutes);
        } else {
            throw new IllegalArgumentException("Length became negative!");
        }
    }

    @Override
    public boolean isPartOf(IPeriod period) {
        if (bt.compareTo(period.getBeginTime()) == -1 || bt.compareTo(period.getBeginTime()) == 0) {
            return et.compareTo(period.getEndTime()) == 1;
        } else {
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
        Period newPeriod = null;

        if (bt.compareTo(period.getBeginTime()) == -1) {
            if (et.compareTo(period.getBeginTime()) == 1) {
                if (et.compareTo(period.getEndTime()) == 1) {
                    newPeriod = new Period(period.getBeginTime(), period.getEndTime());
                } else {
                    newPeriod = new Period(period.getBeginTime(), et);
                }

            }
        }
        if (period.getBeginTime().compareTo(bt) == -1) {
            if (period.getEndTime().compareTo(et) == 1) {
                if (period.getEndTime().compareTo(bt) == 1) {
                    newPeriod = new Period(bt, et);
                } else {
                    newPeriod = new Period(bt, period.getEndTime());
                }
            }
        }
        return newPeriod;
    }

}
