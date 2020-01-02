package ynov.jeremy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ynov.jeremy.model.Autor;

public class DAOAutorImpl implements DAOAutor {
	private Connection connection = null;
	private boolean validation ;
	public DAOAutorImpl(Connection co) {
		this.connection = co;
	}

	public void addAutor(Autor autor) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO autor (autor_name,autor_surname,autor_mail,autor_password) VALUES(?,?,?,?);");
			preparedStatement.setString(1, autor.getName());
			preparedStatement.setString(2, autor.getSurname());
			preparedStatement.setString(3, autor.getMail());
			preparedStatement.setString(4, autor.getPassword());
			int statut = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void loginAutor(Autor autor) {
		setValidation(false);
		//System.out.println("Validation entrée de boucle"+getValidation());
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM autor WHERE autor_mail=? AND autor_password=?");
			
			ps.setString(1, autor.getMail());
			ps.setString(2, autor.getPassword());
			ResultSet result = ps.executeQuery();
			setValidation(result.next());
			//System.out.println("Validation in boucle"+ getValidation());
			if(getValidation()) {
				System.out.println("L'utilisateur a été trouvé dans la BDD");
			}else {
				System.out.println("L'utilisateur est introuvable dans la BDD");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Autor> getAllAutors() {
		List<Autor> listAutor = new ArrayList<Autor>();
		try {
			String query = "SELECT * FROM autor;";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Autor autor = new Autor();
				autor.setId(resultat.getInt("autor_id"));
				autor.setName(resultat.getString("autor_name"));
				autor.setSurname(resultat.getString("autor_surname"));
				autor.setMail(resultat.getString("autor_mail"));
				listAutor.add(autor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAutor;
	}

	public boolean getValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}
}
