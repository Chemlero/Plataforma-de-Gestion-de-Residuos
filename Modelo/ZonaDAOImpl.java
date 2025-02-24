package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.ZonaDAO;
import com.mycompany.cleanzone.model.Zona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZonaDAOImpl implements ZonaDAO {
    private final Connection conexion;

    public ZonaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarZona(Zona zona) {
        String sql = "{call InsertarZona(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, zona.getNombreZona());
            stmt.setInt(2, zona.getCantidadContenedores());
            stmt.setString(3, zona.getNivelAcumulacionBasura());
            stmt.setString(4, zona.getFrecuenciaRecoleccion());
            stmt.setString(5, zona.getTipoProblema());
            stmt.setDate(6, new java.sql.Date(zona.getFechaUltimaActualizacion().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar zona: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Zona> obtenerZonas() {
        List<Zona> lista = new ArrayList<>();
        String sql = "{call ObtenerZonas()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Zona zona = new Zona(
                    rs.getInt("Codigo_Postal"),
                    rs.getString("Nombre_Zona"),
                    rs.getInt("Cantidad_Contenedores"),
                    rs.getString("Nivel_Acumulación_Basura"),
                    rs.getString("Frecuencia_Recolección"),
                    rs.getString("Tipo_Problema"),
                    rs.getDate("Fecha_Ultima_Actualización")
                );
                lista.add(zona);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener zonas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarZona(int codigoPostal, String frecuenciaRecoleccion, String nivelAcumulacionBasura) {
        String sql = "{call ActualizarZona(?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, codigoPostal);
            stmt.setString(2, frecuenciaRecoleccion);
            stmt.setString(3, nivelAcumulacionBasura);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar zona: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarZona(int codigoPostal) {
        String sql = "{call EliminarZona(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, codigoPostal);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar zona: " + e.getMessage());
            return false;
        }
    }
}
