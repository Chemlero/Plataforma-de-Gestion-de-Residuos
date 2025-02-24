package com.mycompany.cleanzone.dao;

import java.sql.ResultSet;

public interface ContenedorDAO {
    ResultSet obtenerContenedores();
    boolean insertarContenedor(String id, String ubicacion, String estado, double capacidadTotal, double capacidadActual, String fechaRecoleccion, String tipoResiduos);
    boolean actualizarContenedor(String id, String estado, double capacidadActual);
    boolean eliminarContenedor(String id);
}