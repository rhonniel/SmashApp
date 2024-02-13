package com.LaParcelaStudio.SmashReview.DTO;

public class TournamentDTO {
    int id;
    String name;
    String countryCode;
    public TournamentDTO() {
        // Constructor sin argumentos requerido por Jackson
    }

    // Getters y setters para todos los campos
    // Asegúrate de tener getters para todos los campos que deseas serializar
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
