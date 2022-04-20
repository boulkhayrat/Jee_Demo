import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mid.dao.MysqlConnection;
import com.mid.model.Livre;


	public class Test{
	
		public static void main(String[] args) {
		
			
			
			
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps;
			List<Livre> livres = new ArrayList<Livre>();
			
			try {
				
					ps = con.prepareStatement("select * from Livre ;");
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
			System.out.println(livres.size());
		}
	
	}
	


