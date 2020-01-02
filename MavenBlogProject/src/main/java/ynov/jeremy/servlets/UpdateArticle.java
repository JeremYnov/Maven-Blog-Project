package ynov.jeremy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOArticle;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Article;

public class UpdateArticle extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		
		String idUrl = req.getParameter("id");
		int idArticle= Integer.parseInt(idUrl);
		req.setAttribute("IdArticle", idUrl);
		
		
		Article articlePage = new Article();
		articlePage = daoarticle.getArticle(idArticle);
		req.setAttribute("article", articlePage);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/updateArticle.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idUrl = req.getParameter("id");
		int idArticle= Integer.parseInt(idUrl);
		
		String title = req.getParameter("article_title");
		String description = req.getParameter("article_description");
		String content = req.getParameter("article_content");
		req.setAttribute("title", title);
		req.setAttribute("article_description", description);
		req.setAttribute("article_content", content);
		Article updatearticle = new Article();
		updatearticle.setTitle(title);
		updatearticle.setDescription(description);
		updatearticle.setContent(content);
		updatearticle.setId(idArticle);

		DAOFactory factory = new DAOFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		daoarticle.updateArticle(updatearticle);

		this.getServletContext().getRequestDispatcher("/WEB-INF/updateArticle.jsp").forward(req, resp);
	}

}
