package lv.javaguru.java2.servlet.originals;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author <a href="mailto:viktor.savonin@odnoklassniki.ru">Viktor Savonin</a>
 */
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
	                     HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");


		// Set response content type
		resp.setContentType("text/html");

		// Prepare output html
		PrintWriter out = resp.getWriter();
		out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");		
		out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
	}

}
