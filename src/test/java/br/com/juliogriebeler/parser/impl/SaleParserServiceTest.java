/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;

/**
 *
 * @author juliogriebeler
 */
public class SaleParserServiceTest {

    private SaleParserService saleParserService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.saleParserService = new SaleParserService();
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.SaleParserService#parse(br.com.juliogriebeler.model.FileData, br.com.juliogriebeler.model.ParsedValue)}.
     */
    @Test
    public void testParse() {
        FileData fileData = new FileData();

        String sellerName = "Pedro";

        String listItemsString = "[1-34-10,2-33-1.50,3-40-0.10]";

        ParsedValue value = new ParsedValue();

        value.setSecondParam("1234");
        value.setThirdParam(listItemsString);
        value.setFourthParam(sellerName);

        saleParserService.parse(fileData, value);

        assertFalse("verify fileData.getSales().isEmpty()", fileData.getSales().isEmpty());
        assertTrue("verify fileData.getSales().get(0) != null", fileData.getSales().get(0) != null);
        assertTrue("verify Name", fileData.getSales().get(0).getSeller().getName().equals(sellerName));
        assertFalse("verify SaleItems", fileData.getSales().get(0).getSaleItems().isEmpty());
    }

}
