package ynov.jeremy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOArticle;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Article;

public class DeleteArticle extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		
		String idUrl = req.getParameter("id");
		int idArticle= Integer.parseInt(idUrl);
		
		Article deletearticle = new Article();
		
		deletearticle.setId(idArticle);
		daoarticle.deleteArticle(deletearticle);
		
		resp.sendRedirect( req.getContextPath() + "/articles");
	}

}
