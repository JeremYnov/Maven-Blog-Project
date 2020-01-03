package ynov.jeremy.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ynov.jeremy.dao.DAOAutor;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.forms.LoginForm;
import ynov.jeremy.model.Autor;


public class Login extends HttpServlet{
	public static final String ATT_USER = "autor";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION = "autorSession";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginForm form = new LoginForm();

        Autor autor = form.loginAutor( req );

        HttpSession session = req.getSession();
        
        DAOFactory factory = new DAOFactory();
		DAOAutor daoautor = factory.getDaoAutor();
        
        req.setAttribute( ATT_FORM, form );
        req.setAttribute( ATT_USER, autor );
        daoautor.getValidation();
        daoautor.loginAutor(autor);
       // System.out.println("Test boolean validation"+daoautor.getValidation());

        if ( form.getErrors().isEmpty() && daoautor.getValidation() == true ) {
            session.setAttribute( ATT_SESSION, autor );
        	//System.out.println("La session est créée");
            resp.sendRedirect( req.getContextPath() + "/index");
        } else {
            session.setAttribute( ATT_SESSION, null );
            //System.out.println("La session n'est pas créée");
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
	}
}
