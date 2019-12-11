package Entries;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Activity {
    //Important: This is how our Strings of date and time will look like always.
    protected Date date = Calendar.getInstance().getTime();//Setting the date to today's date.
    protected DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    protected DateFormat tf = new SimpleDateFormat("HH:mm");
    public Activity(){
}
    public void setDate(Date d){ date = d; }
    public String getDate(){return df.format(date);}
}
