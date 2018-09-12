/**
 *
 */
package br.com.juliogriebeler.parser.model;

import java.math.BigInteger;

/**
 *
 * @author juliogriebeler
 */
public class Seller {

    private BigInteger cpf;
    private String name;
    private double sallary;

    public Seller() {
        //
    }

    /**
     * @param cpf
     * @param name
     * @param sallary
     */
    public Seller(BigInteger cpf, String name, double sallary) {
        this.cpf = cpf;
        this.name = name;
        this.sallary = sallary;
    }

    /**
     * @param name
     */
    public Seller(String name) {
        this.name = name;
    }

    /**
     * @return the cpf
     */
    public BigInteger getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sallary
     */
    public double getSallary() {
        return sallary;
    }

    /**
     * @param sallary the sallary to set
     */
    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.cpf;
    }

}
