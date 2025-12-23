package com.example.tour_travel;

public class flightmodal {

    String  name, time, price, coach, available, depart, arrival, tdepart, tarrival;

    public flightmodal(String name, String time, String price, String coach, String available, String depart, String arrival, String tdepart, String tarrival) {
        this.name = name;
        this.time = time;
        this.price = price;
        this.coach = coach;
        this.available = available;
        this.depart = depart;
        this.arrival = arrival;
        this.tdepart = tdepart;
        this.tarrival = tarrival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTdepart() {
        return tdepart;
    }

    public void setTdepart(String tdepart) {
        this.tdepart = tdepart;
    }

    public String getTarrival() {
        return tarrival;
    }

    public void setTarrival(String tarrival) {
        this.tarrival = tarrival;
    }
}
