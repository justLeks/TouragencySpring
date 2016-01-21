package com.touragency.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int idOrder;
    private int idTour;
    private int idUSer;

    public Order() {
    }

    public Order(int idTour, int idUSer) {
        this.idTour = idTour;
        this.idUSer = idUSer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public int getIdUSer() {
        return idUSer;
    }

    public void setIdUSer(int idUSer) {
        this.idUSer = idUSer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idTour != order.idTour) return false;
        return idUSer == order.idUSer;

    }

    @Override
    public int hashCode() {
        int result = idTour;
        result = 31 * result + idUSer;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idTour=" + idTour +
                ", idUSer=" + idUSer +
                '}';
    }
}
