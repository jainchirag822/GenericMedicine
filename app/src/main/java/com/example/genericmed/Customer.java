package com.example.genericmed;

public class Customer {

    private String customerId;
    private String CustomerName;
    private String CustomerAdd1;
    private String CustomerAdd2;
    private String CustomerCity;
    private String CustomerState;
    private String CustomerPin;
    private String CustomerEmail;
    private String CustomerNo;

    public Customer(){

    }

    public Customer(String customerId, String customerName, String customerAdd1, String customerAdd2, String customerCity, String customerState, String customerPin, String customerEmail, String customerNo) {
        this.customerId = customerId;
        CustomerName = customerName;
        CustomerAdd1 = customerAdd1;
        CustomerAdd2 = customerAdd2;
        CustomerCity = customerCity;
        CustomerState = customerState;
        CustomerPin = customerPin;
        CustomerEmail = customerEmail;
        CustomerNo = customerNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerAdd1() {
        return CustomerAdd1;
    }

    public String getCustomerAdd2() {
        return CustomerAdd2;
    }

    public String getCustomerCity() {
        return CustomerCity;
    }

    public String getCustomerState() {
        return CustomerState;
    }

    public String getCustomerPin() {
        return CustomerPin;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }
}
