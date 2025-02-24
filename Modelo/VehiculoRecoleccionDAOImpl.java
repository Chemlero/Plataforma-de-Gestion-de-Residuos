package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.VehiculoRecoleccionDAO;
import com.mycompany.cleanzone.model.VehiculoRecoleccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoRecoleccionDAOImpl implements VehiculoRecoleccionDAO {
    private final Connection conexion;

    public VehiculoRecoleccionDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarVehiculo(VehiculoRecoleccion vehiculo) {
        String sql = "{call InsertarVehiculoRecoleccion(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, vehiculo.getPlaca());
            stmt.setString(2, vehiculo.getTipoVehiculo());
            stmt.setDouble(3, vehiculo.getCapacidadCarga());
            stmt.setInt(4, vehiculo.getCodigoPostal());
            stmt.setDate(5, new java.sql.Date(vehiculo.getUltimoMantenimiento().getTime()));
            stmt.setString(6, vehiculo.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar vehículo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<VehiculoRecoleccion> obtenerVehiculos() {
        List<VehiculoRecoleccion> lista = new ArrayList<>();
        String sql = "{call ObtenerVehiculoRecoleccion()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                VehiculoRecoleccion vehiculo = new VehiculoRecoleccion(
                    rs.getString("Placa"),
                    rs.getString("Tipo_Vehiculo"),
                    rs.getDouble("Capacidad_Carga"),
                    rs.getInt("Codigo_Postal"),
                    rs.getDate("Ultimo_Mantenimiento"),
                    rs.getString("Estado")
                );
                lista.add(vehiculo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener vehículos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarEstadoVehiculo(String placa, String estado) {
        String sql = "{call ActualizarVehiculoRecoleccion(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, placa);
            stmt.setString(2, estado);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar estado del vehículo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarVehiculo(String placa) {
        String sql = "{call EliminarVehiculoRecoleccion(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, placa);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar vehículo: " + e.getMessage());
            return false;
        }
    }
}
