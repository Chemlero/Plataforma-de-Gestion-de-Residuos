package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.HistorialRecoleccion;
import java.util.List;

public interface HistorialRecoleccionDAO {
    boolean insertarHistorial(HistorialRecoleccion historial);
    List<HistorialRecoleccion> obtenerHistoriales();
    boolean actualizarHistorial(int idHistorial, int cantidadRecolectada);
    boolean eliminarHistorial(int idHistorial);
}
