import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int count;
        String name;
        try {
            count= Integer.parseInt(req.getParameter("count"));
        } catch (Exception e) {
            count = 1;
        }
        name = req.getParameter("name");
        if (name == null) {
            name = "World";
        }
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        for (int i = 0; i < count; i++) {
            out.println(String.format("<h1>Hello, %s</h1>", name));
        }
    }
}
