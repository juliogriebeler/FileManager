/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import java.math.BigInteger;

import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;
import br.com.juliogriebeler.parser.model.Seller;
import br.com.juliogriebeler.parser.iface.ParserServiceInterface;

/**
 *
 * @author juliogriebeler
 */
public class SellerParserService implements ParserServiceInterface {

    /**
     *
     * @param fileData
     * @param value
     */
    @Override
    public void parse(FileData fileData, ParsedValue value) {
        fileData.getSellers().add(new Seller(new BigInteger(value.getSecondParam()), value.getThirdParam(),
                Double.parseDouble(value.getFourthParam())));
    }

}
