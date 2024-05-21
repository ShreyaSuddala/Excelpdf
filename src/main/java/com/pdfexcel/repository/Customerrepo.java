package com.pdfexcel.repository;

import com.pdfexcel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customerrepo extends JpaRepository<Customer,Integer> {
}
