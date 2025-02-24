package com.mycompany.cleanzone.model;

import java.util.Date;

public class Zona {
    private int codigoPostal;
    private String nombreZona;
    private int cantidadContenedores;
    private String nivelAcumulacionBasura;
    private String frecuenciaRecoleccion;
    private String tipoProblema;
    private Date fechaUltimaActualizacion;

    // Constructor vacío
    public Zona() {}

    // Constructor con parámetros
    public Zona(int codigoPostal, String nombreZona, int cantidadContenedores, String nivelAcumulacionBasura, 
                String frecuenciaRecoleccion, String tipoProblema, Date fechaUltimaActualizacion) {
        this.codigoPostal = codigoPostal;
        this.nombreZona = nombreZona;
        this.cantidadContenedores = cantidadContenedores;
        this.nivelAcumulacionBasura = nivelAcumulacionBasura;
        this.frecuenciaRecoleccion = frecuenciaRecoleccion;
        this.tipoProblema = tipoProblema;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    // Getters y Setters
    public int getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(int codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getNombreZona() { return nombreZona; }
    public void setNombreZona(String nombreZona) { this.nombreZona = nombreZona; }

    public int getCantidadContenedores() { return cantidadContenedores; }
    public void setCantidadContenedores(int cantidadContenedores) { this.cantidadContenedores = cantidadContenedores; }

    public String getNivelAcumulacionBasura() { return nivelAcumulacionBasura; }
    public void setNivelAcumulacionBasura(String nivelAcumulacionBasura) { this.nivelAcumulacionBasura = nivelAcumulacionBasura; }

    public String getFrecuenciaRecoleccion() { return frecuenciaRecoleccion; }
    public void setFrecuenciaRecoleccion(String frecuenciaRecoleccion) { this.frecuenciaRecoleccion = frecuenciaRecoleccion; }

    public String getTipoProblema() { return tipoProblema; }
    public void setTipoProblema(String tipoProblema) { this.tipoProblema = tipoProblema; }

    public Date getFechaUltimaActualizacion() { return fechaUltimaActualizacion; }
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) { this.fechaUltimaActualizacion = fechaUltimaActualizacion; }
}
