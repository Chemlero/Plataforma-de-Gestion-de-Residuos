package com.mycompany.cleanzone;

import com.mycompany.cleanzone.Vista.Inicio;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la interfaz de "Inicio" en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }
}
