package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
   // private InvoiceDao invoiceDao;
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
//Given
        Product product = new Product("buty");

        Item item = new Item(new BigDecimal(150), 2, new BigDecimal(300));
        Item item2 = new Item(new BigDecimal(400), 1, new BigDecimal(400));

        Invoice invoice = new Invoice("2018/1" );

        product.getItems().add(item);
        product.getItems().add(item2);

        invoice.getItems().add(item);
        invoice.getItems().add(item2);

        item.setInvoice(invoice);
        item2.setInvoice(invoice);

        item.setProduct(product);
        item2.setProduct(product);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.delete(id);
    }
}
