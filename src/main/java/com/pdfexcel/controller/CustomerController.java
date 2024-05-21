package com.pdfexcel.controller;
import com.pdfexcel.entity.Customer;
import com.pdfexcel.model.CustomerDTO;
import com.pdfexcel.repository.Customerrepo;
import com.pdfexcel.service.CustomerInterface;
import com.pdfexcel.service.ExcelService;
import com.pdfexcel.service.PdfService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/customs")
public class CustomerController {
    public final CustomerInterface custservice;
    public final Customerrepo custrepo;
    public final ExcelService xlservice;

    public CustomerController(CustomerInterface custservice, Customerrepo custrepo,
                              ExcelService xlservice){
        this.custservice = custservice;
        this.custrepo = custrepo;
        this.xlservice = xlservice;
    }

    @GetMapping
    public List<Customer> getAll(){
        return this.custservice.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<Customer>createCustomer(@RequestBody CustomerDTO custDto){
    Customer cust = new Customer();
    cust.setCustomername(custDto.getCustomername());
    cust.setCustomeraddress(custDto.getCustomeraddress());
    cust.setMobilenumber(custDto.getMobilenumber());
    Customer saveCustomer = this.custservice.saveCustomer(cust);
    return new ResponseEntity<>(saveCustomer , HttpStatus.CREATED);
    }



    @GetMapping("/fetchpdf")
    public ResponseEntity<InputStreamResource> customerReport() {
        List<Customer> custmers =  custrepo.findAll();

        ByteArrayInputStream biss = PdfService.customerPDFReport(custmers);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(biss));
    }


    @GetMapping("/fetchexcel")
    public void  generateExceleReport(HttpServletResponse response) throws IOException{
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=customers.xls";
        response.setHeader(headerKey, headerValue);
        xlservice.generateExcel(response);
        response.flushBuffer();
    }





}
