package com.mycompany.cleanzone.model;

public class Autoridad {
    private int idAutoridad; // ID de la autoridad
    private String nombre;
    private String institucion;
    private String correo;
    private String telefono;
    private int reportesRecibidos;
    private String accionesTomadas;

    // Constructor vacío
    public Autoridad() {}

    // Constructor con parámetros
    public Autoridad(int idAutoridad, String nombre, String institucion, String correo, String telefono, int reportesRecibidos, String accionesTomadas) {
        this.idAutoridad = idAutoridad;
        this.nombre = nombre;
        this.institucion = institucion;
        this.correo = correo;
        this.telefono = telefono;
        this.reportesRecibidos = reportesRecibidos;
        this.accionesTomadas = accionesTomadas;
    }

    // Getters y Setters
    public int getIdAutoridad() { return idAutoridad; }
    public void setIdAutoridad(int idAutoridad) { this.idAutoridad = idAutoridad; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getReportesRecibidos() { return reportesRecibidos; }
    public void setReportesRecibidos(int reportesRecibidos) { this.reportesRecibidos = reportesRecibidos; }

    public String getAccionesTomadas() { return accionesTomadas; }
    public void setAccionesTomadas(String accionesTomadas) { this.accionesTomadas = accionesTomadas; }
}
