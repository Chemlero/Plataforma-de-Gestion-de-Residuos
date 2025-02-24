package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.Reporte;
import java.util.List;

public interface ReporteDAO {
    boolean insertarReporte(Reporte reporte);
    List<Reporte> obtenerReportes();
    boolean actualizarReporte(int idReporte, String estadoEnvio);
    boolean eliminarReporte(int idReporte);
}
