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
public class FileData {

    private List<Seller> sellers;
    private List<Customer> customers;
    private List<Sale> sales;

    public FileData() {
        this.sellers = new ArrayList();
        this.customers = new ArrayList();
        this.sales = new ArrayList();
    }

    /**
     * @return the seller
     */
    public List<Seller> getSellers() {
        return sellers;
    }

    /**
     *
     * @param sellers
     */
    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    /**
     * @return the customer
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     *
     * @param customers
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /**
     * @return the sales
     */
    public List<Sale> getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

}
