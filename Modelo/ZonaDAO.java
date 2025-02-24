package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.Zona;
import java.util.List;

public interface ZonaDAO {
    boolean insertarZona(Zona zona);
    List<Zona> obtenerZonas();
    boolean actualizarZona(int codigoPostal, String frecuenciaRecoleccion, String nivelAcumulacionBasura);
    boolean eliminarZona(int codigoPostal);
}
