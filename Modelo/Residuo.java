package com.mycompany.cleanzone.model;

import java.util.Date;

public class Residuo {
    private int idResiduo;
    private String tipo;
    private double peso;
    private Date fechaRecoleccion;

    // Constructor vacío
    public Residuo() {
    }

    // Constructor con parámetros
    public Residuo(int idResiduo, String tipo, double peso, Date fechaRecoleccion) {
        this.idResiduo = idResiduo;
        this.tipo = tipo;
        this.peso = peso;
        this.fechaRecoleccion = fechaRecoleccion;
    }

    // Getters y Setters
    public int getIdResiduo() {
        return idResiduo;
    }

    public void setIdResiduo(int idResiduo) {
        this.idResiduo = idResiduo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public void setFechaRecoleccion(Date fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Residuo{" +
                "idResiduo=" + idResiduo +
                ", tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", fechaRecoleccion=" + fechaRecoleccion +
                '}';
    }
}

