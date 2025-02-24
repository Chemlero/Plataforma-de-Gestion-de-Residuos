package com.mycompany.cleanzone.model;

public class Ciudadano {
    private int dni;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private String telefono;
    private int codigoPostal;
    private int cantidadReportesEnviados;

    // Constructor vacío
    public Ciudadano() {}

    // Constructor con parámetros
    public Ciudadano(int dni, String nombre, String apPaterno, String apMaterno, String email, String telefono, int codigoPostal, int cantidadReportesEnviados) {
        this.dni = dni;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.email = email;
        this.telefono = telefono;
        this.codigoPostal = codigoPostal;
        this.cantidadReportesEnviados = cantidadReportesEnviados;
    }

    // Getters y Setters
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApPaterno() { return apPaterno; }
    public void setApPaterno(String apPaterno) { this.apPaterno = apPaterno; }

    public String getApMaterno() { return apMaterno; }
    public void setApMaterno(String apMaterno) { this.apMaterno = apMaterno; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(int codigoPostal) { this.codigoPostal = codigoPostal; }

    public int getCantidadReportesEnviados() { return cantidadReportesEnviados; }
    public void setCantidadReportesEnviados(int cantidadReportesEnviados) { this.cantidadReportesEnviados = cantidadReportesEnviados; }
}
