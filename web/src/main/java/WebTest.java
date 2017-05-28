import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 23.05.2017.
 */
@WebServlet("/")
public class WebTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/testPage.jsp");
            req.setAttribute("test", new TestService().developerSetviceTest());
            requestDispatcher.forward(req, resp);
    }
}
