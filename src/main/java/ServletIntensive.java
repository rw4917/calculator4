import Methods.CompMethod;
import Methods.IntensiveMethod;
import Methods.SimpleMethod;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.stream.Collectors;
//this server handles http request for log entry for simple method
@WebServlet(urlPatterns={"/intensive"},loadOnStartup = 1)
public class ServletIntensive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        resp.setContentType("text/html");


        DBQuery q1 = new DBQuery();

        resp.getWriter().write(q1.getOutput());
        resp.getWriter().write("Hello world");

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("In do post");
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println("Json is "+reqBody);
        Gson gson = new Gson();
        IntensiveMethod intense=gson.fromJson(reqBody, IntensiveMethod.class);
        String str2 = null;

        resp.setContentType("text/html");
        resp.getWriter().write(str2);
        resp.getWriter().write("Thank you client!");

        try
        {
            Connection connection = getConnection();
            Statement s = connection.createStatement();
            PreparedStatement ps;
            System.out.println("connection works");
            ps = connection.prepareStatement("insert into logs (method,date,glucoselevel,food,exercice,medecine) values(1,'?','?',?','?',?');");//look at database architecture
            ps.setString(1, String.valueOf(intense.getDate()));
            ps.setString(2, String.valueOf(intense.getBGL()));
            ps.setString(3, String.valueOf(intense.getFood()));
            ps.setString(4, String.valueOf(intense.getExercise()));
            ps.setString(5, String.valueOf(intense.getMed()));

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



    }
    private static Connection getConnection() throws URISyntaxException, SQLException {//method implementing the connection
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("Working until nnow");
        return DriverManager.getConnection(dbUrl);
    }

}