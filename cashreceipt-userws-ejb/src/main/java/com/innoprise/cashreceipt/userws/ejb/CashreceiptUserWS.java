/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.innoprise.cashreceipt.userws.ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.NamingException;

/**
 *
 * @author ckirk
 */
@WebService()
@Stateless()
public class CashreceiptUserWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsers")
    public List getUsers() {
        List<String> users = null;
        try{
    		users = UserWSHelper.getUsers();
    	}
    	catch(SQLException sqle){
    		sqle.printStackTrace();
    	}
    	catch(NamingException ne){
    		ne.printStackTrace();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        return users;
    }

    /**
     * Web service operationroles
     */
    @WebMethod(operationName = "getUserRoleGroups")
    public List getUserRoleGroups(@WebParam(name = "userName")
    String userName) {
    	List<String> roles = null;
    	try{
    		roles = UserWSHelper.getUserRoles(userName);
    	}
    	catch(SQLException sqle){
    		sqle.printStackTrace();
    	}
    	catch(NamingException ne){
    		ne.printStackTrace();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        //TODO write your implementation code here:
        return roles;
    }

}
