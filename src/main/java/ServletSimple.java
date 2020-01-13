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
//this server handles http request for log entry for simple method. they are three different implementation for the three different methods
//on the server side, we can just make reference of the request  by sending either to /simple /commprehensive /intensive
@WebServlet(urlPatterns={"/simple"},loadOnStartup = 1)
public class ServletSimple extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        resp.setContentType("text/html");


//        CreateDB database = new CreateDB();
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
        SimpleMethod simple=gson.fromJson(reqBody,SimpleMethod.class);//create a new instance of the simple method and fill in using gson
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
            ps = connection.prepareStatement("insert into logs (method,date,glucoselevel) values(1,'?','?');");//look at database architecture
            ps.setString(1, String.valueOf(simple.getDate()));
            ps.setString(2, String.valueOf(simple.getBGL()));
            ps.executeUpdate();//populate database using prepared statements.

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