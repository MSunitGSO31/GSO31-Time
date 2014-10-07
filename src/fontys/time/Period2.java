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
    private ITime endTime;
    private long duration;

    public Period2(ITime beginTime, ITime endTime) {

        if (beginTime.compareTo(endTime) == 1) {
            throw new IllegalArgumentException();
        }

        this.beginTime = beginTime;
        this.endTime = endTime;

        duration = beginTime.difference(endTime);
    }

    @Override
    public ITime getBeginTime() {
        return beginTime;
    }

    @Override
    public ITime getEndTime() {
        return endTime;
    }

    @Override
    public int length() {
        return (int) duration;
    }

    @Override
    public void setBeginTime(ITime newBeginTime) {
        if (endTime.compareTo(newBeginTime) == 1) {
            beginTime = newBeginTime;
        } else {
            throw new IllegalArgumentException("Begin time after End Time!");
        }
    }

    @Override
    public void setEndTime(ITime newEndTime) {
        if (beginTime.compareTo(newEndTime) == -1) {
            endTime = newEndTime;
            duration = beginTime.difference(endTime);
        } else {
            throw new IllegalArgumentException("Begin time after End Time!");
        }
    }

    @Override
    public void move(int minutes) {
        beginTime.plus(minutes);
        endTime.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if ((minutes + this.length()) > 0) {
            endTime.plus(minutes);
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
