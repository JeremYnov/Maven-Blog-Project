package ynov.jeremy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynov.jeremy.dao.DAOArticle;
import ynov.jeremy.dao.DAOAutor;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.forms.SignupForm;
import ynov.jeremy.model.Article;
import ynov.jeremy.model.Autor;

public class Signup extends HttpServlet{
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SignupForm form = new SignupForm();
		
        Autor autor = form.signupAutor( req );
        
        DAOFactory factory = new DAOFactory();
		DAOAutor daoautor = factory.getDaoAutor();
        
		
        req.setAttribute( ATT_FORM, form );
        req.setAttribute( ATT_USER, autor );
        
        if ( form.getErrors().isEmpty() ) {
        	daoautor.addAutor(autor);
        	resp.sendRedirect( req.getContextPath() + "/index");
	    }else {
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
	    }
	}
	
	
	
}