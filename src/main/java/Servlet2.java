import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/logs"},loadOnStartup = 1)
public class Servlet2 extends HttpServlet {
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
        RegistrationDetails reg=gson.fromJson(reqBody,RegistrationDetails.class);
        String str2 = String.valueOf(reg.getEmail());

        resp.setContentType("text/html");
        resp.getWriter().write(str2);
        resp.getWriter().write("Thank you client!");
    }

}