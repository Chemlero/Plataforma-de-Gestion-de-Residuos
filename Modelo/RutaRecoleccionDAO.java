package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.RutaRecoleccion;
import java.util.List;

public interface RutaRecoleccionDAO {
    boolean insertarRutaRecoleccion(RutaRecoleccion ruta);
    List<RutaRecoleccion> obtenerRutasRecoleccion();
    boolean actualizarRutaRecoleccion(int idRuta, String nombreRuta);
    boolean eliminarRutaRecoleccion(int idRuta);
}
