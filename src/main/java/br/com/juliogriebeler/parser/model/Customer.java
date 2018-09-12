/**
 *
 */
package br.com.juliogriebeler.parser.model;

import java.math.BigInteger;

/**
 *
 * @author juliogriebeler
 */
public class Customer {

    private BigInteger cnpj;
    private String name;
    private String businessArea;

    /**
     * @param cnpj
     * @param name
     * @param businessArea
     */
    public Customer(BigInteger cnpj, String name, String businessArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    /**
     * @return the cnpj
     */
    public BigInteger getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(BigInteger cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the businessArea
     */
    public String getBusinessArea() {
        return businessArea;
    }

    /**
     * @param businessArea the businessArea to set
     */
    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.cnpj;
    }

}
