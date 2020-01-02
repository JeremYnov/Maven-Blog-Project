package ynov.jeremy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOArticle;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Article;

public class ArticleServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		
		String idUrl = req.getParameter("id");
		int idArticle= Integer.parseInt(idUrl);
		req.setAttribute("IdArticle", idUrl);
		
		Article articlePage = new Article();
		articlePage = daoarticle.getArticle(idArticle);
		req.setAttribute("article", articlePage);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(req, resp);
	}

}
