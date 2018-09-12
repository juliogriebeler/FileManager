/**
 *
 */
package br.com.juliogriebeler.parser.exception;

/**
 *
 * @author juliogriebeler
 */
public class ParserRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -7322166792411023644L;

    /**
     *
     * @param e
     */
    public ParserRuntimeException(Exception e) {
        super(e);
    }

}
