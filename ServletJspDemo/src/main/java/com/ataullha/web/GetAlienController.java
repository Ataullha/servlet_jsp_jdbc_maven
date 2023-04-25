package com.ataullha.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ataullha.web.dao.AlienDao;
import com.ataullha.web.model.Alien;

/**
 * Servlet implementation class GetAlienController
 */
public class GetAlienController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
//		import package using crtl+shift+o
		AlienDao dao = new AlienDao();
		Alien a1 = dao.getAlien(aid);
		
//		sending alien to a1 for jsp page
//		request.setAttribute("alien", a1);
//		
////		dispatcher
//		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
//		rd.forward(request, response);
//		
		
		HttpSession session = request.getSession();
		session.setAttribute("alien",a1);
		
		response.sendRedirect("showAlien.jsp");
	}

}
