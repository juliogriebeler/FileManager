/**
 *
 */
package br.com.juliogriebeler.parser.iface;

import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;

/**
 *
 * @author juliogriebeler
 */
@FunctionalInterface
public interface ParserServiceInterface {

    /**
     *
     * @param fileData
     * @param value
     */
    void parse(FileData fileData, ParsedValue value);

}
