/**
 *
 */
package br.com.juliogriebeler.parser.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juliogriebeler
 */
public class Sale {

    private Integer idSale;
    private List<SaleItem> saleItems;
    private Seller seller;
    private Double totalValue;

    public Sale(Integer idSale, Seller seller) {
        this.idSale = idSale;
        this.seller = seller;
        this.saleItems = new ArrayList();
        this.totalValue = Double.valueOf(0);
    }

    /**
     * @return the idSale
     */
    public Integer getIdSale() {
        return idSale;
    }

    /**
     * @param idSale the idSale to set
     */
    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    /**
     * @return the saleItems
     */
    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    /**
     * @param saleItems the saleItems to set
     */
    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    /**
     * @return the seller
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * @param seller the seller to set
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * @return the totalValue
     */
    public Double getTotalValue() {
        return totalValue;
    }

    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return this.idSale + " - " + this.seller;
    }

}
