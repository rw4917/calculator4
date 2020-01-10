

import java.io.Serializable;
import java.util.Date;

public class BloodGLucoseLevel implements Serializable {
    private String date;
    private double level ;
    public BloodGLucoseLevel()
    {
        level =0;
    }
    public double getLevel()
    {
        return level;
    }
    public void setLevel(double l)
    {
        level =1;
    }

    public void setDate(Date date) {
        this.date = new Date().toString();

    }
}
