package com.khanfar.project;

public class NotificationItem {
    private int image ;
    private String Date , time ;
    private String nameOfProduct ;
    private String nameOfCustomer ;

    public NotificationItem(int image, String date , String time, String nameOfProduct, String nameOfCustomer) {
        this.image = image;
        Date = date;
        this.time = time ;
        this.nameOfProduct = nameOfProduct;
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "image=" + image +
                ", Date='" + Date + '\'' +
                ", time='" + time + '\'' +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", nameOfCustomer='" + nameOfCustomer + '\'' +
                '}';
    }
}
