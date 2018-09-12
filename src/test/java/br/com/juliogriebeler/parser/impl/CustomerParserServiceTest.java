/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;
import br.com.juliogriebeler.parser.util.DataType;

/**
 *
 * @author juliogriebeler
 */
public class CustomerParserServiceTest {

    private CustomerParserService customerParserService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerParserService = new CustomerParserService();
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.CustomerParserService#parse(br.com.juliogriebeler.model.FileData, br.com.juliogriebeler.model.ParsedValue)}.
     */
    @Test
    public void testParse() {
        FileData fileData = new FileData();

        String cnpj = "1234567890";
        String name = "Pedro";
        String businessArea = "TI";

        ParsedValue value = new ParsedValue(DataType.CUSTOMER.getIdData(), cnpj, name);

        value.setFourthParam(businessArea);

        customerParserService.parse(fileData, value);

        assertFalse("verify getCustomers().isEmpty()", fileData.getCustomers().isEmpty());
        assertTrue("verify getCustomers().get(0) != null", fileData.getCustomers().get(0) != null);
        assertTrue("verify Cnpj", fileData.getCustomers().get(0).getCnpj().equals(new BigInteger(cnpj)));
        assertTrue("verify Name", fileData.getCustomers().get(0).getName().equals(name));
        assertTrue("verify BusinessArea", fileData.getCustomers().get(0).getBusinessArea().equals(businessArea));
    }

}
