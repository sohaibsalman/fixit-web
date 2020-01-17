package com.fixit.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fixit.fixer.*;
import java.util.Vector;

public class FixerDbUtil 
{	
	private Connection con = null;
	private PreparedStatement pstat = null;
	private ResultSet rs = null;	
    
    private void connectDB()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fixit","root","");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void disconnectDB()
    {
        try 
        {
            pstat.close();
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

	public boolean addFixer(Vector<String> f) throws ParseException, SQLException 
	{
        //Connect to database
        connectDB();        
        
        //CHECK IF FIXER ALREADY EXISTS
        String sql = "SELECT * FROM service_provider WHERE provider_id = ?";
        pstat = con.prepareStatement(sql);
        pstat.setString(1, f.get(0));
        rs = pstat.executeQuery();
        if(rs.next())
            return false;
       
        //FIXER DOES NOT EXISTS
		sql = "INSERT INTO service_provider "
                + "("
                + "provider_id, first_name, last_name, "
                + "email, password, phone_no, gender "
                + ") "
                + "VALUES "
                + "("
                + "?, ?, ?, ?, ?, ?, ? "
                + ")";
		
		pstat = con.prepareStatement(sql);
		
		pstat.setString(1, f.get(0));
		pstat.setString(2, f.get(1));
		pstat.setString(3, f.get(2));
		pstat.setString(4, f.get(3));
		pstat.setString(5, f.get(4));
		pstat.setString(6, f.get(5));
		pstat.setString(7, f.get(6));

        
		pstat.executeUpdate();
        
        
        sql = "INSERT INTO provider_address "
                + "("
                + "provider_id, city, area, shop_no "
                + ") "
                + "VALUES "
                + "("
                + "?, ?, ?, ? "
                + ")";
        pstat = con.prepareStatement(sql);
        pstat.setString(1, f.get(0));
        pstat.setString(2, f.get(7));
        pstat.setString(3, f.get(8));
        pstat.setString(4, f.get(9));
        
        pstat.executeUpdate();
        
        sql = "INSERT INTO service_category "
                + "( "
                + "provider_id, service_type, service_name "
                + ") "
                + "VALUES"
                + "( "
                + "?, ?, ? "
                + ")";
        pstat = con.prepareCall(sql);
        pstat.setString(1, f.get(0));
        pstat.setString(2, f.get(10));
        pstat.setString(3, f.get(11));
        
        pstat.executeUpdate();	
		
        return true;
	}

    Fixer loginFixer(String username, String password) throws SQLException
    {
       connectDB();
       
       String sql;
       
       //CHECK EXISTANCE OF FIXER
       sql = "SELECT * FROM service_provider WHERE provider_id = ?";
       pstat = con.prepareStatement(sql);
       pstat.setString(1, username);
       
       rs = pstat.executeQuery();
       if(!rs.next())
           return null;
       
       //USER EXISTS... MATCH PASSWORD
       String dbPassword = rs.getString("password");
       if(!password.equals(dbPassword))
           return null;
       
       String email = rs.getString("email");
       String firstName = rs.getString("first_name");
       String lastName = rs.getString("last_name");
       String phoneNumber = rs.getString("phone_no");
       String gender = rs.getString("gender");
       
       sql = "SELECT * FROM provider_address WHERE provider_id = ?";
       pstat = con.prepareStatement(sql);
       pstat.setString(1, username);
       rs = pstat.executeQuery();
       rs.next();
       String city = rs.getString("city");
       String workArea = rs.getString("area");
       String workAddress = rs.getString("shop_no");
       
       sql = "SELECT * FROM service_category WHERE provider_id = ?";
       pstat = con.prepareStatement(sql);
       pstat.setString(1, username);
       rs = pstat.executeQuery();
       rs.next();
       String serviceCategory = rs.getString("service_type");
       String serviceName = rs.getString("service_name");
       
       return new Fixer(new CredentialInfo(username, email, password), new PersonalInfo(firstName, lastName, gender, phoneNumber), new WorkInfo(serviceCategory, serviceName, city, workArea, workAddress));
    }
	
	
	
}
