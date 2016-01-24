package com.touragency.model;

public class Info {

    private int idOrder;
    private String username;
    private int finalPrice;
    private boolean confirmed;
    private boolean paid;
    private String date;
    private String destCountry;
    private String startDay;
    private String endDay;
    private boolean hot;
    private int hotelClass;
    private String food;
    private String tourType;

    public Info(int idOrder,
                String username,
                int finalPrice,
                boolean confirmed,
                boolean paid,
                String date,
                String destCountry,
                String startDay,
                String endDay,
                boolean hot,
                int hotelClass,
                String food,
                String tourType) {
        this.idOrder = idOrder;
        this.username = username;
        this.finalPrice = finalPrice;
        this.confirmed = confirmed;
        this.paid = paid;
        this.date = date;
        this.destCountry = destCountry;
        this.startDay = startDay;
        this.endDay = endDay;
        this.hot = hot;
        this.hotelClass = hotelClass;
        this.food = food;
        this.tourType = tourType;
    }

    public Info(int finalPrice,
                boolean confirmed,
                boolean paid,
                String date,
                String destCountry,
                String startDay,
                String endDay,
                boolean hot,
                int hotelClass,
                String food,
                String tourType) {
        this.finalPrice = finalPrice;
        this.confirmed = confirmed;
        this.paid = paid;
        this.date = date;
        this.destCountry = destCountry;
        this.startDay = startDay;
        this.endDay = endDay;
        this.hot = hot;
        this.hotelClass = hotelClass;
        this.food = food;
        this.tourType = tourType;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public int getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(int hotelClass) {
        this.hotelClass = hotelClass;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info = (Info) o;

        if (finalPrice != info.finalPrice) return false;
        if (confirmed != info.confirmed) return false;
        if (paid != info.paid) return false;
        if (hot != info.hot) return false;
        if (hotelClass != info.hotelClass) return false;
        if (date != null ? !date.equals(info.date) : info.date != null) return false;
        if (destCountry != null ? !destCountry.equals(info.destCountry) : info.destCountry != null) return false;
        if (startDay != null ? !startDay.equals(info.startDay) : info.startDay != null) return false;
        if (endDay != null ? !endDay.equals(info.endDay) : info.endDay != null) return false;
        if (food != null ? !food.equals(info.food) : info.food != null) return false;
        return tourType != null ? tourType.equals(info.tourType) : info.tourType == null;

    }

    @Override
    public int hashCode() {
        int result = finalPrice;
        result = 31 * result + (confirmed ? 1 : 0);
        result = 31 * result + (paid ? 1 : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (destCountry != null ? destCountry.hashCode() : 0);
        result = 31 * result + (startDay != null ? startDay.hashCode() : 0);
        result = 31 * result + (endDay != null ? endDay.hashCode() : 0);
        result = 31 * result + (hot ? 1 : 0);
        result = 31 * result + hotelClass;
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + (tourType != null ? tourType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Info{" +
                "finalPrice=" + finalPrice +
                ", confirmed=" + confirmed +
                ", paid=" + paid +
                ", date='" + date + '\'' +
                ", destCountry='" + destCountry + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", hot=" + hot +
                ", hotelClass=" + hotelClass +
                ", food='" + food + '\'' +
                ", tourType='" + tourType + '\'' +
                '}';
    }
}
