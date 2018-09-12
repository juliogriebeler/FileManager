/**
 *
 */
package br.com.juliogriebeler.parser.impl;

import java.util.Arrays;

import br.com.juliogriebeler.parser.model.ParsedValue;
import br.com.juliogriebeler.parser.model.Sale;
import br.com.juliogriebeler.parser.model.SaleItem;
import br.com.juliogriebeler.parser.util.Constants;
import br.com.juliogriebeler.parser.util.ParserUtil;

/**
 *
 * @author juliogriebeler
 */
public class SaleItemParserService {

	/**
	 *
	 * @param sale
	 * @param saleItemListText
	 */
	public void parse(Sale sale, String saleItemListText) {
		Arrays.stream(saleItemListText.split(Constants.COMMA)).map(String::trim).forEach(s -> createSaleItem(sale, s));
	}

	/**
	 *
	 * @param sale
	 * @param item
	 */
	public void createSaleItem(Sale sale, String item) {
		String cleanItem = item.replace(Constants.BRACKET_LEFT, Constants.BLANK_SPACE).replace(Constants.BRACKET_RIGHT,
				Constants.BLANK_SPACE);
		final ParsedValue value = ParserUtil.parseStringValue(cleanItem, Constants.ITEM_SEPARATOR);

		final Integer id = Integer.parseInt(value.getFirstParam());

		final Integer quantity = Integer.parseInt(value.getSecondParam());

		final Double itemValue = Double.valueOf(value.getThirdParam());

		sale.setTotalValue(sale.getTotalValue() + (quantity * itemValue));

		sale.getSaleItems().add(new SaleItem(id, quantity, itemValue));
	}

}
