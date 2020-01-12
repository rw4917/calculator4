package Entries;

import java.util.Date;

public class Medication extends Activity {
    private Date time;
    private String dosage;
    private String name;
    private String type;

    public Medication(){

    }

    public void setName(String n){name =n;}

    public String getName() {
        return name;
    }

    public void setDosage(String l){
        dosage = l;
    }
    public String getDosage(){
        return dosage;
    }

    public void setType(String t) {type= t;}
    public String gettype(){return type;}


    public void setTime(Date t){ time = t; }
    public String getTime(){return tf.format(time) ;}
}
