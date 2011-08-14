package com.innoprise.cashreceipt.userws.ejb;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class UserWSHelper {

	private static Connection getConnection() throws NamingException, SQLException{
	     Connection conn = null;
	     InitialContext ic = new InitialContext();
	     DataSource ds = (DataSource) ic.lookup("jdbc/login");
	     conn = ds.getConnection();
	     System.out.println("URL:" + conn.getMetaData().getURL());
	     return conn;
	}

	public static List<String> getUserRoles(String userName) throws SQLException, NamingException, Exception{
		 
		 Connection conn = getConnection();
		 Statement seqStmt = conn.createStatement();  
		 
		 Map<String, String> map = getUserRolesSQL();
	     String column = (String)map.keySet().iterator().next();
	     String sql = (String)map.get(column);
	     
	     sql = sql.replace("$arg", "\'" + userName + "\'");
		 
		 ResultSet rs = seqStmt.executeQuery(sql);
	    
	     List<String> roles = new ArrayList<String>();
	     while (rs.next()) {
    		 roles.add(rs.getString(column));
	     }
	     seqStmt.close();
	    
	     conn.close();
	     
	     return roles;
	}
	public static List<String> getUsers() throws NamingException, SQLException, Exception {
		Connection conn = getConnection();
		Statement seqStmt = conn.createStatement();
		
		Map<String, String> map = getUsersSQL();
		
		String column = (String)map.keySet().iterator().next();
		String sql = (String)map.get(column);
		
	    ResultSet rs = seqStmt.executeQuery(sql);
		List<String> users = new ArrayList<String>();
		while (rs.next()) {
			users.add(rs.getString(column));
		}
		conn.close();
		
		return users;
	}
	private static Map<String, String> getUsersSQL() throws Exception{
		Document settings = null;
		try{
			settings = getSettingsDocument();
		}
		catch(Exception e){
			throw e;
		}
		Element userSettings = settings.getRootElement().getChild("Users");
		
		if(userSettings != null) {
			Map<String, String> ret = new HashMap<String, String>();
			ret.put(userSettings.getChildText("column"), userSettings.getChildText("sql"));
			return ret;
		}
		else
			throw new Exception("sql for roles not found");
	}
	private static Map<String, String>  getUserRolesSQL() throws Exception{
		Document settings = null;
		try{
			settings = getSettingsDocument();
		}
		catch(Exception e){
			throw e;
		}
		Element roleSettings = settings.getRootElement().getChild("Roles");
		
		if(roleSettings != null) {
			Map<String, String> ret = new HashMap<String, String>();
			ret.put(roleSettings.getChildText("column"), roleSettings.getChildText("sql"));
			return ret;
		}
		else
			throw new Exception("sql for roles not found");
	}
	private static Document getSettingsDocument() throws Exception {
		Document document = null;
		InputStream in = null;
		
		try{
            in = UserWSHelper.class.getClassLoader().getResourceAsStream("cashreceiptUserWSSetting.xml");
        }
        catch(java.lang.Exception ioe){
            java.lang.Exception e = new java.lang.Exception();
            e.getMessage().concat("Error opening cashreceiptUserWSSetting.xml file");
            throw e;
        }
        try{
        	 SAXBuilder builder = new SAXBuilder();        // Build the document with SAX and Xerces, no validation
             document = builder.build( in );
        }
        catch(java.lang.Exception jdome){
            jdome.getMessage().concat("Error creating XML Document from xml");
            throw jdome;
        }
        return document;
	}
}
