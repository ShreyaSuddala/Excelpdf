package com.pdfexcel.controller;
import com.pdfexcel.model.Customer;
import com.pdfexcel.repository.Customerrepo;
import com.pdfexcel.service.CustomerInterface;
import com.pdfexcel.service.ExcelService;
import com.pdfexcel.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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

    @Autowired
    CustomerInterface  custservice;
    @Autowired
    Customerrepo custrepo;

    @Autowired
    ExcelService xlservice;

    @GetMapping
    public List<Customer> getAll(){
        return this.custservice.getAllCustomers();
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return this.custservice.saveCustomer(customer);
    }

    @GetMapping("/fetchpdf")
    public ResponseEntity<InputStreamResource> customerReport() throws IOException{
        List<Customer> custmers = (List<Customer>) custrepo.findAll();

        ByteArrayInputStream biss = PdfService.customerPDFReport(custmers);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(biss));
    }


    @GetMapping("/fetchexcel")
    public void  generateExceleReport(HttpServletResponse response) throws Exception{
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=courses.xls";
        response.setHeader(headerKey, headerValue);
        xlservice.generateExcel(response);
        response.flushBuffer();
    }





}
