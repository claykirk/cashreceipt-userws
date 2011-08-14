
package com.innoprise.cashreceipt.userws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.innoprise.cashreceipt.userws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUsersResponse_QNAME = new QName("http://ejb.userws.cashreceipt.innoprise.com/", "getUsersResponse");
    private final static QName _GetUserRoleGroupsResponse_QNAME = new QName("http://ejb.userws.cashreceipt.innoprise.com/", "getUserRoleGroupsResponse");
    private final static QName _GetUsers_QNAME = new QName("http://ejb.userws.cashreceipt.innoprise.com/", "getUsers");
    private final static QName _GetUserRoleGroups_QNAME = new QName("http://ejb.userws.cashreceipt.innoprise.com/", "getUserRoleGroups");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.innoprise.cashreceipt.userws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUsers }
     * 
     */
    public GetUsers createGetUsers() {
        return new GetUsers();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link GetUserRoleGroups }
     * 
     */
    public GetUserRoleGroups createGetUserRoleGroups() {
        return new GetUserRoleGroups();
    }

    /**
     * Create an instance of {@link GetUserRoleGroupsResponse }
     * 
     */
    public GetUserRoleGroupsResponse createGetUserRoleGroupsResponse() {
        return new GetUserRoleGroupsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.userws.cashreceipt.innoprise.com/", name = "getUsersResponse")
    public JAXBElement<GetUsersResponse> createGetUsersResponse(GetUsersResponse value) {
        return new JAXBElement<GetUsersResponse>(_GetUsersResponse_QNAME, GetUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRoleGroupsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.userws.cashreceipt.innoprise.com/", name = "getUserRoleGroupsResponse")
    public JAXBElement<GetUserRoleGroupsResponse> createGetUserRoleGroupsResponse(GetUserRoleGroupsResponse value) {
        return new JAXBElement<GetUserRoleGroupsResponse>(_GetUserRoleGroupsResponse_QNAME, GetUserRoleGroupsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.userws.cashreceipt.innoprise.com/", name = "getUsers")
    public JAXBElement<GetUsers> createGetUsers(GetUsers value) {
        return new JAXBElement<GetUsers>(_GetUsers_QNAME, GetUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserRoleGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb.userws.cashreceipt.innoprise.com/", name = "getUserRoleGroups")
    public JAXBElement<GetUserRoleGroups> createGetUserRoleGroups(GetUserRoleGroups value) {
        return new JAXBElement<GetUserRoleGroups>(_GetUserRoleGroups_QNAME, GetUserRoleGroups.class, null, value);
    }

}
