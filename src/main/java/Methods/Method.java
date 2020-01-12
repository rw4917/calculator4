package Methods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Method {

    protected DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private Date date = new Date();
    public Method(){

    }
    //Sets the date for each method to today's date.
    public String getDate() {
        return df.format(date);
    }
}
