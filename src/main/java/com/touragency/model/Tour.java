package com.touragency.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTour;

    @Min(value = 1, message = "Price should be greater then 1")
    @Max(value = 999999, message = "Price should be less then 999999")
    private int price;

    @NotBlank(message = "Country field should not be blank")
    @Size(min = 2, max = 25, message = "Country name must be between 2 and 25 characters")
    private String destCountry;

    @NotBlank(message = "Date filed should not be blank")
    @Pattern(regexp = "^(?:(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])|↵\n" +
            "(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9]))/[0-9]{4}$",
            message = "Data field should match the pattern 'mm/dd/yyyy'")
    private String startDay;

    @NotBlank(message = "Date filed should not be blank")
    @Pattern(regexp = "^(?:(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])|↵\n" +
            "(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9]))/[0-9]{4}$",
            message = "Data field should match the pattern 'mm/dd/yyyy'")
    private String endDay;

    private boolean hot;
    private int hotelClass;
    private String food;
    private String tourType;

    public Tour() {
    }

    public Tour(int hotelClass, int price, boolean hot, String destCountry, String startDay, String endDay, String food, String tourType) {
        this.hotelClass = hotelClass;
        this.price = price;
        this.hot = hot;
        this.destCountry = destCountry;
        this.startDay = startDay;
        this.endDay = endDay;
        this.food = food;
        this.tourType = tourType;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public int getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(int hotelClass) {
        this.hotelClass = hotelClass;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
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

        Tour tour = (Tour) o;

        if (hotelClass != tour.hotelClass) return false;
        if (price != tour.price) return false;
        if (hot != tour.hot) return false;
        if (destCountry != null ? !destCountry.equals(tour.destCountry) : tour.destCountry != null) return false;
        if (startDay != null ? !startDay.equals(tour.startDay) : tour.startDay != null) return false;
        if (endDay != null ? !endDay.equals(tour.endDay) : tour.endDay != null) return false;
        if (food != null ? !food.equals(tour.food) : tour.food != null) return false;
        return tourType != null ? tourType.equals(tour.tourType) : tour.tourType == null;

    }

    @Override
    public int hashCode() {
        int result = hotelClass;
        result = 31 * result + price;
        result = 31 * result + (hot ? 1 : 0);
        result = 31 * result + (destCountry != null ? destCountry.hashCode() : 0);
        result = 31 * result + (startDay != null ? startDay.hashCode() : 0);
        result = 31 * result + (endDay != null ? endDay.hashCode() : 0);
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + (tourType != null ? tourType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "idTour=" + idTour +
                ", hotelClass=" + hotelClass +
                ", price=" + price +
                ", hot=" + hot +
                ", destCountry='" + destCountry + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", food='" + food + '\'' +
                ", tourType='" + tourType + '\'' +
                '}';
    }
}
