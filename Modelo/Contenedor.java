package com.mycompany.cleanzone.model;

import java.util.Date;

public class Contenedor {
    private String idContenedor;
    private String ubicacion;
    private String estado;
    private double capacidadTotal;
    private double capacidadActual;
    private Date fechaUltimaRecoleccion;
    private String tipoResiduos;

    // Constructor vacío
    public Contenedor() {
    }

    // Constructor con parámetros
    public Contenedor(String idContenedor, String ubicacion, String estado, double capacidadTotal, double capacidadActual, Date fechaUltimaRecoleccion, String tipoResiduos) {
        this.idContenedor = idContenedor;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.capacidadTotal = capacidadTotal;
        this.capacidadActual = capacidadActual;
        this.fechaUltimaRecoleccion = fechaUltimaRecoleccion;
        this.tipoResiduos = tipoResiduos;
    }

    // Getters y Setters
    public String getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(String idContenedor) {
        this.idContenedor = idContenedor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(double capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(double capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public Date getFechaUltimaRecoleccion() {
        return fechaUltimaRecoleccion;
    }

    public void setFechaUltimaRecoleccion(Date fechaUltimaRecoleccion) {
        this.fechaUltimaRecoleccion = fechaUltimaRecoleccion;
    }

    public String getTipoResiduos() {
        return tipoResiduos;
    }

    public void setTipoResiduos(String tipoResiduos) {
        this.tipoResiduos = tipoResiduos;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Contenedor{" +
                "idContenedor='" + idContenedor + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", estado='" + estado + '\'' +
                ", capacidadTotal=" + capacidadTotal +
                ", capacidadActual=" + capacidadActual +
                ", fechaUltimaRecoleccion=" + fechaUltimaRecoleccion +
                ", tipoResiduos='" + tipoResiduos + '\'' +
                '}';
    }
}
