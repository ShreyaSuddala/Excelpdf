package com.pdfexcel.model;

public class CustomerDTO {

    private int id;
    private String customername;
    private String customeraddress;
    private String mobilenumber;

    // Constructors
    public CustomerDTO() {}

    public CustomerDTO(int id, String customername, String customeraddress, String mobilenumber) {
        this.id = id;
        this.customername = customername;
        this.customeraddress = customeraddress;
        this.mobilenumber = mobilenumber;
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

    // toString method
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", customername='" + customername + '\'' +
                ", customeraddress='" + customeraddress + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                '}';
    }
}
