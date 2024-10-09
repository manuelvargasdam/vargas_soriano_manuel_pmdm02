package com.vargas_soriano_manuel_pmdm02;

public class Personaje {
    private String name;
    private int imageResource;
    private String description;
    private String abilities;

    public Personaje(String name, int imageResource, String description, String abilities) {
        this.name = name;
        this.imageResource = imageResource;
        this.description = description;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }

    public String getAbilities() {
        return abilities;
    }
}