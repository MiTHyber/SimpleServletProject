package ru.mithyber;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" }, initParams = {
		@WebInitParam(name = "defaultUser", value = "John Doe") })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("SimpleServlet created");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		ServletContext context = request.getServletContext();
		if (!"".equals(userName) && userName != null) {
			session.setAttribute("userName", userName);
			context.setAttribute("userName", userName);
		}
		writer.println("Request parameter has userName as " + userName);
		writer.println("Session parameter has userName as " + session.getAttribute("userName"));
		writer.println("Context parameter has userName as " + context.getAttribute("userName"));
		writer.println("Init parameter has default userName as " + getServletConfig().getInitParameter("defaultUser"));
	}

}
