package ynov.jeremy.dao;

import java.util.List;

import ynov.jeremy.model.Article;

public interface DAOArticle {
	public Article getArticle(int id);
	public List<Article> getAllArticles();
	public List<Article> getThreeLastArticles();
	public void addArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Article article);
}
