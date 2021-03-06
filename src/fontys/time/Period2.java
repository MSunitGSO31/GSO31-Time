/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Sam
 */
public class Period2 implements IPeriod {

    private ITime beginTime;
    private long duration;

    /**
     * creation of a Period2 object with begin time and end time
     *
     * @param beginTime begin time bt must be earlier than end time et
     * @param endTime
     */
    public Period2(ITime beginTime, ITime endTime) {

        if (beginTime.compareTo(endTime) == 1) {
            throw new IllegalArgumentException();
        }

        this.beginTime = beginTime;

        duration = beginTime.difference(endTime);
    }

    @Override
    public ITime getBeginTime() {
        return beginTime;
    }

    @Override
    public ITime getEndTime() {
        return beginTime.plus((int)duration);
    }

    @Override
    public int length() {
        return (int) duration;
    }

    @Override
    public void setBeginTime(ITime newBeginTime) {
        if ((beginTime.plus((int)duration)).compareTo(newBeginTime) == 1) {
            beginTime = newBeginTime;
        } else {
            throw new IllegalArgumentException("Begin time after End Time!");
        }
    }

    @Override
    public void setEndTime(ITime newEndTime) {
        if (beginTime.compareTo(newEndTime) == -1) {
            duration = beginTime.difference(newEndTime);
        } else {
            throw new IllegalArgumentException("Begin time after End Time!");
        }
    }

    @Override
    public void move(int minutes) {
        beginTime.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if ((minutes + this.length()) > 0) {
            duration += minutes;
        } else {
            throw new IllegalArgumentException("Length became negative!");
        }
    }

    @Override
    public boolean isPartOf(IPeriod period) {
        if (beginTime.compareTo(period.getBeginTime()) == -1) {
            int intDuration = (int) duration;
            if (beginTime.plus(intDuration).compareTo(period.getEndTime()) == 1) {
                return true;
            } else {
                return false;
            }
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
        if (period.length() > this.length()) {
            return period;
        }
        return this;
    }

}
