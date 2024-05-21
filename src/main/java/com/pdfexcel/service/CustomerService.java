package com.pdfexcel.service;

import com.pdfexcel.entity.Customer;
import com.pdfexcel.repository.Customerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerService implements CustomerInterface {

    private final Customerrepo repo;

    @Autowired
    public CustomerService(Customerrepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repo.save(customer);
    }
}