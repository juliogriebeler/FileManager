/**
 *
 */
package br.com.juliogriebeler.parser.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;

/**
 *
 * @author juliogriebeler
 */
public class ParserUtilsTest {

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ParserService#parseStringValue(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testParseStringValueWithSeller() {
        String value = "001Á1234567891234ÁPedroÁ50000";

        ParsedValue parsedValue = ParserUtil.parseStringValue(value, Constants.LINE_SEPARATOR);

        assertEquals("verify First", parsedValue.getFirstParam(), "001");
        assertEquals("verify Second", parsedValue.getSecondParam(), "1234567891234");
        assertEquals("verify Third", parsedValue.getThirdParam(), "Pedro");
        assertEquals("verify Fourth", parsedValue.getFourthParam(), "50000");
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ParserService#parseStringValue(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testParseStringValueWithCustomer() {
        String value = "002Á2345675434544345ÁJose da SilvaÁRural";

        ParsedValue parsedValue = ParserUtil.parseStringValue(value, Constants.LINE_SEPARATOR);

        assertEquals("verify First", parsedValue.getFirstParam(), "002");
        assertEquals("verify Second", parsedValue.getSecondParam(), "2345675434544345");
        assertEquals("verify Third", parsedValue.getThirdParam(), "Jose da Silva");
        assertEquals("verify Fourth", parsedValue.getFourthParam(), "Rural");
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ParserService#parseStringValue(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testParseStringValueWithSale() {
        String value = "003Á08Á[1-34-10,2-33-1.50,3-40-0.10]ÁPedro";

        ParsedValue parsedValue = ParserUtil.parseStringValue(value, Constants.LINE_SEPARATOR);

        assertEquals("verify First", parsedValue.getFirstParam(), "003");
        assertEquals("verify Second", parsedValue.getSecondParam(), "08");
        assertEquals("verify Third", parsedValue.getThirdParam(), "[1-34-10,2-33-1.50,3-40-0.10]");
        assertEquals("verify Fourth", parsedValue.getFourthParam(), "Pedro");
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ParserService#parseValueToObject(br.com.juliogriebeler.model.ParsedValue, br.com.juliogriebeler.model.FileData)}.
     *
     * @throws Exception
     */
    @Test
    public void testParseValueToObject() throws Exception {
        String value = "003Á08Á[1-34-10,2-33-1.50,3-40-0.10]ÁPedro";

        Integer saleId = 8;

        ParsedValue parsedValue = ParserUtil.parseStringValue(value, Constants.LINE_SEPARATOR);

        FileData fileData = new FileData();

        ParserUtil.parseValueToObject(parsedValue, fileData);

        assertTrue("verify IdSale", fileData.getSales().get(0).getIdSale().equals(saleId));

    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ParserService#validateParsedValue(br.com.juliogriebeler.model.ParsedValue)}.
     */
    @Test
    public void testValidateParsedValueTrue() {
        String value = "003Á08Á[1-34-10,2-33-1.50,3-40-0.10]ÁPedro";

        ParsedValue parsedValue = ParserUtil.parseStringValue(value, Constants.LINE_SEPARATOR);

        assertTrue("verify Value", ParserUtil.validateParsedValue(parsedValue));
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.ParserService#validateParsedValue(br.com.juliogriebeler.model.ParsedValue)}.
     */
    @Test
    public void testValidateParsedValueFalse() {
        ParsedValue parsedValue = new ParsedValue("01", "02", "03");

        assertFalse("verify Value", ParserUtil.validateParsedValue(parsedValue));
    }

}
