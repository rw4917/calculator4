package Entries;

import java.util.Date;

public class Medication extends Activity {
    private Date date;
    private double Dosage;
    private String type;

    public Medication(){

    }
    public void setDosage(double l){
        Dosage = l;
    }
    public double getDosage(){
        return Dosage;
    }

    public void setType(String t) {type = t;}
    public String gettype(){return type;}


    public void setTime(Date d){ date = d; }
    public Date getmTime(){return date;}
}
