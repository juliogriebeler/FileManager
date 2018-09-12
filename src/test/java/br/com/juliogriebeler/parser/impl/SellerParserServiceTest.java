/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import br.com.juliogriebeler.parser.impl.SellerParserService;
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
public class SellerParserServiceTest {

    private SellerParserService sellerParserService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        sellerParserService = new SellerParserService();
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.SellerParserService#parse(br.com.juliogriebeler.model.FileData, br.com.juliogriebeler.model.ParsedValue)}.
     */
    @Test
    public void testParse() {
        FileData fileData = new FileData();

        String cpf = "34598712340";
        String nameSeller = "Pedro";
        String sallary = "2000";

        ParsedValue value = new ParsedValue();

        value.setSecondParam(cpf);
        value.setThirdParam(nameSeller);
        value.setFourthParam(sallary);

        sellerParserService.parse(fileData, value);

        assertFalse("verify fileData.getSellers().isEmpty()", fileData.getSellers().isEmpty());
        assertTrue("verify fileData.getSellers().get(0) != null", fileData.getSellers().get(0) != null);
        assertTrue("verify Name", fileData.getSellers().get(0).getName().equals(nameSeller));
        assertTrue("verify Sallary", fileData.getSellers().get(0).getSallary() == Double.parseDouble(sallary));
    }

}
