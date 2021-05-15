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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public EditServlet() 
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
			String sql = "UPDATE invoice_details SET total_open_amount=? , notes=? where doc_id=?";
            pstmt=con.prepareStatement(sql);
            
            Response obj=new Response();
            
            double total_open_amount=Double.parseDouble(request.getParameter("total_open_amount"));
		    obj.setTotal_open_amount(total_open_amount);
            
            obj.setNotes(request.getParameter("notes"));
            
            String b12=request.getParameter("doc_id");
			float b2 = Float.parseFloat(b12);
			int doc_id=(int)b2;
		    obj.setDoc_id(doc_id);
            
            pstmt.setDouble(1,obj.getTotal_open_amount());
            pstmt.setString(2,obj.getNotes());
            pstmt.setLong(3,obj.getDoc_id());
            
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