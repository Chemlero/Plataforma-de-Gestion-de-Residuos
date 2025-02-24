package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.Recolector;
import java.util.List;

public interface RecolectorDAO {
    boolean insertarRecolector(Recolector recolector);
    List<Recolector> obtenerRecolectores();
    boolean actualizarRecolector(int idRecolector, double cantidadRecolectada, java.util.Date fechaUltimaActividad);
    boolean eliminarRecolector(int idRecolector);
}
