/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dsg.aic.ws10.server;

import java.math.BigDecimal;

/**
 *
 * @author smolle
 */
public class Customer {

    private String id;
    private String name;
    private BigDecimal openBalance = new BigDecimal(0);

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(BigDecimal openBalance) {
        this.openBalance = openBalance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.openBalance != other.openBalance && (this.openBalance == null || !this.openBalance.equals(other.openBalance))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 59 * hash + (this.openBalance != null ? this.openBalance.hashCode() : 0);
        return hash;
    }



}
