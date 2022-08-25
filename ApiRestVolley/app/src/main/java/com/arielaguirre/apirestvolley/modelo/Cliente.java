package com.arielaguirre.apirestvolley.modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String appellido;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppellido() {
        return appellido;
    }

    public void setAppellido(String appellido) {
        this.appellido = appellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
