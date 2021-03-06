package ynov.jeremy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOAutor;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Autor;

public class Autors extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		DAOFactory factory = new DAOFactory();
		DAOAutor daoautor = factory.getDaoAutor();
		
		
		List<Autor> autors = daoautor.getAllAutors();
		req.setAttribute("autors", autors);
		this.getServletContext().getRequestDispatcher("/WEB-INF/autors.jsp").forward(req, resp);
	}

}
