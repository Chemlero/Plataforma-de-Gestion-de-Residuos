package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.RutaRecoleccionDAO;
import com.mycompany.cleanzone.model.RutaRecoleccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RutaRecoleccionDAOImpl implements RutaRecoleccionDAO {
    private final Connection conexion;

    public RutaRecoleccionDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarRutaRecoleccion(RutaRecoleccion ruta) {
        String sql = "{call InsertarRutaRecoleccion(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, ruta.getNombreRuta());
            stmt.setInt(2, ruta.getIdRecolector());
            stmt.setInt(3, ruta.getIdVehiculo());
            stmt.setDate(4, new java.sql.Date(ruta.getFechaUltimaRecoleccion().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar ruta de recolección: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<RutaRecoleccion> obtenerRutasRecoleccion() {
        List<RutaRecoleccion> lista = new ArrayList<>();
        String sql = "{call ObtenerRutaRecoleccion()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RutaRecoleccion ruta = new RutaRecoleccion(
                    rs.getInt("ID_Ruta"),
                    rs.getString("Nombre_Ruta"),
                    rs.getInt("ID_Recolector"),
                    rs.getInt("ID_Vehiculo"),
                    rs.getDate("Fecha_Ultima_Recoleccion")
                );
                lista.add(ruta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener rutas de recolección: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarRutaRecoleccion(int idRuta, String nombreRuta) {
        String sql = "{call ActualizarRutaRecoleccion(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idRuta);
            stmt.setString(2, nombreRuta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar ruta de recolección: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarRutaRecoleccion(int idRuta) {
        String sql = "{call EliminarRutaRecoleccion(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idRuta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar ruta de recolección: " + e.getMessage());
            return false;
        }
    }
}
