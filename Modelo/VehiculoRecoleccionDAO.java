package com.mycompany.cleanzone.dao;

import com.mycompany.cleanzone.model.VehiculoRecoleccion;
import java.util.List;

public interface VehiculoRecoleccionDAO {
    boolean insertarVehiculo(VehiculoRecoleccion vehiculo);
    List<VehiculoRecoleccion> obtenerVehiculos();
    boolean actualizarEstadoVehiculo(String placa, String estado);
    boolean eliminarVehiculo(String placa);
}
