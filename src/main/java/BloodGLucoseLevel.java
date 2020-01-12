

import java.io.Serializable;
import java.net.URISyntaxException;
import java.sql.*;
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
            PreparedStatement ps;
            ps = connection.prepareStatement("insert into logs (level, date) values(?,?)");
            ps.setString(1, String.valueOf(level));
            ps.setString(2, date);

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
