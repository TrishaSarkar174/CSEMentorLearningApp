package com.hfad.csementorlearningapp;

public class Contributor {
    private int imageResId;
    private String name;
    private String designation;
    private String contact;

    public Contributor(int imageResId, String name, String designation, String contact) {
        this.imageResId = imageResId;
        this.name = name;
        this.designation = designation;
        this.contact = contact;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getContact() {
        return contact;
    }
}
