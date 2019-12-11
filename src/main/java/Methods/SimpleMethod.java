package Methods;

import Entries.BloodGlucoseLevel;

import java.util.Date;

public class SimpleMethod extends Method {


    protected BloodGlucoseLevel bgl = new BloodGlucoseLevel();

    public SimpleMethod(){

    }
    public void setBgl(Date time, double level){
        //bgl.setDate(date);
        bgl.setTime(time);
        bgl.setLevel(level);

    }
    public BloodGlucoseLevel getBGL(){
        return bgl;
    };



}
