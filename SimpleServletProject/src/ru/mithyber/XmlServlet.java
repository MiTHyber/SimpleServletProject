package ru.mithyber;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String userName = req.getParameter("userName");
		writer.println("Hello from Get, " + userName + "!");
		writer.println("Xml init param:  " + getServletConfig().getInitParameter("defaultName") + "!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		String userName = req.getParameter("userName");
		String fullName = req.getParameter("fullName");
		writer.println("Hello from POST, " + userName + "! We know your full name " + fullName);
		String prof = req.getParameter("prof");
		writer.println("You are a(n) " + prof);
		String[] locations = req.getParameterValues("location");
		writer.println("You are " + Arrays.toString(locations));
	}
}
