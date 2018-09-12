/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import java.math.BigInteger;

import br.com.juliogriebeler.parser.model.Customer;
import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;
import br.com.juliogriebeler.parser.iface.ParserServiceInterface;

/**
 *
 * @author juliogriebeler
 */
public class CustomerParserService implements ParserServiceInterface {

    /**
     *
     * @param fileData
     * @param value
     */
    @Override
    public void parse(FileData fileData, ParsedValue value) {
        fileData.getCustomers().add(
                new Customer(new BigInteger(value.getSecondParam()), value.getThirdParam(), value.getFourthParam()));
    }

}
