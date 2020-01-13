package Methods;

import Entries.BloodGlucoseLevel;

import java.util.Date;
//we are using the same architecture that we found on the server side
public class SimpleMethod extends Method {


    protected BloodGlucoseLevel bgl = new BloodGlucoseLevel();
    protected boolean bglEntered;

    public SimpleMethod(){

    }


    public void setBgl(Date time, double level){

        bgl.setTime(time);
        bgl.setLevel(level);
        bglEntered = true;


    }
    public BloodGlucoseLevel getBGL(){
        return bgl;
    };

}

