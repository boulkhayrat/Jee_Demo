package com.mid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mid.model.Livre;

public class LivreDao implements InterfaceLivreDao{

	@Override
	public List<Livre> getLivres() {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		List<Livre> livres = new ArrayList<Livre>();
		
		
		try {
			
			ps = con.prepareStatement("select * from Livre;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Livre l = new Livre();
				l.setIsbn(rs.getInt(1));
				l.setTitre(rs.getString(2));
				l.setDescription(rs.getString(3));
				l.setDate_editing(rs.getString(4));
				l.setEditeur(rs.getString(5));
				l.setMatricule(rs.getInt(6));
				
				livres.add(l);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return livres;
		
	}

	@Override
	public void ajouterLivre(Livre l) {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into Livre (isbn,titre,description,date_editing,editeur,matricule) values (?,?,?,?,?,?);");
			
			ps.setInt(1, l.getIsbn());
			ps.setString(2, l.getTitre());
			ps.setString(3, l.getDescription());
			ps.setString(4, l.getDate_editing());
			ps.setString(5, l.getEditeur());
			ps.setInt(6, l.getMatricule());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

	@Override
	public void modifierLivre(int isbn, Livre l) {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update Livre set isbn=?,titre=?,description=?,date_editing=?,editeur=?,matricule=? where isbn=?;");
			
			ps.setInt(1, l.getIsbn());
			ps.setString(2, l.getTitre());
			ps.setString(3, l.getDescription());
			ps.setString(4, l.getDate_editing());
			ps.setString(5, l.getEditeur());
			ps.setInt(6, l.getMatricule());
			ps.setInt(7, isbn);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerLivre(int isbn) {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from Livre where isbn=?;");
			ps.setInt(1, isbn);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Livre selectLivre(int isbn) {
		
		
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		Livre l = null;
		
		try {
			
			ps = con.prepareStatement("select * from Livre where isbn=?;");
			ps.setInt(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				l = new Livre();
				l.setIsbn(rs.getInt(1));
				l.setTitre(rs.getString(2));
				l.setDescription(rs.getString(3));
				l.setDate_editing(rs.getString(4));
				l.setEditeur(rs.getString(5));
				l.setMatricule(rs.getInt(6));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Livre selectLivrebyMat(int matricule) {

		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		Livre l = null;
		
		try {
			
			ps = con.prepareStatement("select * from Livre where matricule=?;");
			ps.setInt(1, matricule);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				l = new Livre();
				l.setIsbn(rs.getInt(1));
				l.setTitre(rs.getString(2));
				l.setDescription(rs.getString(3));
				l.setDate_editing(rs.getString(4));
				l.setEditeur(rs.getString(5));
				l.setMatricule(rs.getInt(6));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}

}
