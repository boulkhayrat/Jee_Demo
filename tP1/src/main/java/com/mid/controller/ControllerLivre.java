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
import com.mid.model.Livre;

/**
 * Servlet implementation class ControllerLivre
 */
@WebServlet("/index")
public class ControllerLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int isbnoldupdate;
	private static int isbnolddelete;
	InterfaceLivreDao mang;
	InterfaceAuteurDao mang1;
	@Override
	public void init() throws ServletException {
		 mang = new LivreDao();
		 mang1 = new AuteurDao();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		
		
			
				if(action.equals("ajouter")) {
					request.getRequestDispatcher("ajout.jsp").forward(request, response);
					
				}
				if(action.equals("modifier")) {
					isbnoldupdate =Integer.parseInt( request.getParameter("isbn"));
					Livre book = mang.selectLivre(isbnoldupdate);
					request.setAttribute("l", book);
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					
					
				}

				if(action.equals("supprimer")) {
					isbnolddelete = Integer.parseInt(request.getParameter("isbn"));
					mang.supprimerLivre(isbnolddelete);
					
					List<Livre> livres = mang.getLivres();
					System.out.println("size of list : " +livres.size());
					
					request.setAttribute("list", livres);
					request.getRequestDispatcher("list.jsp").forward(request, response);
					
				}

				if(action.equals("rechercher")) {
					try {
					int isb = Integer.parseInt(request.getParameter("isbn"));
					
					Livre book = mang.selectLivre(isb);
					
					List<Livre> livres = new ArrayList<>();
					livres.add(book);
			
					request.setAttribute("list", livres);
					request.getRequestDispatcher("list.jsp").forward(request, response);
					
				}catch(NumberFormatException ne) {
					
						List<Livre> livres = mang.getLivres();
						System.out.println("size of list : " +livres.size());
						
						request.setAttribute("list", livres);
						request.getRequestDispatcher("list.jsp").forward(request, response);
					}
				}
						
		
				if(action.equals("afficher")) {
					
					List<Livre> livres = mang.getLivres();
					System.out.println("size of list : " +livres.size());
					
					request.setAttribute("list", livres);
					request.getRequestDispatcher("list.jsp").forward(request, response);
				}
		
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Livre book;
		String action = request.getParameter("action");
		
		
		if(action.equals("ajouter")) {
			
			
			book = new Livre(); 
			book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
			book.setTitre(request.getParameter("titre"));
			book.setDescription(request.getParameter("description"));
			book.setDate_editing(request.getParameter("date"));
			book.setEditeur(request.getParameter("editeur"));
			book.setMatricule(Integer.parseInt(request.getParameter("matricule")));
						
			if(mang1.selectAuteur(Integer.parseInt(request.getParameter("matricule"))) != null )
			mang.ajouterLivre(book);
			else {
				request.setAttribute("error", "la matricule saisie n'appartient a aucun Auteur");
				request.getRequestDispatcher("list.jsp").forward(request, response);
			}

			List<Livre> livres = mang.getLivres();
			System.out.println("size of list : " +livres.size());
			
			request.setAttribute("list", livres);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
		
		 }
		
		if(action.equals("modifier")) {
			
			
					book = new Livre(); 
					book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
					book.setTitre(request.getParameter("titre"));
					book.setDescription(request.getParameter("description"));
					book.setDate_editing(request.getParameter("date"));
					book.setEditeur(request.getParameter("editeur"));
					book.setMatricule(Integer.parseInt(request.getParameter("matricule")));
								
			
			mang.modifierLivre(isbnoldupdate,book);
			
		//affichage de la nouvelle liste des livres avec celui qu'on vient de modifier
			
			List<Livre> livres = mang.getLivres();
			System.out.println("size of list : " +livres.size());
			
			request.setAttribute("list", livres);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}


	}	

}
