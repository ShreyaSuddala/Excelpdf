package com.pdfexcel.entity;

import javax.persistence.*;

@Entity
@Table(name = "excelpdf")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Customername")
    private String customername;

    @Column(name = "Customeraddress")
    private String customeraddress;

    @Column(name = "mobilenumber")
    private String mobilenumber;

    public Customer(int id, String customername, String customeraddress, String mobilenumber) {
        this.id = id;
        this.customername = customername;
        this.customeraddress = customeraddress;
        this.mobilenumber = mobilenumber;
    }

    public Customer() {
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customername='" + customername + '\'' +
                ", customeraddress='" + customeraddress + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                '}';
    }
}
