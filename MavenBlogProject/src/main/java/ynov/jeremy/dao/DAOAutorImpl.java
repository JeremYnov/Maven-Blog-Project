package ynov.jeremy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ynov.jeremy.model.Article;
import ynov.jeremy.model.Autor;

public class DAOAutorImpl implements DAOAutor {
	private Connection connection = null;
	private boolean validation ;
	public DAOAutorImpl(Connection co) {
		this.connection = co;
	}
	
	public Autor getAutor(int id) {
		Autor autor = new Autor();
		try {
			String query = "SELECT * FROM autor WHERE autor_id=?;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();

			while (resultat.next()) {
				autor.setId(resultat.getInt("autor_id"));
				autor.setName(resultat.getString("autor_name"));
				autor.setSurname(resultat.getString("autor_surname"));
				autor.setMail(resultat.getString("autor_mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autor;

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
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM autor WHERE autor_mail=? AND autor_password=?");
			
			ps.setString(1, autor.getMail());
			ps.setString(2, autor.getPassword());
			ResultSet result = ps.executeQuery();
			setValidation(result.next());
			if(getValidation()) {
				System.out.println("L'utilisateur à été trouvé dans la BDD");
				autor.setId(result.getInt("autor_id"));
				autor.setName(result.getString("autor_name"));
				autor.setSurname(result.getString("autor_surname"));
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
	
	public List<Article> getAllArticles() {
		List<Article> listArticle = new ArrayList<Article>();
		try {
			String query = "SELECT *, DATE_FORMAT(article_date, '%d %b %Y') FROM article JOIN autor ON article.autor_id=autor.autor_id ORDER BY article.autor_id,article_id;";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Article article = new Article();
				Autor autor = new Autor();
				article.setId(resultat.getInt("article_id"));
				article.setTitle(resultat.getString("article_title"));
				article.setDescription(resultat.getString("article_description"));
				article.setContent(resultat.getString("article_content"));
				article.setDate(resultat.getDate("article_date"));
				autor.setId(resultat.getInt("autor_id"));
				autor.setName(resultat.getString("autor_name"));
				autor.setSurname(resultat.getString("autor_surname"));
				article.setAutor(autor);
				listArticle.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listArticle;
	}
	
	public List<Article> getArticlesByAutor(int id) {
		List<Article> articlesByAutor = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article JOIN autor ON autor.autor_id = article.autor_id WHERE article.autor_id=?;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet resultat = ps.executeQuery();
			
			while (resultat.next()) {
				Article article = new Article();
				Autor autorArticle = new Autor();
				article.setId(resultat.getInt("article_id"));
				article.setTitle(resultat.getString("article_title"));
				article.setDescription(resultat.getString("article_description"));
				article.setContent(resultat.getString("article_content"));
				article.setDate(resultat.getDate("article_date"));
				
				autorArticle.setId(resultat.getInt("autor_id"));
				autorArticle.setName(resultat.getString("autor_name"));
				autorArticle.setSurname(resultat.getString("autor_surname"));
				article.setAutor(autorArticle);
				articlesByAutor.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articlesByAutor;
	}
	
	

	public boolean getValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}
}
