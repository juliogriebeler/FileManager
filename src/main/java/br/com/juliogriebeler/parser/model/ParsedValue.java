/**
 *
 */
package br.com.juliogriebeler.parser.model;

/**
 *
 * @author juliogriebeler
 */
public class ParsedValue {

    private String firstParam;
    private String secondParam;
    private String thirdParam;
    private String fourthParam;

    public ParsedValue() {
        //
    }

    /**
     * @param firstParam
     * @param secondParam
     * @param thirdParam
     */
    public ParsedValue(String firstParam, String secondParam, String thirdParam) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
        this.thirdParam = thirdParam;
    }

    /**
     * @return the firstParam
     */
    public String getFirstParam() {
        return firstParam;
    }

    /**
     * @param firstParam the firstParam to set
     */
    public void setFirstParam(String firstParam) {
        this.firstParam = firstParam;
    }

    /**
     * @return the secondParam
     */
    public String getSecondParam() {
        return secondParam;
    }

    /**
     * @param secondParam the secondParam to set
     */
    public void setSecondParam(String secondParam) {
        this.secondParam = secondParam;
    }

    /**
     * @return the thirdParam
     */
    public String getThirdParam() {
        return thirdParam;
    }

    /**
     * @param thirdParam the thirdParam to set
     */
    public void setThirdParam(String thirdParam) {
        this.thirdParam = thirdParam;
    }

    /**
     * @return the fourthParam
     */
    public String getFourthParam() {
        return fourthParam;
    }

    /**
     * @param fourthParam the fourthParam to set
     */
    public void setFourthParam(String fourthParam) {
        this.fourthParam = fourthParam;
    }

}
