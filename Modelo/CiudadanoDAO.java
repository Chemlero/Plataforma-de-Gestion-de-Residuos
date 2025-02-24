package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.Ciudadano;
import java.util.List;

public interface CiudadanoDAO {
    boolean insertarCiudadano(Ciudadano ciudadano);
    List<Ciudadano> obtenerCiudadanos();
    boolean actualizarCiudadano(int dni, int cantidadReportesEnviados);
    boolean eliminarCiudadano(int dni);
}
