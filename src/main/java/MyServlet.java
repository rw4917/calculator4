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

@WebServlet(urlPatterns={"/patients"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


//        CreateDB database = new CreateDB();
        DBQuery q1 = new DBQuery();

        resp.getWriter().write(q1.getOutput());
        resp.getWriter().write("Hello world");

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In do post");
        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println("Json is " + reqBody);
        Gson gson = new Gson();
        RegistrationDetails reg = gson.fromJson(reqBody, RegistrationDetails.class);
        String str2 = String.valueOf(reg.getEmail());

        resp.setContentType("text/html");
        resp.getWriter().write(str2);
        resp.getWriter().write("Thank you client!");
        try
        {
            Connection connection = getConnection();
            Statement s = connection.createStatement();
            PreparedStatement ps;
            System.out.println("connection works");

            s.executeUpdate("DROP TABLE IF EXISTS patients");
            String sqlStr3 = "create table patients (\n" +
                    "                    id SERIAL PRIMARY KEY,\n" +
                    "                    familyname varchar(128) NOT NULL, givenname varchar(128) NOT NULL, phonenumber varchar(32)" +
                    ",username varchar(128), password varchar(128) " +
                    "            );\n";
            s.executeUpdate(sqlStr3);


            s.executeUpdate("insert into patients (familyname,givenname,phonenumber,username,password) values('Jones','Bill','07755678899','ruben','weitz');");
            ps = connection.prepareStatement("insert into patients (givenname,phonenumber,username,password) values('?','?','?','?');");
            ps.setString(1, String.valueOf(reg.getName()));
            ps.setString(2, String.valueOf(reg.getPhone()));
            ps.setString(3, String.valueOf(reg.getUserName()));
            ps.setString(4, String.valueOf(reg.getPassword()));
            ps.executeUpdate();
            System.out.println("inserted into tables");




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("Working until nnow");
        return DriverManager.getConnection(dbUrl);
    }
}