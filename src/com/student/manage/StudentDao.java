package com.student.manage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean InsertStudentToDB(Student st) {
		boolean flag = false;
		try {
			//jdbc code..
			Connection con = ConnectionProvider.CreateConnection();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			//Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			//Set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			//Execute
			pstmt.executeUpdate();
			flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
	    boolean flag = false;
	    try {
	        // JDBC code
	        Connection con = ConnectionProvider.CreateConnection();
	        System.out.println("Connection: " + con);  // Debug: Check if connection is valid

	        String q = "delete from students where sid = ?";
	        // Prepared Statement
	        PreparedStatement pstmt = con.prepareStatement(q);

	        // Set the values of parameters
	        pstmt.setInt(1, userId);

	        // Execute
	        int rowsAffected = pstmt.executeUpdate();  // Capture the number of affected rows
	        System.out.println("Rows affected: " + rowsAffected);  // Debug output

	        if (rowsAffected > 0) {
	            flag = true;
	            System.out.println("Student with ID " + userId + " deleted successfully.");
	        } else {
	            System.out.println("No student found with ID " + userId);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();  // This will help in debugging any issues
	    }
	    return flag;
	}


	public static void showAllStudents() {
		boolean flag = false;
		try {
			//jdbc code..
			Connection con = ConnectionProvider.CreateConnection();
			String q = "select * from students";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				System.out.println();
				System.out.println("------------------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
