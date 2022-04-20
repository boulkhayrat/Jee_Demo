package com.mid.dao;

import java.util.List;

import com.mid.model.Livre;

public interface InterfaceLivreDao {
	
	public List<Livre> getLivres();
	public void ajouterLivre(Livre l);
	public void modifierLivre(int isbn,Livre l);
	public void supprimerLivre(int isbn);
	public Livre selectLivre(int isbn);
	public Livre selectLivrebyMat (int matricule);

}
