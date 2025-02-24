package com.mycompany.cleanzone.dao.impl;

import com.mycompany.cleanzone.dao.ResiduoDAO;
import com.mycompany.cleanzone.model.Residuo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResiduoDAOImpl implements ResiduoDAO {
    private final Connection conexion;

    public ResiduoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarResiduo(Residuo residuo) {
        String sql = "{CALL InsertarResiduo(?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setString(1, residuo.getTipo());
            stmt.setDouble(2, residuo.getPeso());
            stmt.setDate(3, new java.sql.Date(residuo.getFechaRecoleccion().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar residuo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Residuo> obtenerResiduos() {
        List<Residuo> residuos = new ArrayList<>();
        String sql = "{CALL ObtenerResiduos()}";
        try (CallableStatement stmt = conexion.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Residuo residuo = new Residuo(
                    rs.getInt("ID_Residuo"),
                    rs.getString("Tipo"),
                    rs.getDouble("Peso"),
                    rs.getDate("Fecha_Recoleccion")
                );
                residuos.add(residuo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener residuos: " + e.getMessage());
        }
        return residuos;
    }

    @Override
    public boolean actualizarResiduo(Residuo residuo) {
        String sql = "{CALL ActualizarResiduo(?, ?, ?, ?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, residuo.getIdResiduo());
            stmt.setString(2, residuo.getTipo());
            stmt.setDouble(3, residuo.getPeso());
            stmt.setDate(4, new java.sql.Date(residuo.getFechaRecoleccion().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar residuo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarResiduo(int idResiduo) {
        String sql = "{CALL EliminarResiduo(?)}";
        try (CallableStatement stmt = conexion.prepareCall(sql)) {
            stmt.setInt(1, idResiduo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar residuo: " + e.getMessage());
            return false;
        }
    }
}
