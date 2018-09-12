/**
 *
 */
package br.com.juliogriebeler.parser.util;

/**
 * Constantes com diretorio base do projeto e diretorios e extensão dos arquivos de entrada e saída.
 *
 * @author juliogriebeler
 */
public class Constants {

    public static final String PROJECT_HOME = System.getProperty("user.dir");
	public static final String DIR_HOME = System.getProperty("user.home");
    public static final String DIR_IN = DIR_HOME + "\\data\\in";
    public static final String DIR_OUT = DIR_HOME + "\\data\\out\\";
    public static final String FILETYPE_IN = ".dat";
    public static final String FILETYPE_OUT = ".done.dat";
    public static final String LINE_SEPARATOR = "ç";
    public static final String ITEM_SEPARATOR = "-";
    public static final String BRACKET_LEFT = "[";
    public static final String BRACKET_RIGHT = "]";
    public static final String BACKSLASH = "\\";
    public static final String BLANK_SPACE = "";
    public static final String COMMA = ",";
    public static final String LINE_BREAK = "\n";
    public static final int NUMBER_LINE_PARTS = 3;

    private Constants() {

    }

}
