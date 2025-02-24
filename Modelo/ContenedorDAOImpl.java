package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.ContenedorDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContenedorDAOImpl implements ContenedorDAO {
    private Connection conexion;

    public ContenedorDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public ResultSet obtenerContenedores() {
        try {
            CallableStatement stmt = conexion.prepareCall("{call ObtenerContenedores}");
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error al obtener contenedores: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertarContenedor(String id, String ubicacion, String estado, double capacidadTotal, double capacidadActual, String fechaRecoleccion, String tipoResiduos) {
        try {
            CallableStatement stmt = conexion.prepareCall("{call InsertarContenedor(?, ?, ?, ?, ?, ?, ?)}");
            stmt.setString(1, id);
            stmt.setString(2, ubicacion);
            stmt.setString(3, estado);
            stmt.setDouble(4, capacidadTotal);
            stmt.setDouble(5, capacidadActual);
            stmt.setString(6, fechaRecoleccion);
            stmt.setString(7, tipoResiduos);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar contenedor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarContenedor(String id, String estado, double capacidadActual) {
        try {
            CallableStatement stmt = conexion.prepareCall("{call ActualizarContenedor(?, ?, ?)}");
            stmt.setString(1, id);
            stmt.setString(2, estado);
            stmt.setDouble(3, capacidadActual);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar contenedor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarContenedor(String id) {
        try {
            CallableStatement stmt = conexion.prepareCall("{call EliminarContenedor(?)}");
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar contenedor: " + e.getMessage());
            return false;
        }
    }
}
