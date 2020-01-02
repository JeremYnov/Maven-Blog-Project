package ynov.jeremy.dao;

import java.util.List;

import ynov.jeremy.model.Autor;

public interface DAOAutor {
	public List<Autor> getAllAutors();
	public void addAutor(Autor autor);
	public void loginAutor(Autor autor);
	public boolean getValidation();
}
