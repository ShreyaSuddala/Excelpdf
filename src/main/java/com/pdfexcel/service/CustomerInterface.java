package com.pdfexcel.service;

import com.pdfexcel.model.Customer;

import java.util.List;

public interface CustomerInterface {

    public List<Customer> getAllCustomers();
    public Customer saveCustomer(Customer customer);



}
