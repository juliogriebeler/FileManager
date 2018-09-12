/**
 *
 */
package br.com.juliogriebeler.parser.util;

/**
 *
 * @author juliogriebeler
 */
public enum DataType {

    SELLER("001"), CUSTOMER("002"), SALE("003");

    private String idData;

    /**
     * @param idData
     */
    DataType(String idData) {
        this.idData = idData;
    }

    /**
     * @return
     */
    public String getIdData() {
        return this.idData;
    }
}
