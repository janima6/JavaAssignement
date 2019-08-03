package ca.sheridancollege.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import ca.sheridancollege.Bean.DogBean;
import ca.sheridancollege.session.Enums;


public class DAO {
	
	
	public static void addDog(DogBean b) 
	{
		int entry_number = 0;
		ArrayList<DogBean> list = new  ArrayList<DogBean>();
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
            
            String QueryCheck = " select * from dog_details";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(QueryCheck);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();	
            
            while(rs.next()) {
            	
        entry_number =  rs.getInt(1);
         
            }
           if(entry_number == b.getEntryNumber()) {
        	   
           String error = "Sorry, your random unique number is getting same, please try to resubmit details";
           DogBean bs = new DogBean();
           bs.setError(error);
           }
		
		
         else 
         {
        	 String Query = "insert into dog_details values (?,?,?,?,?,?,?)";
        	  PreparedStatement ps = conn.prepareStatement(Query);
              ps.setInt(1, b.getEntryNumber());
               ps.setString(2, b.getDogName());
               ps.setString(3, b.getOwnerName());
               ps.setString(4, b.getBreed());
               ps.setString(5, b.getGroup());
               ps.setString(6, b.getGender());
               ps.setString(7, b.getRanking());
                 ps.executeUpdate();
          
                System.out.println("Connection Success");
                conn.close();
              
         }
		}
  		catch (Exception e) {
  			System.out.println("Connection Failed");
              System.out.println(e);
  		}
		  }
	
	
	public static String randomDogs() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection conn = null;
	       
	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
	          
	           String Query = "insert into dog_details values (?,?,?,?,?,?,?)";
	           
	           for(int i = 0; i < 101; i++) {
	   			String dogname = Enums.name.getRandomName().toString();
	   			String owner = Enums.Owner.getRandomOwner().toString();
	   		    String breed = Enums.Breeds.getRandomBreed().toString();
	   		    String doggroup = Enums.group.getRandomGroup().toString();
	   		    String gender = Enums.gender.getRandomGender().toString();
	   		    String ranking = Enums.ranking.getRandomGender().toString();
	   		    
	   		    Random random = new Random();
	   		    int rand = 10000;
	   		    while (true){
	   		        rand = random.nextInt(1000000);
	   		        if(rand !=10000) break;
	   		    }
	   		    System.out.println("..."+rand+"...");
	   			
	   		    System.out.print(dogname + "," + owner+ "," +breed+ "," +doggroup+ "," +gender+ "," +ranking);

	   		 PreparedStatement ps = conn.prepareStatement(Query);
             ps.setInt(1, rand);
              ps.setString(2, dogname);
              ps.setString(3,owner);
              ps.setString(4, breed);
              ps.setString(5, doggroup);
              ps.setString(6, gender);
              ps.setString(7, ranking);
                ps.executeUpdate();
		           }
	           System.out.println("Connection Success");
               conn.close();
		}
		
		catch (Exception e) {
			System.out.println("Connection Failed");
	       System.out.println(e);
			
		}
		return null;
	}
		
	
	
	public static ArrayList<DogBean> showDogs() {
	ArrayList<DogBean>	doglist = new ArrayList<DogBean>();
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = null;
       
           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
          
           String Query = "select * from dog_details";
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(Query);
           ResultSetMetaData rsmd = rs.getMetaData();
           int columnCount = rsmd.getColumnCount();	  
           while(rs.next()) {
           	
         String eNum =   	rs.getString(1);
         int enumi = Integer.parseInt(eNum);
         String dName =   	rs.getString(2);
          String oName = 	rs.getString(3);
           String bre =	rs.getString(4);
           String dGroup = rs.getString(5);
           String gender = rs.getString(6);
           String ran = rs.getString(7);
           
           
           DogBean ds = new DogBean(enumi,dName,oName,bre,dGroup,gender,ran);
           doglist.add(ds);
           }
           conn.close();     
	}
	catch (Exception e) {
		System.out.println("Connection Failed");
       System.out.println(e);
		
	}
	return doglist;
	
}
	
	public static ArrayList<DogBean> searchByNumber(DogBean b) {
		ArrayList<DogBean>	doglist = new ArrayList<DogBean>();
		String Query = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection conn = null;
	       
	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
	            	 Query = "select * from dog_details where entry_number="+b.getEntryNumber();
	    
	           Statement st = conn.createStatement();
	           ResultSet rs = st.executeQuery(Query);
	           ResultSetMetaData rsmd = rs.getMetaData();
	           int columnCount = rsmd.getColumnCount();	  
	           while(rs.next()) {
	           	
	         String eNum =   	rs.getString(1);
	         int enumi = Integer.parseInt(eNum);
	         String dName =   	rs.getString(2);
	          String oName = 	rs.getString(3);
	           String bre =	rs.getString(4);
	           String dGroup = rs.getString(5);
	           String gender = rs.getString(6);
	           String ran = rs.getString(7);
	           
	           
	           DogBean ds = new DogBean(enumi,dName,oName,bre,dGroup,gender,ran);
	           doglist.add(ds);
	           }
	           conn.close();     
		}
		catch (Exception e) {
			System.out.println("Connection Failed");
	       System.out.println(e);
			
		}
		return doglist;
		
	}
	
	public static ArrayList<DogBean> searchBy(DogBean b) {
		ArrayList<DogBean>	doglist = new ArrayList<DogBean>();
		String Query = null;
			try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection conn = null;

	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
	           
                if(!b.getGroup().isEmpty()) {
	        	  
	        	  Query = "select * from dog_details where dog_group='"+b.getGroup()+"'";
	          }
	    
	           Statement st = conn.createStatement();
	           ResultSet rs = st.executeQuery(Query);
	           ResultSetMetaData rsmd = rs.getMetaData();
	           int columnCount = rsmd.getColumnCount();	  
	           while(rs.next()) {
	           	
	         String eNum =   	rs.getString(1);
	         int enumi = Integer.parseInt(eNum);
	         String dName =   	rs.getString(2);
	          String oName = 	rs.getString(3);
	           String bre =	rs.getString(4);
	           String dGroup = rs.getString(5);
	           String gender = rs.getString(6);
	           String ran = rs.getString(7);
	           
	           
	           
	           DogBean ds = new DogBean(enumi,dName,oName,bre,dGroup,gender,ran);
	          
	           doglist.add(ds);
	           }
	           conn.close();     
		}
		catch (Exception e) {
			System.out.println("Connection Failed");
	       System.out.println(e);
			
		}
		return doglist;
		
	}
	
	public static ArrayList<DogBean> searchByName(String dname) {
		ArrayList<DogBean>	dlist = new ArrayList<DogBean>();
		 Connection conn = null;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          
	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
          	String Query = "select * from dog_details where dog_name='"+dname+"'";
	           
          	Statement st = conn.createStatement();
	           ResultSet rs = st.executeQuery(Query);
	           ResultSetMetaData rsmd = rs.getMetaData();
	           int columnCount = rsmd.getColumnCount();	  
	           while(rs.next()) {
	           	
	         String eNum =   	rs.getString(1);
	         int enumi = Integer.parseInt(eNum);
	         String dName =   	rs.getString(2);
	          String oName = 	rs.getString(3);
	           String bre =	rs.getString(4);
	           String dGroup = rs.getString(5);
	           String gender = rs.getString(6);
	           String ran = rs.getString(7);
	           
	           DogBean ds = new DogBean(enumi,dName,oName,bre,dGroup,gender,ran);
	           dlist.add(ds);
	           }
	           conn.close();   
		}
        
	catch (Exception e) {
		System.out.println("Connection Failed");
    System.out.println(e);
		
	}
          	
		return dlist;
	}
	
	
	
	public static ArrayList<DogBean> searchByOwner(String dname) {
		ArrayList<DogBean>	dlist = new ArrayList<DogBean>();
		 Connection conn = null;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          
	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
          	String Query = "select * from dog_details where owner_name='"+dname+"'";
	           
          	Statement st = conn.createStatement();
	           ResultSet rs = st.executeQuery(Query);
	           ResultSetMetaData rsmd = rs.getMetaData();
	           int columnCount = rsmd.getColumnCount();	  
	           while(rs.next()) {
	           	
	         String eNum =   	rs.getString(1);
	         int enumi = Integer.parseInt(eNum);
	         String dName =   	rs.getString(2);
	          String oName = 	rs.getString(3);
	           String bre =	rs.getString(4);
	           String dGroup = rs.getString(5);
	           String gender = rs.getString(6);
	           String ran = rs.getString(7);
	           
	           DogBean ds = new DogBean(enumi,dName,oName,bre,dGroup,gender,ran);
	           dlist.add(ds);
	           }
	           conn.close();   
		}
        
	catch (Exception e) {
		System.out.println("Connection Failed");
    System.out.println(e);
		
	} 	
		return dlist;
		
	}
	
	
	public static ArrayList<DogBean> searchByBread(String dname) {
		ArrayList<DogBean>	dlist = new ArrayList<DogBean>();
		 Connection conn = null;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          
	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
          	String Query = "select * from dog_details where breed='"+dname+"'";
	           
          	Statement st = conn.createStatement();
	           ResultSet rs = st.executeQuery(Query);
	           ResultSetMetaData rsmd = rs.getMetaData();
	           int columnCount = rsmd.getColumnCount();	  
	           while(rs.next()) {
	           	
	         String eNum =   	rs.getString(1);
	         int enumi = Integer.parseInt(eNum);
	         String dName =   	rs.getString(2);
	          String oName = 	rs.getString(3);
	           String bre =	rs.getString(4);
	           String dGroup = rs.getString(5);
	           String gender = rs.getString(6);
	           String ran = rs.getString(7);
	           
	           DogBean ds = new DogBean(enumi,dName,oName,bre,dGroup,gender,ran);
	           dlist.add(ds);
	           }
	           conn.close();   
		}
        
	catch (Exception e) {
		System.out.println("Connection Failed");
    System.out.println(e);	
	}   	
		return dlist;
		
	}
	
	
	public static ArrayList<DogBean> showList(String dname) {
		ArrayList<DogBean>	dlist = new ArrayList<DogBean>();
		 Connection conn = null;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
	          
	           conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "malav");
	           
	           
          	//String Query = "select * from dog_details where dog_name='"+dname+"'";	
   String Query = "SELECT COUNT(BREED) AS count\r\n" + 
   		",BREED\r\n" + 
   		",count(case when gender = 'Male' then gender end) as male \r\n" + 
   		",count(case when Gender = 'Female' then gender end) as female \r\n" + 
   		",count(case when gender = 'male' and ranking= 'SPECIALTY' then gender end) as SM \r\n" + 
   		",count(case when gender = 'female' and ranking= 'SPECIALTY' then gender end) as SF \r\n" + 
   		"FROM dog_details WHERE dog_group='"+dname+"' GROUP BY breed";
   
          	Statement st = conn.createStatement();
	           ResultSet rs = st.executeQuery(Query);
	           ResultSetMetaData rsmd = rs.getMetaData();
	           int columnCount = rsmd.getColumnCount();	  
	           while(rs.next()) {
	           	
	         String count =   	rs.getString("count");
	         String breed =   	rs.getString("BREED");
	         String male = rs.getString("male");
	         String female = rs.getString("female");
	         String sm = rs.getString("SM");
	         String fm = rs.getString("SF");
	         
	           DogBean ds = new DogBean(count,breed,male,female,sm,fm);
	           dlist.add(ds);
	           }
	           conn.close();   
		}
        
	catch (Exception e) {
		System.out.println("Connection Failed");
    System.out.println(e);
		
	}
          	
		return dlist;
	}
	
	
	
	}
	
		
	

	

