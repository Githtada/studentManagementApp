package com.studentdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	//jdbc code to insert student
	
	public static boolean insertStudentToDb(Student st) {
		
		boolean f=false;
		
		try {
			
			
		//jdbc code...
		Connection con = Connectionprovider.create();
		
		String query = "insert into students(sname,sphone,scity) values(?,?,?)";
		
		//preparedStatement
		PreparedStatement pstmt = con.prepareStatement(query);
		
		//set the values of parameters
		
		pstmt.setString(1,st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		
		//execute query
		pstmt.executeUpdate();
		f=true;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public static boolean deleteStudentToDb(int userId) {
		
		boolean f=false;
		try {
			
			
			//jdbc code...
			Connection con = Connectionprovider.create();
			
			String query = "delete from students where sid=?";
			
			//preparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//set the values of parameters
			
			pstmt.setInt(1,userId);
			
			
			//execute query
			pstmt.executeUpdate();
			f=true;
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
		
		
	}

	public static void showAllStudent() {
		
	
		try {
			
			
			//jdbc code...
			Connection con = Connectionprovider.create();
			
			String query = "select * from students;";
			
			//Statement
			Statement stmt =con.createStatement();
			
			//execute query
			ResultSet rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				
				System.out.println("Student id is : " +rset.getInt(1) +", Name : "+ rset.getString(2) +", Number : "+ rset.getString(3) +", City : "+ rset.getString(4));
			}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
		
		
		
		
	}
	
	

}
