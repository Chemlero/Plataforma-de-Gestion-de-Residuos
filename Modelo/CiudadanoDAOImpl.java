package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.CiudadanoDAO;
import com.mycompany.cleanzone.model.Ciudadano;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadanoDAOImpl implements CiudadanoDAO {
    private final Connection conexion;

    public CiudadanoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarCiudadano(Ciudadano ciudadano) {
        String sql = "{call InsertarCiudadano(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, ciudadano.getDni());
            stmt.setString(2, ciudadano.getNombre());
            stmt.setString(3, ciudadano.getApPaterno());
            stmt.setString(4, ciudadano.getApMaterno());
            stmt.setString(5, ciudadano.getEmail());
            stmt.setString(6, ciudadano.getTelefono());
            stmt.setInt(7, ciudadano.getCodigoPostal());
            stmt.setInt(8, ciudadano.getCantidadReportesEnviados());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar ciudadano: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Ciudadano> obtenerCiudadanos() {
        List<Ciudadano> lista = new ArrayList<>();
        String sql = "{call ObtenerCiudadano()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ciudadano ciudadano = new Ciudadano(
                    rs.getInt("Dni"),
                    rs.getString("Nombre"),
                    rs.getString("ApPaterno"),
                    rs.getString("ApMaterno"),
                    rs.getString("Email"),
                    rs.getString("Telefono"),
                    rs.getInt("Codigo_Postal"),
                    rs.getInt("Cantidad_Reportes_Enviados")
                );
                lista.add(ciudadano);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ciudadanos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarCiudadano(int dni, int cantidadReportesEnviados) {
        String sql = "{call ActualizarCiudadano(?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, dni);
            stmt.setInt(2, cantidadReportesEnviados);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar ciudadano: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCiudadano(int dni) {
        String sql = "{call EliminarCiudadano(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, dni);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar ciudadano: " + e.getMessage());
            return false;
        }
    }
}
