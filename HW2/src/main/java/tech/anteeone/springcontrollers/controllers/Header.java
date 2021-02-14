package tech.anteeone.springcontrollers.controllers;

public class Header {
    public String name;
    public String value;

    public Header(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
