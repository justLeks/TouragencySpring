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
    private int finalPrice;
    private boolean confirmed;
    private boolean paid;
    private String email;
    private String date;

    public Order() {
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

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idTour != order.idTour) return false;
        if (finalPrice != order.finalPrice) return false;
        if (confirmed != order.confirmed) return false;
        if (paid != order.paid) return false;
        if (email != null ? !email.equals(order.email) : order.email != null) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = idTour;
        result = 31 * result + finalPrice;
        result = 31 * result + (confirmed ? 1 : 0);
        result = 31 * result + (paid ? 1 : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idTour=" + idTour +
                ", finalPrice=" + finalPrice +
                ", confirmed=" + confirmed +
                ", paid=" + paid +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}