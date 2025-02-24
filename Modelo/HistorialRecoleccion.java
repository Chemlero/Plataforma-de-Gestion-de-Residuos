package com.mycompany.cleanzone.model;

import java.util.Date;

public class HistorialRecoleccion {
    private int idHistorial;
    private int idRecolector;
    private int idVehiculo;
    private int cantidadRecolectada;
    private Date fechaRecoleccion;

    // Constructor vacío
    public HistorialRecoleccion() {}

    // Constructor con parámetros
    public HistorialRecoleccion(int idHistorial, int idRecolector, int idVehiculo, int cantidadRecolectada, Date fechaRecoleccion) {
        this.idHistorial = idHistorial;
        this.idRecolector = idRecolector;
        this.idVehiculo = idVehiculo;
        this.cantidadRecolectada = cantidadRecolectada;
        this.fechaRecoleccion = fechaRecoleccion;
    }

    // Getters y Setters
    public int getIdHistorial() { return idHistorial; }
    public void setIdHistorial(int idHistorial) { this.idHistorial = idHistorial; }

    public int getIdRecolector() { return idRecolector; }
    public void setIdRecolector(int idRecolector) { this.idRecolector = idRecolector; }

    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }

    public int getCantidadRecolectada() { return cantidadRecolectada; }
    public void setCantidadRecolectada(int cantidadRecolectada) { this.cantidadRecolectada = cantidadRecolectada; }

    public Date getFechaRecoleccion() { return fechaRecoleccion; }
    public void setFechaRecoleccion(Date fechaRecoleccion) { this.fechaRecoleccion = fechaRecoleccion; }
}
