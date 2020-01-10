

import java.io.Serializable;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BloodGLucoseLevel implements Serializable
{
    private String date;
    private double level ;
    public BloodGLucoseLevel()
    {
        level =0;
        try
        {
            Connection connection = getConnection();
            Statement s = connection.createStatement();
            System.out.println("connection works");
        }
        catch (Exception e)
        {
            System.out.println("There was a problem:");
            e.printStackTrace();
        }
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
    private static Connection getConnection() throws URISyntaxException, SQLException
    {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("Working until nnow");
        return DriverManager.getConnection(dbUrl);
    }
}
