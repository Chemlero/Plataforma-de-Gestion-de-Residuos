package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.Autoridad;
import java.util.List;

public interface AutoridadDAO {
    boolean insertarAutoridad(Autoridad autoridad);
    List<Autoridad> obtenerAutoridades();
    boolean actualizarAutoridad(int idAutoridad, int reportesRecibidos, String accionesTomadas);
    boolean eliminarAutoridad(int idAutoridad);
}
