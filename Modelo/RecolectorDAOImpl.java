package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.RecolectorDAO;
import com.mycompany.cleanzone.model.Recolector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecolectorDAOImpl implements RecolectorDAO {
    private final Connection conexion;

    public RecolectorDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarRecolector(Recolector recolector) {
        String sql = "{call InsertarRecolector(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, recolector.getNombre());
            stmt.setInt(2, recolector.getCodigoPostal());
            stmt.setString(3, recolector.getTurno());
            stmt.setDouble(4, recolector.getCantidadRecolectada());
            stmt.setString(5, recolector.getVehiculoAsignado());
            stmt.setDate(6, new java.sql.Date(recolector.getFechaUltimaActividad().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar recolector: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Recolector> obtenerRecolectores() {
        List<Recolector> lista = new ArrayList<>();
        String sql = "{call ObtenerRecolector()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Recolector recolector = new Recolector(
                    rs.getInt("ID_Recolector"),
                    rs.getString("Nombre"),
                    rs.getInt("Codigo_Postal"),
                    rs.getString("Turno"),
                    rs.getDouble("Cantidad_Recolectada"),
                    rs.getString("Vehiculo_Asignado"),
                    rs.getDate("Fecha_Ultima_Actividad")
                );
                lista.add(recolector);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener recolectores: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarRecolector(int idRecolector, double cantidadRecolectada, java.util.Date fechaUltimaActividad) {
        String sql = "{call ActualizarRecolector(?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idRecolector);
            stmt.setDouble(2, cantidadRecolectada);
            stmt.setDate(3, new java.sql.Date(fechaUltimaActividad.getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar recolector: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarRecolector(int idRecolector) {
        String sql = "{call EliminarRecolector(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idRecolector);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar recolector: " + e.getMessage());
            return false;
        }
    }
}
