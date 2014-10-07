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
public class Period implements IPeriod{
    
    ITime BT;
    ITime ET;
    
    /**
    * creation of a period with begin time bt and end time et
    * @param bt begin time bt must be earlier than end time et
    * @param et 
    */
    public Period(ITime bt, ITime et)
    {
        if(BT.getMinutes() < ET.getMinutes())
        {
            this.BT = bt;
            this.ET = et;
        }
        else
        {
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
        BT = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        ET = endTime;
    }

    @Override
    public void move(int minutes) {
        ET.plus(minutes);
        BT.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        ET.plus(minutes);
    }

    @Override
    public boolean isPartOf(IPeriod period) {
       // if(period.BT.calendar < BT.calendar  && (period.ET.calendar > ET.calendar))
       return period.equals(this);
    }

    @Override
    public IPeriod unionWith(IPeriod period) {
        if(period.intersectionWith(this) == this)
        {
            return period;
        }
        return null;
    }

    @Override
    public IPeriod intersectionWith(IPeriod period) {
        if(period.length() > this.length())
        {
            return period;
        }
        return this;
    }
    
}
