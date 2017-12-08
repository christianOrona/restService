package com.christianorona.restService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class ToyDAO {
	
	
	Connection conn = null;
	public ToyDAO(){
		// TODO Auto-generated constructor stub
		String url="jdbc:mysql://christianorona.com:3306/ToyCollector";
		String user="sarge";
		String pass="pass";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
	
	public List<Toy> getAllToys() {
		List<Toy> toys = new ArrayList<Toy>();
		String query = "select toy_id,toy_name,toy_photo_path,toy_desc from ToyCollector.TC_TOY where end_dt is null";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Toy t = new Toy();
				t.setToy_id(rs.getString(1));
				t.setToy_name(rs.getString(2));
				t.setToy_photo_path(rs.getString(3));
				t.setToy_desc(rs.getString(4));
				toys.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while fetching: "+e.getMessage());
		}
		return toys;
	}
	
	public Toy getToyById(String id) {
		Toy t = new Toy();
		String query = "select toy_id,toy_name,toy_photo_path,toy_desc from ToyCollector.TC_TOY where toy_id="+id;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				
				t.setToy_id(rs.getString(1));
				t.setToy_name(rs.getString(2));
				t.setToy_photo_path(rs.getString(3));
				t.setToy_desc(rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while fetching it: "+e.getMessage());
		}
		return t;
	}

	public void addToy(Toy t) {
		// TODO Auto-generated method stub
		String query = "insert into ToyCollector.TC_TOY values(?,?,?,?,?,NOW(),null,null)";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, this.getMaxRowID());
			st.setString(2, t.getToy_id());
			st.setString(3, t.getToy_name());
			st.setString(4, t.getToy_photo_path());
			st.setString(5, t.getToy_desc());
			
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while adding it: "+e.getMessage());
		}
	}
	
	public void updateToy(Toy t) {
		// TODO Auto-generated method stub
		String query = "update ToyCollector.TC_TOY set toy_name=?, toy_photo_path=?, toy_desc=? where TOY_ID=?";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			
			
			st.setString(1, t.getToy_name());
			st.setString(2, t.getToy_photo_path());
			st.setString(3, t.getToy_desc());
			st.setString(4, t.getToy_id());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while updatig it: "+e.getMessage());
		}
	}
	
	public void deleteToy(Toy t) {
		// TODO Auto-generated method stub
		String query = "update ToyCollector.TC_TOY set end_dt=NOW() where TOY_ID=?";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, t.getToy_id());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while deleting it: "+e.getMessage());
		}
	}
	private int getMaxRowID() {
		int val=0;
		String query = "select max(row_id)+1 from ToyCollector.TC_TOY";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				
				val = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while getting maxRowId: "+e.getMessage());
		}
		return val;
	}

}
