package Entries;

import java.util.Date;

public class Food extends Activity{
    private Date date;
    private String Name;
    private Double CarbAmount;

    public Food(){}

    public void setTime(Date d){
        date = d;
    }
    public Date getTime(){return date;}

}
