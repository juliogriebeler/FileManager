/**
 *
 */
package br.com.juliogriebeler.parser.report;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import br.com.juliogriebeler.parser.model.Customer;
import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.Sale;
import br.com.juliogriebeler.parser.model.Seller;

/**
 *
 * @author juliogriebeler
 */
public class ReportBuilderTest {

    private ReportBuilder reportBuilder;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.reportBuilder = new ReportBuilder();
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ReportBuilder#getTextCustomerQty(br.com.juliogriebeler.model.FileData)}.
     */
    @Test
    public void testGetTextCustomerQty() {
        String textExpected = "1. Quantidade de Clientes: 3";

        FileData fileData = new FileData();

        Customer c1 = new Customer(new BigInteger("12345612345"), "João", "Rural");
        Customer c2 = new Customer(new BigInteger("23456709867"), "Pedro", "TI");
        Customer c3 = new Customer(new BigInteger("34654709867"), "Alberto", "Contábil");

        fileData.getCustomers().add(c1);
        fileData.getCustomers().add(c2);
        fileData.getCustomers().add(c3);

        assertTrue("verify TextCustomerQty", reportBuilder.getTextCustomerQty(fileData).equals(textExpected));
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ReportBuilder#getTextSellerQty(br.com.juliogriebeler.model.FileData)}.
     */
    @Test
    public void testGetTextSellerQty() {
        String textExpected = "2. Quantidade de Vendedores: 3";

        FileData fileData = new FileData();

        Seller s1 = new Seller(new BigInteger("12345612345"), "João", Double.valueOf("2000"));
        Seller s2 = new Seller(new BigInteger("23456709867"), "Pedro", Double.valueOf("3000"));
        Seller s3 = new Seller(new BigInteger("34654709867"), "Alberto", Double.valueOf("4000"));

        fileData.getSellers().add(s1);
        fileData.getSellers().add(s2);
        fileData.getSellers().add(s3);

        assertTrue("verify TextSellerQty", reportBuilder.getTextSellerQty(fileData).equals(textExpected));
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ReportBuilder#getTextSaleHigestValue(br.com.juliogriebeler.model.FileData)}.
     */
    @Test
    public void testGetTextSaleHigestValue() {
        String textExpected = "3. ID da Venda de valor mais alto: 346547";

        FileData fileData = new FileData();

        Sale s1 = new Sale(new Integer("123456"), new Seller("João"));

        s1.setTotalValue(Double.valueOf("10000"));

        Sale s2 = new Sale(new Integer("234567"), new Seller("Pedro"));

        s2.setTotalValue(Double.valueOf("20000"));

        Sale s3 = new Sale(new Integer("346547"), new Seller("Alberto"));

        s3.setTotalValue(Double.valueOf("30000"));

        fileData.getSales().add(s1);
        fileData.getSales().add(s2);
        fileData.getSales().add(s3);

        assertTrue("verify TextSaleHigestValue", reportBuilder.getTextSaleHigestValue(fileData).equals(textExpected));
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ReportBuilder#getTextWorstSeller(br.com.juliogriebeler.model.FileData)}.
     */
    @Test
    public void testGetTextWorstSeller() {
        String textExpected = "4. Nome do pior Vendedor: João";
        FileData fileData = new FileData();

        Sale s1 = new Sale(new Integer("12345"), new Seller("João"));

        s1.setTotalValue(Double.valueOf("10000"));

        Sale s2 = new Sale(new Integer("29867"), new Seller("Pedro"));

        s2.setTotalValue(Double.valueOf("20000"));

        Sale s3 = new Sale(new Integer("3867"), new Seller("Alberto"));

        s3.setTotalValue(Double.valueOf("30000"));

        fileData.getSales().add(s1);
        fileData.getSales().add(s2);
        fileData.getSales().add(s3);

        assertTrue("verify TextWorstSeller", reportBuilder.getTextWorstSeller(fileData).equals(textExpected));
    }

}
