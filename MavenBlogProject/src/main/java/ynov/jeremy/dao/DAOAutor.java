package ynov.jeremy.dao;

import java.util.List;

import ynov.jeremy.model.Article;
import ynov.jeremy.model.Autor;

public interface DAOAutor {
	public Autor getAutor(int id);
	public List<Autor> getAllAutors();
	public List<Article> getArticlesByAutor(int id);
	public void addAutor(Autor autor);
	public void loginAutor(Autor autor);
	public boolean getValidation();
}
