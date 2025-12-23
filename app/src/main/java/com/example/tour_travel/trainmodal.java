package com.example.tour_travel;

public class trainmodal {
    String name, time, price, coach, available, depart, arrival, tdepart, tarrival;

    // ✅ Proper constructor (no empty one)
    public trainmodal(String name, String time, String price, String coach,
                      String available, String depart, String arrival,
                      String tdepart, String tarrival) {
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

    // ✅ Getters
    public String getName() { return name; }
    public String getTime() { return time; }
    public String getPrice() { return price; }
    public String getCoach() { return coach; }
    public String getAvailable() { return available; }
    public String getDepart() { return depart; }
    public String getArrival() { return arrival; }
    public String getTdepart() { return tdepart; }
    public String getTarrival() { return tarrival; }
}
