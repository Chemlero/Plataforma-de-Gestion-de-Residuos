package com.mycompany.cleanzone.model;

import java.util.Date;

public class VehiculoRecoleccion {
    private String placa;
    private String tipoVehiculo;
    private double capacidadCarga;
    private int codigoPostal;
    private Date ultimoMantenimiento;
    private String estado;

    // Constructor vacío
    public VehiculoRecoleccion() {}

    // Constructor con parámetros
    public VehiculoRecoleccion(String placa, String tipoVehiculo, double capacidadCarga, int codigoPostal, Date ultimoMantenimiento, String estado) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.capacidadCarga = capacidadCarga;
        this.codigoPostal = codigoPostal;
        this.ultimoMantenimiento = ultimoMantenimiento;
        this.estado = estado;
    }

    // Getters y Setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }

    public int getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(int codigoPostal) { this.codigoPostal = codigoPostal; }

    public Date getUltimoMantenimiento() { return ultimoMantenimiento; }
    public void setUltimoMantenimiento(Date ultimoMantenimiento) { this.ultimoMantenimiento = ultimoMantenimiento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
