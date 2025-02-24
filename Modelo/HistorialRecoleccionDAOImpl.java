package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.HistorialRecoleccionDAO;
import com.mycompany.cleanzone.model.HistorialRecoleccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialRecoleccionDAOImpl implements HistorialRecoleccionDAO {
    private final Connection conexion;

    public HistorialRecoleccionDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarHistorial(HistorialRecoleccion historial) {
        String sql = "{call InsertarHistorialRecoleccion(?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, historial.getIdRecolector());
            stmt.setInt(2, historial.getIdVehiculo());
            stmt.setInt(3, historial.getCantidadRecolectada());
            stmt.setDate(4, new java.sql.Date(historial.getFechaRecoleccion().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar historial de recolección: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<HistorialRecoleccion> obtenerHistoriales() {
        List<HistorialRecoleccion> lista = new ArrayList<>();
        String sql = "{call ObtenerHistorialRecoleccion()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                HistorialRecoleccion historial = new HistorialRecoleccion(
                    rs.getInt("ID_Historial"),
                    rs.getInt("ID_Recolector"),
                    rs.getInt("ID_Vehiculo"),
                    rs.getInt("Cantidad_Recolectada"),
                    rs.getDate("Fecha_Recoleccion")
                );
                lista.add(historial);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener historial de recolección: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarHistorial(int idHistorial, int cantidadRecolectada) {
        String sql = "{call ActualizarHistorialRecoleccion(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idHistorial);
            stmt.setInt(2, cantidadRecolectada);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar historial de recolección: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarHistorial(int idHistorial) {
        String sql = "{call EliminarHistorialRecoleccion(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idHistorial);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar historial de recolección: " + e.getMessage());
            return false;
        }
    }
}
