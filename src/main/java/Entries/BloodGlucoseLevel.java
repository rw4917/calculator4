package Entries;

import java.util.Date;

public class BloodGlucoseLevel extends Activity {

    private Date time;
    private double level = 0;

    public BloodGlucoseLevel(){

    }

    public void setLevel(double l){
        level = l;
    }
    public double getLevel(){
        return level;
    }


    public void setTime(Date t){
        time = t;
    }
    public String getTime(){return tf.format(time);}



}
