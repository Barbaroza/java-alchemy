package com.pmb.creating.builder;

public class Iphone {

    private Motherboard motherboard;

    private Battery battery;

    private Display display;

    public void photo() {
        System.out.println("iphone 拍照片");
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

}

class Motherboard {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Motherboard(String name) {
        super();
        this.name = name;
    }

}

class Battery {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Battery(String name) {
        super();
        this.name = name;
    }

}

class Display {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Display(String name) {
        super();
        this.name = name;
    }

}