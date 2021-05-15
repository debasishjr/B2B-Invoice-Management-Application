package com.higradius;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/dummyServlet")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DummyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String DB_URL = "jdbc:mysql://localhost:3307/h2h_internship"; 
		 final String USER = "root";
		 final String PASS = "root";
	     Connection connection = null;
	     Statement stmt = null;
	     
	     ArrayList <Response> invoice_details_arraylist=new ArrayList<>();
	     
	     try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = connection.createStatement();
		        connection.setAutoCommit(false);
		        String sql = "SELECT * FROM invoice_details";
		        ResultSet rs = stmt.executeQuery(sql);
		        
		        while(rs.next()) 
		    	  {
		        	Response robj= new Response();
		        	
		        	robj.setBusiness_code(rs.getString(1));
		        	robj.setCust_number(rs.getString(2));
		        	robj.setName_customer(rs.getString(3));
		        	robj.setClear_date(rs.getDate(4));		        	
		        	robj.setBusiness_year(rs.getInt(5));		            
		        	robj.setDoc_id(rs.getInt(6));		            
		        	robj.setPosting_date(rs.getDate(7));
		        	robj.setDocument_create_date(rs.getDate(8));		            
		        	robj.setDue_in_date(rs.getDate(9));		            
		        	robj.setInvoice_currency(rs.getString(10));		            
		        	robj.setDocument_type(rs.getString(11));		            
		        	robj.setPosting_id(rs.getInt(12));		            
		        	robj.setArea_business(rs.getString(13));		            
		        	robj.setTotal_open_amount(rs.getDouble(14));		            
		        	robj.setBaseline_create_date(rs.getDate(15));		            
		        	robj.setCust_payment_terms(rs.getString(16));		            
		        	robj.setInvoice_id(rs.getInt(17));		            
		        	robj.setIsOpen(rs.getInt(18));
		        	robj.setNotes("");
		            
		        	invoice_details_arraylist.add(robj);
		          }
		        rs.close();
				connection.commit();
				connection.close();				
		 }
		 catch (Exception e) 
	     {
			System.out.println(e);
		 }
	     Gson gson = new Gson();
		 String data1 = gson.toJson(invoice_details_arraylist);
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(data1);
		 out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
































//package com.higradius;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//
///**
// * Servlet implementation class dummyServlet
// */
//@WebServlet("/dummyServlet")
//public class DummyServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DummyServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String name = request.getParameter("name");
//		Response resp = new Response();
//		resp.setBusiness_code(name);
//		Gson gson = new Gson();
//		 String data = gson.toJson(resp);
//		 PrintWriter out = response.getWriter();
//		 response.setContentType("application/json");
//		 response.setCharacterEncoding("UTF-8");
//		 out.print(data);
//		 out.flush();
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
