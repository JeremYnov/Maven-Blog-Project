package ynov.jeremy.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ynov.jeremy.model.Autor;

public class SignupForm {
	private static final String CHAMP_NAME   = "name";
	private static final String CHAMP_SURNAME  = "surname";
	private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private static final String CHAMP_CONF   = "confirmation";
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public static String getChampName() {
		return CHAMP_NAME;
	}
	public static String getChampSurname() {
		return CHAMP_SURNAME;
	}
	public static String getChampEmail() {
		return CHAMP_EMAIL;
	}
	public static String getChampPass() {
		return CHAMP_PASS;
	}
	public static String getChampConf() {
		return CHAMP_CONF;
	}
	public String getResult() {
	    return result;
	}
	public Map<String, String> getErrors() {
	    return errors;
	}
	
	public Autor signupAutor( HttpServletRequest req ) {
		String name = getValeurChamp( req, CHAMP_NAME );
		String surname = getValeurChamp( req, CHAMP_SURNAME );
	    String email = getValeurChamp( req, CHAMP_EMAIL );
	    String password = getValeurChamp( req, CHAMP_PASS );
	    String confirmation = getValeurChamp( req, CHAMP_CONF );
	    

	    Autor autor = new Autor();

	    try {
	        validationName( name );
	    } catch ( Exception e ) {
	        setError( CHAMP_NAME, e.getMessage() );
	    }
	    autor.setName(name);
	    
	    try {
	        validationSurname( surname );
	    } catch ( Exception e ) {
	        setError( CHAMP_SURNAME, e.getMessage() );
	    }
	    autor.setSurname(surname);
	    
	    try {
	        validationEmail( email );
	    } catch ( Exception e ) {
	        setError( CHAMP_EMAIL, e.getMessage() );
	    }
	    autor.setMail( email );

	    try {
	        validationPassword( password, confirmation );
	    } catch ( Exception e ) {
	        setError( CHAMP_PASS, e.getMessage() );
	        setError( CHAMP_CONF, null );
	    }
	    autor.setPassword( password );

	    if ( errors.isEmpty() ) {
	        result = "Vous vous êtes inscrit avec succès !";
	        
	    } else {
	        result = "Échec de l'inscription.";
	    }

	    return autor;
	}

	private void validationName( String name ) throws Exception {
	    if ( name != null && name.length() < 2 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
	    }else if(name==null){
	    	throw new Exception( "Merci de saisir un prénom." );
	    }
	}
	private void validationSurname(String surname) throws Exception {
	    if ( surname != null && surname.trim().length() < 2 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
	    }else if(surname==null){
	    	throw new Exception( "Merci de saisir un nom." );
	    }
	}
	
	private void validationEmail( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	private void validationPassword( String password, String confirmation ) throws Exception {
	    if ( password != null && confirmation != null ) {
	        if ( !password.equals( confirmation ) ) {
	            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } else if ( password.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	
	
	
	
	private void setError( String champ, String message ) {
	    errors.put( champ, message );
	}
	
	private static String getValeurChamp( HttpServletRequest request, String nameChamp ) {
	    String valeur = request.getParameter( nameChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
}
