package com.mycompany.cleanzone.model;

import java.util.Date;

public class Reporte {
    private int idReporte;
    private Date fechaGeneracion;
    private int codigoPostal;
    private double cantidadResiduos;
    private int cantidadContenedoresLlenos;
    private String incidenciasReportadas;
    private String estadoEnvio;

    // Constructor vacío
    public Reporte() {}

    // Constructor con parámetros
    public Reporte(int idReporte, Date fechaGeneracion, int codigoPostal, double cantidadResiduos, int cantidadContenedoresLlenos, String incidenciasReportadas, String estadoEnvio) {
        this.idReporte = idReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.codigoPostal = codigoPostal;
        this.cantidadResiduos = cantidadResiduos;
        this.cantidadContenedoresLlenos = cantidadContenedoresLlenos;
        this.incidenciasReportadas = incidenciasReportadas;
        this.estadoEnvio = estadoEnvio;
    }

    // Getters y Setters
    public int getIdReporte() { return idReporte; }
    public void setIdReporte(int idReporte) { this.idReporte = idReporte; }

    public Date getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(Date fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public int getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(int codigoPostal) { this.codigoPostal = codigoPostal; }

    public double getCantidadResiduos() { return cantidadResiduos; }
    public void setCantidadResiduos(double cantidadResiduos) { this.cantidadResiduos = cantidadResiduos; }

    public int getCantidadContenedoresLlenos() { return cantidadContenedoresLlenos; }
    public void setCantidadContenedoresLlenos(int cantidadContenedoresLlenos) { this.cantidadContenedoresLlenos = cantidadContenedoresLlenos; }

    public String getIncidenciasReportadas() { return incidenciasReportadas; }
    public void setIncidenciasReportadas(String incidenciasReportadas) { this.incidenciasReportadas = incidenciasReportadas; }

    public String getEstadoEnvio() { return estadoEnvio; }
    public void setEstadoEnvio(String estadoEnvio) { this.estadoEnvio = estadoEnvio; }
}
