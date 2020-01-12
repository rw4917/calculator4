package Entries;

import java.util.Date;

public class Exercise extends Activity {
    public Date StartTime;
    public Date EndTime;
    private String Type;
    private String Name;

    public Exercise(){}

    public void setStartTime(Date start){ StartTime = start;}
    public String getStartTime(){return tf.format(StartTime);}

    public void setEndTime(Date end){EndTime = end;}
    public String getEndTime(){return tf.format(EndTime);}

    public void setType(String type){Type = type;}
    public String getType(){return Type;}

    public void setName(String name){Name = name;}
    public String getName(){return Name;}

}
