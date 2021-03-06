package ynov.jeremy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOArticle;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Article;

public class Articles extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOArticle daoarticle = factory.getDaoArticle();

		List<Article> article = daoarticle.getAllArticles();
		req.setAttribute("articles", article);

		this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	}

}
