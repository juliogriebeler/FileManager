/**
 *
 */
package br.com.juliogriebeler.parser.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.juliogriebeler.parser.factory.ParserFactory;
import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;

/**
 *
 * @author juliogriebeler
 */
public class ParserUtil {

    private static final Logger LOGGER = Logger.getLogger(ParserUtil.class.getName());

    private ParserUtil() {

    }

    /**
     * Divide o conteudo do texto baseado no separador, verifica se os dados estao preenchidos e cria um objeto Linha
     *
     * @param value
     * @param separator
     * @return
     */
    public static ParsedValue parseStringValue(String value, String separator) {
        final String[] lineParts = value.split(separator);

        final ParsedValue parsedValue = new ParsedValue(lineParts[0], lineParts[1], lineParts[2]);

        if (lineParts.length > Constants.NUMBER_LINE_PARTS) {
            parsedValue.setFourthParam(lineParts[Constants.NUMBER_LINE_PARTS]);
        }

        return parsedValue;
    }

    /**
     *
     * @param value
     * @param fileData
     * @throws IOException
     */
    public static void parseValueToObject(ParsedValue value, FileData fileData) throws IOException {
        if (validateParsedValue(value)) {
            ParserFactory.getParser(value.getFirstParam()).parse(fileData, value);
        } else {
            LOGGER.log(Level.INFO, "O Seguinte dado contém erro: {0} ", value);
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static Boolean validateParsedValue(ParsedValue value) {
        return value.getFirstParam() != null
                && value.getSecondParam() != null
                && value.getThirdParam() != null
                && value.getFourthParam() != null;
    }

}
