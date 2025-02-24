package com.mycompany.cleanzone.model;

import java.util.Date;

public class RutaRecoleccion {
    private int idRuta;
    private String nombreRuta;
    private int idRecolector;
    private int idVehiculo;
    private Date fechaUltimaRecoleccion;

    // Constructor vacío
    public RutaRecoleccion() {}

    // Constructor con parámetros
    public RutaRecoleccion(int idRuta, String nombreRuta, int idRecolector, int idVehiculo, Date fechaUltimaRecoleccion) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
        this.idRecolector = idRecolector;
        this.idVehiculo = idVehiculo;
        this.fechaUltimaRecoleccion = fechaUltimaRecoleccion;
    }

    // Getters y Setters
    public int getIdRuta() { return idRuta; }
    public void setIdRuta(int idRuta) { this.idRuta = idRuta; }

    public String getNombreRuta() { return nombreRuta; }
    public void setNombreRuta(String nombreRuta) { this.nombreRuta = nombreRuta; }

    public int getIdRecolector() { return idRecolector; }
    public void setIdRecolector(int idRecolector) { this.idRecolector = idRecolector; }

    public int getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(int idVehiculo) { this.idVehiculo = idVehiculo; }

    public Date getFechaUltimaRecoleccion() { return fechaUltimaRecoleccion; }
    public void setFechaUltimaRecoleccion(Date fechaUltimaRecoleccion) { this.fechaUltimaRecoleccion = fechaUltimaRecoleccion; }
}
