package ynov.jeremy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import ynov.jeremy.dao.DAOArticle;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Article;

public class AddArticle extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/addArticle.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("article_title");
		String description = req.getParameter("article_description");
		String content = req.getParameter("article_content");
		req.setAttribute("title", title);
		req.setAttribute("article_description", description);
		req.setAttribute("article_content", content);
		Article addarticle = new Article();
		addarticle.setTitle(title);
		addarticle.setDescription(description);
		addarticle.setContent(content);

		DAOFactory factory = new DAOFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		daoarticle.addArticle(addarticle);

		resp.sendRedirect( req.getContextPath() + "/articles");
	}

}
