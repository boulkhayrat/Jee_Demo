package com.mid.model;

public class Livre {
	private int isbn;
	private String titre;
	private String description;
	private String date_editing;
	private String editeur;
	private int matricule;

	public static boolean valid;
	
	public Livre() {
		super();
	}

	public Livre(String titre, String description, String date_editing, String editeur, int matricule) {
		super();
		this.titre = titre;
		this.description = description;
		this.date_editing = date_editing;
		this.editeur = editeur;
		this.matricule = matricule;
	}

	public Livre(int isbn, String titre, String description, String date_editing, String editeur, int matricule) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.description = description;
		this.date_editing = date_editing;
		this.editeur = editeur;
		this.matricule = matricule;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_editing() {
		return date_editing;
		

	}
	public void setDate_editing(String date_editing) {
		this.date_editing = date_editing;
	}
	public String getEditeur() {
		
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur=editeur;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
}
