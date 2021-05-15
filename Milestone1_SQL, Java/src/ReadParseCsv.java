
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.text.ParseException;
import java.sql.*;





public class ReadParseCsv {
	// JDBC driver name and database URL
	static final String DB_URL = "jdbc:mysql://localhost:3307/h2h_internship";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int batchSize = 1000;
		
        Connection connection = null;
        //Statement stmt = null;
		File csvFile=new File("1829217(1).csv");//C:\\Summer_Internship_Backend\\Summer_Internship_Backend\\eclipse-workspace\\MyProject\\input_csv\\
		ArrayList <invoice_details> invoice_arraylist=new ArrayList<>();
		
		BufferedReader br=new BufferedReader(new FileReader(csvFile));
		//BufferedReader br1=new BufferedReader(new FileReader(csvFile));
		String line="";
		String[] line1=new String[50000];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
	        connection.setAutoCommit(false);
	        String sql = "INSERT INTO invoice_details (business_code, cust_number, name_customer, clear_date, business_year, doc_id, posting_date, document_create_date, due_in_date, invoice_currency, document_type, posting_id, area_business, total_open_amount, baseline_create_date, cust_payment_terms, invoice_id, isOpen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
			br.readLine();
			//br1.readLine();
			int f=-1;
			while((line=br.readLine())!=null) {
				++f;
				line1[f]=line;
				
				String[] count=line.split(",");
				//invoice_details data = new invoice_details();
				
				String business_code=count[0];
				String cust_number=count[1];
				String name_customer=count[2];
				
				
				//String clear_date=count[3];
				java.sql.Date clear_date=null;
				Date util_clear_date=null;
				//String clear_date=null;
				if(isNullOrEmpty(count[3]))
				{
					clear_date=null;
				}
				else
				{
				SimpleDateFormat Format = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
				util_clear_date=Format.parse(count[3]);
				clear_date=new java.sql.Date(util_clear_date.getTime());
				}
				
				
				//java.util.Date date= new Date(clear_date);
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				//String clear_date1=formatter.format(date);
				//LocalDate clear_date1=LocalDateTime.parse(clear_date).toLocalDate();
				
				String b11=count[4];
				float b1 = Float.parseFloat(b11);
				int business_year=(int)b1;
				
				String b12=count[5];
				float b2 = Float.parseFloat(b12);
				int doc_id=(int)b2;
				
				//String posting_date=count[6];
				Date date1=null;
				java.sql.Date posting_date=null;
				SimpleDateFormat Format1 = new SimpleDateFormat ("yyyy-MM-dd");
				date1=Format1.parse(count[6]);
				posting_date=new java.sql.Date(date1.getTime());
				/*
				SimpleDateFormat inputFormat1 = new SimpleDateFormat ("yyyy-MM-dd");
				SimpleDateFormat outputFormat1 = new SimpleDateFormat ("yyyy-MM-dd");
				date1=inputFormat1.parse(count[6]);
				posting_date=outputFormat1.format(date1);*/
				
				//LocalDate posting_date1=LocalDateTime.parse(posting_date).toLocalDate();
				
				//String document_create_date=count[8];
				Date date2=null;
				java.sql.Date document_create_date=null;
				SimpleDateFormat Format2 = new SimpleDateFormat ("yyyyMMdd");
				date2=Format2.parse(count[8]);
				document_create_date=new java.sql.Date(date2.getTime());
				/*Date date2=null;
				String document_create_date=null;
				SimpleDateFormat inputFormat2 = new SimpleDateFormat ("yyyyMMdd");
				SimpleDateFormat outputFormat2 = new SimpleDateFormat ("yyyy-MM-dd");
				date2=inputFormat2.parse(count[8]);
				document_create_date=outputFormat2.format(date2);*/
				//LocalDate document_create_date1=LocalDateTime.parse(document_create_date).toLocalDate();
				
				//String due_in_date=count[9];
				Date date3=null;
				java.sql.Date due_in_date=null;
				SimpleDateFormat Format3 = new SimpleDateFormat ("yyyyMMdd");
				date3=Format3.parse(count[9]);
				due_in_date=new java.sql.Date(date3.getTime());
				/*Date date3=null;
				String due_in_date=null;
				SimpleDateFormat inputFormat3 = new SimpleDateFormat ("yyyyMMdd");
				SimpleDateFormat outputFormat3 = new SimpleDateFormat ("yyyy-MM-dd");
				date3=inputFormat3.parse(count[9]);
				due_in_date=outputFormat3.format(date3);*/
				//LocalDate due_in_date1=LocalDateTime.parse(due_in_date).toLocalDate();
				
			    String invoice_currency=count[10];
			    
				String document_type=count[11];
				
				//int posting_id=Integer.parseInt(count[12]);
				String b13=count[12];
				float b3 = Float.parseFloat(b13);
				int posting_id=(int)b3;
				
				
				String area_business=count[13];
				
				double total_open_amount=Double.parseDouble(count[14]);
				
				//String baseline_create_date=count[15];
				Date date4=null;
				java.sql.Date baseline_create_date=null;
				SimpleDateFormat Format4 = new SimpleDateFormat ("yyyyMMdd");
				date4=Format4.parse(count[15]);
				baseline_create_date=new java.sql.Date(date4.getTime());
				/*Date date4=null;
				String baseline_create_date=null;
				SimpleDateFormat inputFormat4 = new SimpleDateFormat ("yyyyMMdd");
				SimpleDateFormat outputFormat4 = new SimpleDateFormat ("yyyy-MM-dd");
				date4=inputFormat4.parse(count[15]);
				baseline_create_date=outputFormat4.format(date4);*/
				//LocalDate baseline_create_date1=LocalDateTime.parse(baseline_create_date).toLocalDate();
				
				
				
				String cust_payment_terms=count[16];
				
				
				
				//int invoice_id=Integer.parseInt(count[17]);
				String b14=count[17];
				float b4;
				if (isNullOrEmpty(b14)) {
					b4=0.0f;
					
				}
				else
				{
					b4=Float.parseFloat(b14);
				}
				int invoice_id=(int)b4;
				
				
				int isOpen=Integer.parseInt(count[18]);
				
				
				
				int c2=0;
				for(int i=f;i>=0;i--)		
				{
					String[] count1=line1[i].split(",");
					String b10=count1[5];
					float b0 = Float.parseFloat(b10);
					int doc_id1=(int)b0;
					if(doc_id==doc_id1)
					{
						c2++;
					}
				}
				if(c2!=1)
				{
					continue;
				}
				else
				{
				invoice_details data = new invoice_details(business_code,cust_number,name_customer,clear_date,business_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id,isOpen);
				invoice_arraylist.add(data);
				}
			 //System.out.println(count[0]+" "+count[1]+" "+count[2]+count[3]+" "+count[4]+" "+count[5]+" "+count[6]+" "+count[7]+" "+count[8]+" "+count[9]+" "+count[10]+" "+count[11]+" "+count[12]+" "+count[13]+" "+count[14]+" "+count[15]+" "+count[16]+" "+count[17]+" "+count[18]);
			}//while end
			for(invoice_details data : invoice_arraylist) {
				//int clear_date1;
				//System.out.println(business_code+" "+cust_number+" "+name_customer+" "+clear_date1+" "+business_year+" "+doc_id+" "+posting_date1+" "+document_create_date+" "+due_in_date+" "+invoice_currency+" "+document_type+" "+posting_id+" "+area_business+" "+total_open_amount+" "+baseline_create_date+" "+cust_payment_terms+" "+invoice_id+" "+isOpen);
				System.out.println(data);
	       }//for 1 end
			
			

