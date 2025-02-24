package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.Residuo;
import java.util.List;

public interface ResiduoDAO {
    boolean insertarResiduo(Residuo residuo);
    List<Residuo> obtenerResiduos();
    boolean actualizarResiduo(Residuo residuo);
    boolean eliminarResiduo(int idResiduo);
}
