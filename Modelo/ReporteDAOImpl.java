package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.ReporteDAO;
import com.mycompany.cleanzone.model.Reporte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAOImpl implements ReporteDAO {
    private final Connection conexion;

    public ReporteDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarReporte(Reporte reporte) {
        String sql = "{call InsertarReporte(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setTimestamp(1, new Timestamp(reporte.getFechaGeneracion().getTime()));
            stmt.setInt(2, reporte.getCodigoPostal());
            stmt.setDouble(3, reporte.getCantidadResiduos());
            stmt.setInt(4, reporte.getCantidadContenedoresLlenos());
            stmt.setString(5, reporte.getIncidenciasReportadas());
            stmt.setString(6, reporte.getEstadoEnvio());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar reporte: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Reporte> obtenerReportes() {
        List<Reporte> lista = new ArrayList<>();
        String sql = "{call ObtenerReporte()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Reporte reporte = new Reporte(
                    rs.getInt("ID_Reporte"),
                    rs.getDate("Fecha_Generacion"),
                    rs.getInt("Codigo_Postal"),
                    rs.getDouble("Cantidad_Residuos"),
                    rs.getInt("Cantidad_Contenedores_Llenos"),
                    rs.getString("Incidencias_Reportadas"),
                    rs.getString("Estado_Envio")
                );
                lista.add(reporte);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener reportes: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarReporte(int idReporte, String estadoEnvio) {
        String sql = "{call ActualizarReporte(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idReporte);
            stmt.setString(2, estadoEnvio);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar reporte: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarReporte(int idReporte) {
        String sql = "{call EliminarReporte(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idReporte);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar reporte: " + e.getMessage());
            return false;
        }
    }
}
