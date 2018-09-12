/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;
import br.com.juliogriebeler.parser.model.Sale;
import br.com.juliogriebeler.parser.model.Seller;
import br.com.juliogriebeler.parser.iface.ParserServiceInterface;

/**
 *
 * @author juliogriebeler
 */
public class SaleParserService implements ParserServiceInterface {

    /**
     *
     * @param fileData
     * @param value
     */
    @Override
    public void parse(FileData fileData, ParsedValue value) {
        final String sellerName = value.getFourthParam();

        final Seller seller = fileData.getSellers().stream().filter(s -> sellerName.equals(s.getName())).findAny()
                .orElse(new Seller(sellerName));

        final Sale sale = new Sale(new Integer(value.getSecondParam()), seller);

        final SaleItemParserService saleItemParser = new SaleItemParserService();

        saleItemParser.parse(sale, value.getThirdParam());

        fileData.getSales().add(sale);
    }

}
