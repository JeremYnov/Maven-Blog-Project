package ynov.jeremy.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ynov.jeremy.dao.DAOAutor;
import ynov.jeremy.dao.DAOFactory;
import ynov.jeremy.model.Autor;

public class LoginForm {
	 DAOFactory factory = new DAOFactory();
	 DAOAutor daoautor = factory.getDaoAutor();
	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public static String getChampEmail() {
		return CHAMP_EMAIL;
	}
	public static String getChampPass() {
		return CHAMP_PASS;
	}
	public String getResult() {
	    return result;
	}
	public Map<String, String> getErrors() {
	    return errors;
	}
	
	public Autor loginAutor(HttpServletRequest req) {
		String email = getValeurChamp( req, CHAMP_EMAIL );
	    String password = getValeurChamp( req, CHAMP_PASS );
	    
	    Autor autor = new Autor();
	    
	    try {
	        validationEmail( email );
	    } catch ( Exception e ) {
	        setError( CHAMP_EMAIL, e.getMessage() );
	    }
	    autor.setMail( email );
	    
	    try {
	        validationPassword( password);
	    } catch ( Exception e ) {
	        setError( CHAMP_PASS, e.getMessage() );
	    }
	    autor.setPassword( password );
	    
	    if ( errors.isEmpty() && daoautor.getValidation() == true) {
	        result = "Vous vous êtes connecté avec succès !";
	        
	    } else {
	        result = "Échec de l'inscription.";
	    }
	    
	    return autor;
	}
	
	/* Méthode de validation des infos entrées par l'utilisateur */ 
	
	private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
	private void validationPassword( String password ) throws Exception {
        if ( password != null ) {
            if ( password.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
	
	
	private void setError( String champ, String message ) {
        errors.put( champ, message );
    }
    private static String getValeurChamp( HttpServletRequest req, String nameChamp ) {
        String valeur = req.getParameter( nameChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

}
