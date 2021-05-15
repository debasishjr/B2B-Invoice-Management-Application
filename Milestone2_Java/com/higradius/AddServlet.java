package com.higradius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 final String DB_URL = "jdbc:mysql://localhost:3307/h2h_internship"; 
		 final String USER = "root";
		 final String PASS = "root";
	     Connection connection = null;
	     PreparedStatement stmt=null;
	     
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 connection = DriverManager.getConnection(DB_URL, USER, PASS);
	    	 connection.setAutoCommit(false);
		     String sql = "INSERT INTO invoice_details (name_customer, due_in_date, cust_number ,notes , invoice_id, total_open_amount) VALUES (?, ?, ?, ?, ?, ?)";
		     stmt=connection.prepareStatement(sql); 
		     Response data= new Response();
		     
		     data.setCust_number(request.getParameter("cust_number"));
		     data.setName_customer(request.getParameter("name_customer"));
		     String b12=request.getParameter("doc_id");
			 float b2 = Float.parseFloat(b12);
			 int doc_id=(int)b2;
		     data.setDoc_id(doc_id);
		     //data.setDocId(request.getParameter("doc_id"));
		     
		     Date date3=null;
			 java.sql.Date due_in_date=null;
			 SimpleDateFormat Format3 = new SimpleDateFormat ("yyyyMMdd");
			 date3=Format3.parse(request.getParameter("due_in_date"));
			 due_in_date=new java.sql.Date(date3.getTime());
		     data.setDue_in_date(due_in_date);
		     
		     double total_open_amount=Double.parseDouble(request.getParameter("total_open_amount"));
		     data.setTotal_open_amount(total_open_amount);
		     
		     String b14=request.getParameter("invoice_id");
			 float b4=Float.parseFloat(b14);
			 int invoice_id=(int)b4;
		     data.setInvoice_id(invoice_id);
		     //data.setDueInDate(request.getParameter("due_in_date"));
		     
		     data.setNotes(request.getParameter("notes"));
		     
	         stmt.setString(1,data.getName_customer());
	         stmt.setDate(2,(java.sql.Date)data.getDue_in_date());
	         stmt.setString(3,data.getCust_number());
	         stmt.setString(4,data.getNotes());
	         stmt.setLong(5,data.getInvoice_id());
	         stmt.setDouble(6,data.getTotal_open_amount());
	         
	         stmt.executeUpdate();  
	         connection.commit();
			 connection.close();
		     stmt.close();
			 System.out.println("Completed!!!!!");
	     }     //(name_customer,cust_number,doc_id,invoice_id,total_open_amount,due_in_date,notes)
	     catch (SQLException e) {
	            e.printStackTrace();
			}
		catch(Exception e){
				e.printStackTrace();
			}
	     
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}