package com.mid.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.dao.AuteurDao;
import com.mid.dao.InterfaceAuteurDao;
import com.mid.dao.InterfaceLivreDao;
import com.mid.dao.LivreDao;
import com.mid.model.Auteur;

/**
 * Servlet implementation class ControllerAuteur
 */
@WebServlet("/indexa")
public class ControllerAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int matriculeoldupdate;
	private static int matriculeolddelete;
	InterfaceAuteurDao mang;
	InterfaceLivreDao mang1;
	@Override
	public void init() throws ServletException {
		 mang = new AuteurDao();
		 mang1 = new LivreDao();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		
		
			
				if(action.equals("ajouter")) {
					request.getRequestDispatcher("ajoutAut.jsp").forward(request, response);
					
				}
				if(action.equals("modifier")) {
					matriculeoldupdate =Integer.parseInt( request.getParameter("matricule"));
					Auteur aut = mang.selectAuteur(matriculeoldupdate);
					request.setAttribute("l", aut);
					request.getRequestDispatcher("editAut.jsp").forward(request, response);
					
					
				}

				if(action.equals("supprimer")) {
					matriculeolddelete = Integer.parseInt(request.getParameter("matricule"));
					
					if(mang1.selectLivrebyMat(matriculeolddelete) == null) {
					mang.supprimerAuteur(matriculeolddelete);
					
					List<Auteur> Auteurs = mang.getAuteurs();
					System.out.println("size of list : " +Auteurs.size());
					
					request.setAttribute("Auteurs", Auteurs);
					request.getRequestDispatcher("listAut.jsp").forward(request, response);
					}
					else {
						request.setAttribute("error", "Supprimer les livres de cet Auteur premierment avant de tenter de le supprimer");
						List<Auteur> Auteurs = mang.getAuteurs();
						System.out.println("size of list : " +Auteurs.size());
						
						request.setAttribute("Auteurs", Auteurs);
						request.getRequestDispatcher("listAut.jsp").forward(request, response);
						
					}
					
				}

				if(action.equals("rechercher")) {
					try {
					int isb = Integer.parseInt(request.getParameter("matricule"));
					
					Auteur aut = mang.selectAuteur(isb);
					
					List<Auteur> Auteurs = new ArrayList<>();
					Auteurs.add(aut);
			
					request.setAttribute("Auteurs", Auteurs);
					request.getRequestDispatcher("listAut.jsp").forward(request, response);
					
				}catch(Exception e) {
					
						List<Auteur> Auteurs = mang.getAuteurs();
						System.out.println("size of list : " +Auteurs.size());
						
						request.setAttribute("Auteurs", Auteurs);
						request.getRequestDispatcher("listAut.jsp").forward(request, response);
					}
				}
						
		
				if(action.equals("afficher")) {
					
					List<Auteur> Auteurs = mang.getAuteurs();
					System.out.println("size of list : " +Auteurs.size());
					
					request.setAttribute("Auteurs", Auteurs);
					request.getRequestDispatcher("listAut.jsp").forward(request, response);
				}
		
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Auteur aut;
		String action = request.getParameter("action");
		
		if(action.equals("ajouter")) {
		 
			aut = new Auteur(); 
			aut.setMatricule(Integer.parseInt(request.getParameter("matricule")));
			aut.setNom(request.getParameter("nom"));
			aut.setPrenom(request.getParameter("prenom"));
			aut.setGenre(request.getParameter("genre"));
						
			mang.ajouterAuteur(aut);

			List<Auteur> Auteurs = mang.getAuteurs();
			System.out.println("size of list : " +Auteurs.size());
			
			request.setAttribute("Auteurs", Auteurs);
			request.getRequestDispatcher("listAut.jsp").forward(request, response);
			
			}
			
			
		
		 
		
		if(action.equals("modifier")) {
				
			 
				aut = new Auteur(); 
				aut.setMatricule(Integer.parseInt(request.getParameter("matricule")));
				
				aut.setNom(request.getParameter("nom"));
				aut.setPrenom(request.getParameter("prenom"));
				aut.setGenre(request.getParameter("genre"));
							
			
			mang.modifierAuteur(matriculeoldupdate,aut);
			
		//affichage de la nouvelle liste des Auteurs avec celui qu'on vient de modifier
			
			List<Auteur> Auteurs = mang.getAuteurs();
			System.out.println("size of list : " +Auteurs.size());
			
			request.setAttribute("Auteurs", Auteurs);
			request.getRequestDispatcher("listAut.jsp").forward(request, response);
		
			
	}

	}	
}
