package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.model.Autoridad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.cleanzone.dao.AutoridadDAO;

public class AutoridadDAOImpl implements AutoridadDAO {
    private final Connection conexion;

    public AutoridadDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarAutoridad(Autoridad autoridad) {
        String sql = "{call InsertarAutoridad(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, autoridad.getNombre());
            stmt.setString(2, autoridad.getInstitucion());
            stmt.setString(3, autoridad.getCorreo());
            stmt.setString(4, autoridad.getTelefono());
            stmt.setInt(5, autoridad.getReportesRecibidos());
            stmt.setString(6, autoridad.getAccionesTomadas());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar autoridad: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Autoridad> obtenerAutoridades() {
        List<Autoridad> lista = new ArrayList<>();
        String sql = "{call ObtenerAutoridades()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Autoridad autoridad = new Autoridad(
                    rs.getInt("ID_Autoridad"),
                    rs.getString("Nombre"),
                    rs.getString("Institución"),
                    rs.getString("Correo"),
                    rs.getString("Teléfono"),
                    rs.getInt("Reportes_Recibidos"),
                    rs.getString("Acciones_Tomadas")
                );
                lista.add(autoridad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener autoridades: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarAutoridad(int idAutoridad, int reportesRecibidos, String accionesTomadas) {
        String sql = "{call ActualizarAutoridad(?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idAutoridad);
            stmt.setInt(2, reportesRecibidos);
            stmt.setString(3, accionesTomadas);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar autoridad: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarAutoridad(int idAutoridad) {
        String sql = "{call EliminarAutoridad(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idAutoridad);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar autoridad: " + e.getMessage());
            return false;
        }
    }
}
