/**
 *
 */
package br.com.juliogriebeler.parser.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.juliogriebeler.parser.impl.CustomerParserService;
import br.com.juliogriebeler.parser.report.ReportBuilder;
import br.com.juliogriebeler.parser.impl.SaleParserService;
import br.com.juliogriebeler.parser.impl.SellerParserService;
import br.com.juliogriebeler.parser.util.DataType;
import br.com.juliogriebeler.parser.iface.ParserServiceInterface;

/**
 *
 * @author juliogriebeler
 */
public class ParserFactory {

    private static final Logger LOGGER = Logger.getLogger(ReportBuilder.class.getName());

    private ParserFactory() {
        //        
    }

    /**
     *
     * @param id
     * @return
     */
    public static ParserServiceInterface getParser(final String id) {
        LOGGER.log(Level.INFO, "Iniciando ParserFactory com id {0}", id);

        if (id.equals(DataType.CUSTOMER.getIdData())) {
            return new CustomerParserService();
        } else if (id.equals(DataType.SALE.getIdData())) {
            return new SaleParserService();
        } else if (id.equals(DataType.SELLER.getIdData())) {
            return new SellerParserService();
        }

        return null;
    }

}
