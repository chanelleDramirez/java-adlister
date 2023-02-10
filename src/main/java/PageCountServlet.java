import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageCountServlet", urlPatterns = "/count")
public class PageCountServlet extends HttpServlet {
    private int hitCount;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("reset") != null) {
            hitCount = 0;
        }
        hitCount++;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hit count: " + hitCount + "</h1>");
    }
}