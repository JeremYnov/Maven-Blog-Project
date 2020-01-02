package ynov.jeremy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ynov.jeremy.model.Article;
import ynov.jeremy.model.Autor;

public class DAOArticleImpl implements DAOArticle {
	private Connection connection = null;

	public DAOArticleImpl(Connection co) {
		this.connection = co;
	}

	public Article getArticle(int id) {
		Article article = new Article();
		try {
			String query = "SELECT * ,DATE_FORMAT(article_date, '%d/%b/%Y') FROM article JOIN autor ON article.autor_id=autor.autor_id WHERE article_id=? ;" ;
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			
			while (resultat.next()) {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	public void addArticle(Article article) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO article (article_title,article_description,article_content,article_date,autor_id) VALUES(?,?,?,CURRENT_DATE(),1);");
			preparedStatement.setString(1, article.getTitle());
			preparedStatement.setString(2, article.getDescription());
			preparedStatement.setString(3, article.getContent());
			int statut = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateArticle(Article article) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE article SET article_title=?,article_description=?,article_content=?,article_date=CURRENT_DATE() WHERE article_id=?");

			preparedStatement.setString(1, article.getTitle());
			preparedStatement.setString(2, article.getDescription());
			preparedStatement.setString(3, article.getContent());
			preparedStatement.setInt(4, article.getId());

			int statut = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteArticle(Article article) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM article WHERE article_id = ?");
			preparedStatement.setInt(1, article.getId());
			
			int statut = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List<Article> getThreeLastArticles() {
		List<Article> listArticle = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM article JOIN autor ON article.autor_id=autor.autor_id GROUP BY article_id DESC LIMIT 3";
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

}