	        System.out.println("Contents being printed in table");
	        int c=0;
	        PreparedStatement statement = connection.prepareStatement(sql);
	        for(invoice_details data : invoice_arraylist) {
	        	statement.setString(1, data.getBusiness_code());
	            statement.setString(2, data.getCust_number());
	            statement.setString(3, data.getName_customer());
	            statement.setDate(4, (java.sql.Date) data.getClear_date());
	            statement.setInt(5, data.getBusiness_year());
	            statement.setInt(6, data.getDoc_id());
	            statement.setDate(7, (java.sql.Date)data.getPosting_date());
	            statement.setDate(8, (java.sql.Date)data.getDocument_create_date());
	            statement.setDate(9, (java.sql.Date)data.getDue_in_date());
	            statement.setString(10, data.getInvoice_currency());
	            statement.setString(11, data.getDocument_type());
	            statement.setInt(12, data.getPosting_id());
	            statement.setString(13, data.getArea_business());
	            statement.setDouble(14, data.getTotal_open_amount());
	            statement.setDate(15, (java.sql.Date)data.getBaseline_create_date());
	            statement.setString(16, data.getCust_payment_terms());
	            statement.setInt(17, data.getInvoice_id());
	            statement.setInt(18, data.getIsOpen());//"invoice_details ["+data.getBusiness_code()+" "+data.getCust_number()+" "+(java.sql.Date) data.getClear_date()+"]"
	            System.out.println("invoice_details ["+data.getBusiness_code()+" "+data.getCust_number()+" "+(java.sql.Date) data.getClear_date()+"]");
	            statement.addBatch();
	            c++;
	             
	            if (c % batchSize == 0) {
	                statement.executeBatch();
	            }//if close	
	        }//for 2 close
	        statement.executeBatch();    
	        
	        
	        
	        
	        
	        
	        /* String sql1 = "SELECT * FROM invoice_details";
	    	  ResultSet rs = stmt.executeQuery(sql1);
	    	  ArrayList <invoice_details> invoice_arraylist1 =new ArrayList<>();
	    	  while(rs.next()) 
	    	  {
	        	invoice_details data= new invoice_details(business_code,cust_number,name_customer,clear_date,business_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id,isOpen);
	        	data.setBusiness_code(rs.getString(1));
	        	data.setLast_Name(rs.getString(2));
	        	data.setSerial_(rs.getInt(3));
	        	data.setAlias_(rs.getString(4));
	            data.setQuotes(rs.getString(5));
	            invoice_arraylist1.add(data);
	          }
	    	  for(invoice_details data:invoice_arraylist1)
	    	  {
	    		  System.out.print("First_Name: "+data.getBusiness_code()+",");
	    		 System.out.print(" Last_Name: "+avenge.getLast_Name()+",");
	    		  System.out.print(" Serial: "+avenge.getSerial_()+",");
	    		  System.out.print(" Alias: "+avenge.getAlias_()+",");
	    		  System.out.print(" Quotes: "+avenge.getQuotes());
	    		  System.out.println("");
	    	  }*/
	    	 // rs.close();
			br.close();
			connection.commit();
			connection.close();
			statement.close();
			System.out.println("Completed!!!!!");
		}//try close
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			//float c=0.0f;
			//return c;
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		catch (SQLException ex) {
            ex.printStackTrace();
		}
	}//main close

	private static boolean isNullOrEmpty(String b14) {
		// TODO Auto-generated method stub
		if(b14 != null && !b14.isEmpty())
			return false;
		return true;
		
	}
}//class close

