package ynov.jeremy.dao;

public class DAOFactory {

	private MySQLManager manager;
	private DAOArticle daoArticle;
	private DAOAutor daoAutor;

	public DAOFactory() {
		manager = MySQLManager.getInstance();
		daoArticle = new DAOArticleImpl(manager.getConnection());
		daoAutor = new DAOAutorImpl(manager.getConnection());
	}

	public DAOArticle getDaoArticle() {
		return daoArticle;
	}
	public DAOAutor getDaoAutor() {
		return daoAutor;
	}

}
