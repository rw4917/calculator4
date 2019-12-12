import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/patients"},loadOnStartup = 1)
public class MyServlet extends HttpServlet {
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
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        BloodGLucoseLevel lev=gson.fromJson(reqBody,BloodGLucoseLevel.class);
        String str2 = String.valueOf(lev.getLevel());

        resp.setContentType("text/html");
        resp.getWriter().write(str2);
        resp.getWriter().write("Thank you client!");
    }

}