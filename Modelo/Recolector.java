package com.mycompany.cleanzone.model;

import java.util.Date;

public class Recolector {
    private int idRecolector;
    private String nombre;
    private int codigoPostal;
    private String turno;
    private double cantidadRecolectada;
    private String vehiculoAsignado;
    private Date fechaUltimaActividad;

    // Constructor vacío
    public Recolector() {}

    // Constructor con parámetros
    public Recolector(int idRecolector, String nombre, int codigoPostal, String turno, double cantidadRecolectada, String vehiculoAsignado, Date fechaUltimaActividad) {
        this.idRecolector = idRecolector;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.turno = turno;
        this.cantidadRecolectada = cantidadRecolectada;
        this.vehiculoAsignado = vehiculoAsignado;
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    // Getters y Setters
    public int getIdRecolector() { return idRecolector; }
    public void setIdRecolector(int idRecolector) { this.idRecolector = idRecolector; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(int codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public double getCantidadRecolectada() { return cantidadRecolectada; }
    public void setCantidadRecolectada(double cantidadRecolectada) { this.cantidadRecolectada = cantidadRecolectada; }

    public String getVehiculoAsignado() { return vehiculoAsignado; }
    public void setVehiculoAsignado(String vehiculoAsignado) { this.vehiculoAsignado = vehiculoAsignado; }

    public Date getFechaUltimaActividad() { return fechaUltimaActividad; }
    public void setFechaUltimaActividad(Date fechaUltimaActividad) { this.fechaUltimaActividad = fechaUltimaActividad; }
}
