package com.mid.dao;

import java.util.List;

import com.mid.model.Auteur;


public interface InterfaceAuteurDao {
	public List<Auteur> getAuteurs();
	public void ajouterAuteur(Auteur a);
	public void modifierAuteur(int matricule,Auteur a);
	public void supprimerAuteur(int matricule);
	public Auteur selectAuteur(int matricule);

}
