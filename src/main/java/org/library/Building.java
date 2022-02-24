package org.library;

public abstract class Building {

    private String name;
    private String address;
    private String architect;
    private int year;
    private boolean isCulturalMonument;

    {
        name = "undefined";
        address = "undefined";
        architect = "undefined";
        year = -1;
        isCulturalMonument = false;
    }

    public Building() {
    }

    public Building(String name, String address, String architect, int year, boolean isCulturalMonument) {
        this.name = name;
        this.address = address;
        this.architect = architect;
        this.year = year;
        this.isCulturalMonument = isCulturalMonument;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getArchitect() {
        return architect;
    }

    public int getYear() {
        return year;
    }

    public boolean isCulturalMonument() {
        return isCulturalMonument;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", architect='" + architect + '\'' +
                ", year=" + year +
                ", isCulturalMonument=" + isCulturalMonument;
    }
}

