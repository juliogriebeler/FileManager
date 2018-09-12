/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.juliogriebeler.parser.model.Sale;
import br.com.juliogriebeler.parser.model.Seller;

/**
 *
 * @author juliogriebeler
 */
public class SaleItemParserServiceTest {

    private SaleItemParserService saleItemParserService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.saleItemParserService = new SaleItemParserService();
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.SaleItemParserService#parse(br.com.juliogriebeler.model.Sale, java.lang.String)}.
     */
    @Test
    public void testParse() {
        String saleItemListText = "[1-34-10,2-33-1.50,3-40-0.10]";

        Sale sale = new Sale(new Integer("12345"), new Seller("João"));

        sale.setTotalValue(Double.valueOf("10000"));

        saleItemParserService.parse(sale, saleItemListText);

        assertTrue("verify sale.getSaleItems().get(0) != null", sale.getSaleItems().get(0) != null);
        assertTrue("verify Id", sale.getSaleItems().get(0).getId().equals(new Integer(1)));
        assertTrue("verify Quantity", sale.getSaleItems().get(0).getQuantity().equals(new Integer(34)));
        assertTrue("verify Price", sale.getSaleItems().get(0).getPrice().equals(new Double(10)));
    }

}
