package co.edu.upb.oasis.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaXD {

    public VistaXD(){
                // Crear una ventana
        JFrame frame = new JFrame("Estado del Servidor");

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear una etiqueta con el mensaje
        JLabel label = new JLabel("El servidor está en línea.");

        // Agregar la etiqueta al panel
        panel.add(label);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Configurar el tamaño de la ventana
        frame.setSize(300, 100);

        // Hacer que la ventana se cierre al hacer clic en la 'X'
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
    
