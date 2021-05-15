package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public DeleteServlet() 
    {
        super();
        System.out.println("Servlet Instantiated");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String mysqlUrl = "jdbc:mysql://localhost:3307/h2h_internship";
		String username="root";
		String password="root";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		System.out.println("In doGet()");
		try
		{
			//Registering the Driver : 
			Class.forName("com.mysql.jdbc.Driver");
			
			//Getting the connection
			con = DriverManager.getConnection(mysqlUrl, username , password);
			
			//Setting auto-commit to false
	        con.setAutoCommit(false);
	        
			//SQL Statement to insert the data to the 'invoice_details' table
			String sql = "DELETE FROM invoice_details where doc_id=?";
            pstmt=con.prepareStatement(sql);
            
            Response obj=new Response();
            String b12=request.getParameter("doc_id");
			float b2 = Float.parseFloat(b12);
			int doc_id=(int)b2;
		    obj.setDoc_id(doc_id);
            
            pstmt.setLong(1,obj.getDoc_id());
            
            pstmt.executeUpdate();    
            
            con.commit();
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Completed");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

}