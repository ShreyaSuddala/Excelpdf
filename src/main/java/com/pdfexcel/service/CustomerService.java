package com.pdfexcel.service;

import com.pdfexcel.model.Customer;
import com.pdfexcel.repository.Customerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerService implements CustomerInterface {

    @Autowired
    private Customerrepo repo;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) repo.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repo.save(customer);
    }

//    public static ByteArrayInputStream customerPDFReport(List<Customer> customers) {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try {
//            PdfWriter.getInstance(document, out);
//            document.open();
//
//            // Add Content to PDF file
//            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
//            Paragraph para = new Paragraph("Customer Structure", fontHeader);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//            document.add(Chunk.NEWLINE);
//
//            PdfPTable table = new PdfPTable(4); // Adjust the number of columns to match the fields
//            // Add PDF Table Header
//            Stream.of("ID", "Name", "Address", "Mobile Number").forEach(headerTitle -> {
//                PdfPCell header = new PdfPCell();
//                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
//                header.setBackgroundColor(Color.CYAN);
//                header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                header.setBorderWidth(2);
//                header.setPhrase(new Phrase(headerTitle, headFont));
//                table.addCell(header);
//            });
//
//            for (Customer customer : customers) {
//                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(customer.getId())));
//                idCell.setPaddingLeft(4);
//                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(idCell);
//
//                PdfPCell nameCell = new PdfPCell(new Phrase(customer.getCustomername()));
//                nameCell.setPaddingLeft(4);
//                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(nameCell);
//
//                PdfPCell addressCell = new PdfPCell(new Phrase(customer.getCustomeraddress()));
//                addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                addressCell.setPaddingRight(4);
//                table.addCell(addressCell);
//
//                PdfPCell mobileNumberCell = new PdfPCell(new Phrase(customer.getMobilenumber()));
//                mobileNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                mobileNumberCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                mobileNumberCell.setPaddingRight(4);
//                table.addCell(mobileNumberCell);
//            }
//
//            document.add(table);
//            document.close();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }
}
