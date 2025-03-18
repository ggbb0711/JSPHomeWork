/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.constant;

/**
 *
 * @author NGHIA
 */
public class Routes {
    public static final String PARTS = "/sales-person/parts";
    public static final String CREATE_PARTS = "/sales-person/create";
    public static final String DELETE_PARTS = "/sales-person/delete";
    public static final String UPDATE_PARTS = "/sales-person/part-update";
    public static final String STATS= "/sales-person/stats";
    public static final String STATS_PARTS_USED = "/sales-person/stats-parts-used";
    public static final String STATS_TOP_MECHANIC = "/sales-person/top-mechanic";
    public static final String INVOICE_CUSTOMER = "/customer/invoice";
    public static final String AVAILABLE_CAR_CUSTOMER = "/customer";
    public static final String ADD_TO_CART = "/customer/add-to-cart";
    public static final String CUSTOMER_CART_SERVLET = "/customer/cart";
    public static final String WISHLIST_SALE_PERSON = "/sales-person/wishlist";
    public static final String WISHLIST_DETAIL_SALE_PERSON = "/sales-person/wishlistDetail";
    public static final String LOGIN_SALE_PERSON = "/login/sales-person";
    public static final String LOGIN_CUSTOMER = "/login/customer";
    public static final String LOGOUT_SALE_PERSON = "/logout/sales-person";
    
    public static final String CUSTOMER = "/sales-person/customers";
    public static final String READ_CUSTOMER = "/sales-person/readCustomers";
    public static final String UPDATE_CUSTOMER = "/sales-person/updateCustomers";
    public static final String DELETE_CUSTOMER = "/sales-person/deleteCustomers";
    
    public static final String CAR = "/sales-person/cars";
    public static final String READ_CAR = "/sales-person/readCars";
    public static final String UPDATE_CAR = "/sales-person/updateCars";
    public static final String DELETE_CAR = "/sales-person/deleteCars";
    
    public static final String SERVICETICKET = "/sales-person/serviceTicket";
    public static final String READ_SERVICETICKET = "/sales-person/readServiceTicket";
    
    
    public static final String VIEW_SERVICE_TICKET_CUSTOMER = "/customer/viewTickets";
    public static final String UPDATE_PROFILE = "/customer/updateProfile";
    public static final String VIEW_PROFILE = "/customer/viewProfile";
    public static final String ADD_SERVICE = "/mechanic/addService";
    public static final String DELETE_SERVICE = "/mechanic/deleteService";
    public static final String EDIT_SERVICE = "/mechanic/editService";
    public static final String EDIT_TICKETS = "/mechanic/editTicket";
    public static final String FILTER_TICKETS = "/mechanic/filterTickets";
    public static final String MANAGE_SERVICE_TICKETS = "/mechanic/manage-service-ticket";
    public static final String MANAGE_SERVICE = "/mechanic/manage-services";
}
