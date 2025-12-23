package com.example.tour_travel;

public class hotelmodal {

    String name ,  checkin , checkout ,type , avaliable , price ;

    public hotelmodal(String name, String place, String checkin, String checkout, String type, String avaliable, String price) {
        this.name = name;

        this.checkin = checkin;
        this.checkout = checkout;
        this.type = type;
        this.avaliable = avaliable;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
