package com.mid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mid.model.Auteur;

public class AuteurDao implements InterfaceAuteurDao {


	@Override
	public List<Auteur> getAuteurs() {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		List<Auteur> Auteurs = new ArrayList<Auteur>();
		
		
		try {
			
			ps = con.prepareStatement("select * from Auteur;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Auteur l = new Auteur();
				l.setMatricule(rs.getInt(1));
				l.setNom(rs.getString(2));
				l.setPrenom(rs.getString(3));
				l.setGenre(rs.getString(4));
				
				Auteurs.add(l);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Auteurs;
		
	}

	@Override
	public void ajouterAuteur(Auteur l) {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into Auteur (matricule,nom,prenom,genre) values (?,?,?,?);");
			
			ps.setInt(1, l.getMatricule());
			ps.setString(2, l.getNom());
			ps.setString(3, l.getPrenom());
			ps.setString(4, l.getGenre());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

	@Override
	public void modifierAuteur(int matricule, Auteur l) {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update Auteur set matricule=?,nom=?,prenom=?,genre=? where matricule=?;");
			
			ps.setInt(1, l.getMatricule());
			ps.setString(2, l.getNom());
			ps.setString(3, l.getPrenom());
			ps.setString(4, l.getGenre());
			
			ps.setInt(5, matricule);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimerAuteur(int matricule) {
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from Auteur where matricule=?;");
			ps.setInt(1, matricule);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Auteur selectAuteur(int matricule) {
		
		
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		Auteur l = null;
		
		try {
			
			ps = con.prepareStatement("select * from Auteur where matricule=?;");
			ps.setInt(1, matricule);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				l = new Auteur();
				l.setMatricule(rs.getInt(1));
				l.setNom(rs.getString(2));
				l.setPrenom(rs.getString(3));
				l.setGenre(rs.getString(4));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
