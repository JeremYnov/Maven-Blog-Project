package ynov.jeremy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOAutor;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Article;
import ynov.jeremy.model.Autor;

public class AutorServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		DAOFactory factory = new DAOFactory();
		
		DAOAutor daoautor = factory.getDaoAutor();
		
		String idUrl = req.getParameter("id");
		int idAutor = Integer.parseInt(idUrl);
		
		Autor autor = daoautor.getAutor(idAutor);
		List<Article> autorArticle = daoautor.getArticlesByAutor(idAutor);	
		
		req.setAttribute("autor", autor);
		req.setAttribute("autorArticle", autorArticle);
		this.getServletContext().getRequestDispatcher("/WEB-INF/autor.jsp").forward(req, resp);
	}

}
