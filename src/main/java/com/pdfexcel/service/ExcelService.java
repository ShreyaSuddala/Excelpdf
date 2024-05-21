package com.pdfexcel.service;
import com.pdfexcel.model.Customer;
import com.pdfexcel.repository.Customerrepo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    public Customerrepo custrepo;

    public void generateExcel(HttpServletResponse response) throws Exception{
        List<Customer> customers = custrepo.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Customers");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("customername");
        row.createCell(2).setCellValue("customeraddress");
        row.createCell(3).setCellValue("mobilenumber");

        int dataRowIndex=1;

        for(Customer customer : customers){
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(customer.getId());
            dataRow.createCell(1).setCellValue(customer.getCustomername());
            dataRow.createCell(2).setCellValue(customer.getCustomeraddress());
            dataRow.createCell(3).setCellValue(customer.getMobilenumber());
            dataRowIndex++;
        }

        ServletOutputStream output = response.getOutputStream();
        workbook.write(output);
        workbook.close();
        output.close();
    }
}
