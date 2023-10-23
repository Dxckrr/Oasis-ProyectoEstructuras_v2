package co.edu.upb.oasis.vistas;


/*import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;*/

import co.edu.upb.oasis.clases1.AlgoritmoDijkstra;
import co.edu.upb.oasis.clases1.DatosGraficos;
import javafx.event.ActionEvent;

public class StartDRaw<EleccionOrigen> extends JFrame {

    private int Numerotope = 0;//Numero de nodos 
    
    DatosGraficos arboles = new DatosGraficos();

    public static void PintarFiguras(int tope, DatosGraficos arboles) {//pinta lo q esta antes en el panel 
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if (arboles.getmAdyacencia(j, k) == 1) {
                    //DibGraficas.pinta_Linea(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k), arboles.getmCoeficiente(j, k));
                }
            }
        }
        for (int j = 0; j < tope; j++) {
            //DibGraficas.pinta_Circulo(Panel.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), arboles.getNombre(j));
            System.out.println("Las coordenadas son"+ tope);
        }

    }

    public StartDRaw() {
        initComponents();
       /* EleccionDestino.setEnabled(false);
        EleccionOrigen.setEnabled(false);
        BuscarCamino.setEnabled(false);*/
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        /*MostrarCaminos = new JButton();
        jPanel1 = new JPanel();
        colorOrigen = new JLabel();
        txtColorOrigen = new JLabel();
        colorDestino = new JLabel();
        txtColorDestino = new JLabel();
        colorNodoVisitado = new JLabel();
        txtColorNodoRecorrido = new JLabel();
        BotonSalir = new JButton();
        ImgMapa = new JLabel();
        EleccionDestino = new JComboBox<>();
        BuscarCamino = new JButton();
        EleccionOrigen = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        txtKMAcumulados = new JTextArea();
        txtDestino = new JLabel();
        kmRecorridos = new JLabel();
        txtOrigen = new JLabel();
        kmRecorridos1 = new JLabel();
        LateralSuperior = new JLabel();
        LateralSuperior1 = new JLabel();
        LateralSuperior2 = new JLabel();
        kmRecorridos2 = new JLabel();
        Fondo = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.BorderLayout());

        MostrarCaminos.setBackground(new java.awt.Color(255, 255, 204));
        MostrarCaminos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MostrarCaminos.setForeground(new java.awt.Color(0, 0, 204));
        MostrarCaminos.setText("Mostrar Caminos");
        MostrarCaminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarCaminosActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarCaminos, new AbsoluteConstraints(150, 40, 220, 50));

        jPanel1.setBackground(new Color(255, 255, 102));
        jPanel1.setLayout(null);

        colorOrigen.setBackground(new Color(255, 0, 0));
        colorOrigen.setOpaque(true);
        jPanel1.add(colorOrigen);
        colorOrigen.setBounds(210, 20, 20, 20);

        txtColorOrigen.setBackground(new Color(255, 255, 102));
        txtColorOrigen.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtColorOrigen.setForeground(new Color(51, 0, 204));
        txtColorOrigen.setText("Origen--------------->");
        txtColorOrigen.setOpaque(true);
        jPanel1.add(txtColorOrigen);
        txtColorOrigen.setBounds(50, 0, 190, 40);

        colorDestino.setBackground(new java.awt.Color(51, 255, 51));
        colorDestino.setOpaque(true);
        jPanel1.add(colorDestino);
        colorDestino.setBounds(210, 50, 20, 20);

        txtColorDestino.setBackground(new Color(255, 255, 102));
        txtColorDestino.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtColorDestino.setForeground(new Color(51, 0, 204));
        txtColorDestino.setText("Destino-------------->");
        txtColorDestino.setOpaque(true);
        jPanel1.add(txtColorDestino);
        txtColorDestino.setBounds(50, 40, 190, 30);

        colorNodoVisitado.setBackground(new Color(0, 51, 255));
        colorNodoVisitado.setOpaque(true);
        jPanel1.add(colorNodoVisitado);
        colorNodoVisitado.setBounds(210, 80, 20, 20);

        txtColorNodoRecorrido.setBackground(new Color(255, 255, 102));
        txtColorNodoRecorrido.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtColorNodoRecorrido.setForeground(new Color(51, 0, 204));
        txtColorNodoRecorrido.setText("Nodo Recorrido ---->");
        txtColorNodoRecorrido.setOpaque(true);
        jPanel1.add(txtColorNodoRecorrido);
        txtColorNodoRecorrido.setBounds(50, 70, 190, 40);

        BotonSalir.setBackground(new Color(255, 51, 51));
        BotonSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
        BotonSalir.setForeground(new Color(255, 255, 255));
        BotonSalir.setText("X");
        BotonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BotonSalir);
        BotonSalir.setBounds(770, 10, 50, 50);


        ImgMapa.setIcon(new ImageIcon(getClass().getResource("/img/mapa.jpeg")));
        jPanel1.add(ImgMapa);
        ImgMapa.setBounds(52, 5, ImgMapa.getIcon().getIconWidth(), ImgMapa.getIcon().getIconHeight());

        EleccionDestino.setBackground(new Color(0, 153, 51));
        EleccionDestino.setFont(new Font("Tahoma", Font.BOLD, 18));
        EleccionDestino.setForeground(new Color(0, 0, 153));
        EleccionDestino.setModel(new DefaultComboBoxModel<>(new String[] { "Provenza", "Cabecera del Llano", "San Alonso", "La Ciudadela", "Lagos del Cacique", "San Francisco", "La Joya", "Cañaveral", "Ciudad Valencia" , "Lagos del Cacique", "Girardot","San Alonso","El Bosque","Los Cámbulos","Los Cambulos","Junin","Ciudadela Comfenalco","La Salle","Centro","San Francisco","La Feria","Altos de Granada" }));
        EleccionDestino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EleccionDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(EleccionDestino);
        EleccionDestino.setBounds(50, 260, 460, 50);

        BuscarCamino.setBackground(new Color(0, 153, 51));
        BuscarCamino.setFont(new Font("Tahoma", Font.BOLD, 18));
        BuscarCamino.setForeground(new Color(51, 0, 204));
        BuscarCamino.setText("Buscar Camino mas corto");
        BuscarCamino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BuscarCaminoActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarCamino);
        BuscarCamino.setBounds(140, 350, 300, 60);

        EleccionOrigen.setBackground(new Color(0, 153, 51));
        EleccionOrigen.setFont(new Font("Tahoma", Font.BOLD, 18));
        EleccionOrigen.setForeground(new Color(0, 0, 153));
        EleccionOrigen.setModel(new DefaultComboBoxModel<>(new String[] { "Alta Verapaz", "Baja Verapaz", "Chimaltenango", "Chiquimula", "Petén", "El Progreso", "Quiché", "Escuintla", "Guatemala", "Huehuetenango", "Izabal", "Jalapa", "Jutiapa", "Quetzaltenango", "Retalhuleu", "Sacatepéquez", "San Marcos", "Santa Rosa", "Sololá", "Suchitepéquez", "Totonicapán", "Zacapa" }));
        EleccionOrigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EleccionOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(EleccionOrigen);
        EleccionOrigen.setBounds(50, 140, 460, 50);

        txtKMAcumulados.setColumns(20);
        txtKMAcumulados.setRows(5);
        JScrollPane jScrollPane1 = new JScrollPane(txtKMAcumulados);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 630, 510, 70);

        JLabel txtDestino = new JLabel();
        txtDestino.setFont(new Font("Tahoma", Font.BOLD, 24));
        txtDestino.setForeground(Color.WHITE);
        txtDestino.setText("Selecciona el destino:");
        getContentPane().add(txtDestino);
        txtDestino.setBounds(150, 210, 260, 40);

        kmRecorridos.setBackground(new java.awt.Color(255, 255, 102));
        kmRecorridos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kmRecorridos.setForeground(new java.awt.Color(0, 0, 153));
        kmRecorridos.setOpaque(true);
        getContentPane().add(kmRecorridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 390, 40));

        JLabel kmRecorridos = new JLabel();
        kmRecorridos.setBackground(new Color(255, 255, 102));
        kmRecorridos.setFont(new Font("Tahoma", Font.BOLD, 18));
        kmRecorridos.setForeground(new Color(0, 0, 153));
        kmRecorridos.setOpaque(true);
        getContentPane().add(kmRecorridos);
        kmRecorridos.setBounds(150, 460, 390, 40);

        JLabel kmRecorridos1 = new JLabel();
        kmRecorridos1.setBackground(new Color(255, 255, 102));
        kmRecorridos1.setFont(new Font("Tahoma", Font.BOLD, 18));
        kmRecorridos1.setForeground(new Color(0, 0, 153));
        kmRecorridos1.setOpaque(true);
        getContentPane().add(kmRecorridos1);
        kmRecorridos1.setBounds(40, 460, 140, 40);

        JLabel LateralSuperior = new JLabel();
        LateralSuperior.setBackground(new Color(255, 255, 102));
        LateralSuperior.setFont(new Font("Tahoma", Font.BOLD, 18));
        LateralSuperior.setForeground(new Color(0, 0, 153));
        LateralSuperior.setOpaque(true);
        getContentPane().add(LateralSuperior);
        LateralSuperior.setBounds(0, 0, 40, 730);


        JLabel LateralSuperior1 = new JLabel();
        LateralSuperior1.setBackground(new Color(255, 255, 102));
        LateralSuperior1.setFont(new Font("Tahoma", Font.BOLD, 18));
        LateralSuperior1.setForeground(new Color(0, 0, 153));
        LateralSuperior1.setOpaque(true);
        getContentPane().add(LateralSuperior1);
        LateralSuperior1.setBounds(30, 700, 560, 30);
        
        JLabel LateralSuperior2 = new JLabel("                            Bienvenido al sistema");
        LateralSuperior2.setBackground(new Color(255, 255, 102));
        LateralSuperior2.setFont(new Font("Tahoma", Font.BOLD, 18));
        LateralSuperior2.setForeground(new Color(0, 0, 153));
        LateralSuperior2.setOpaque(true);
        getContentPane().add(LateralSuperior2);
        LateralSuperior2.setBounds(10, 0, 530, 30);


        JLabel kmRecorridos2 = new JLabel("                         Kilometros recorridos:");
        kmRecorridos2.setBackground(new Color(255, 255, 102));
        kmRecorridos2.setFont(new Font("Tahoma", Font.BOLD, 18));
        kmRecorridos2.setForeground(new Color(0, 0, 153));
        kmRecorridos2.setOpaque(true);
        getContentPane().add(kmRecorridos2);
        kmRecorridos2.setBounds(30, 430, 510, 30);
        
        JLabel Fondo = new JLabel();
        Fondo.setBackground(new Color(255, 255, 153));
        Fondo.setFont(new Font("Tahoma", Font.BOLD, 18));
        Fondo.setIcon(new ImageIcon(getClass().getResource("/img/fondo.jpg")));
        Fondo.setOpaque(true);
        getContentPane().add(Fondo);
        Fondo.setBounds(0, 0, 540, 730);

        pack(); 
        setLocationRelativeTo(null); 
        setVisible(true);*/
    }                      

    private void MostrarCaminosActionPerformed(ActionEvent evt) {                                               
        //EleccionOrigen.setEnabled(true);
        //MostrarCaminos.setEnabled(false);
       // MostrarCaminos.setVisible(false);
        //txtKMAcumulados.setEnabled(false);

        //jPanel1.paint(jPanel1.getGraphics());
        
        int Matriz[][] = {
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        double coe[][] = {
            {0, 57.4, 0, 0, 147, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {57.4, 0, 0, 0, 0, 69.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 55.6, 0, 0, 0, 0, 0, 0, 26.4, 0, 0, 85.1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71.8, 0, 0, 0, 0, 0, 0, 0, 0, 26},
            {147, 0, 0, 0, 0, 0, 0, 0, 0, 0, 327.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 69.1, 0, 0, 0, 0, 0, 0, 93.3, 0, 0, 86.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 71.3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 158, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 61.7, 0, 0, 0, 0, 0, 0, 42.7, 0, 85.5, 0, 95.3, 0, 0},
            {0, 0, 55.6, 0, 0, 93.3, 0, 61.7, 0, 0, 0, 0, 0, 0, 0, 45.7, 0, 82.3, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 109, 0, 0, 0, 86, 0},
            {0, 0, 0, 0, 327.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 116.7},
            {0, 0, 0, 0, 0, 86.5, 0, 0, 0, 0, 0, 0, 56.1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 71.8, 0, 0, 0, 0, 0, 0, 0, 56.1, 0, 0, 0, 0, 0, 70.5, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86.9, 0, 50.6, 0, 76.3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86.9, 0, 0, 0, 0, 0, 54.9, 0, 0},
            {0, 0, 26, 0, 0, 0, 0, 42.7, 45.7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 109, 0, 0, 0, 50.6, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 85.5, 82.3, 0, 0, 0, 70.5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 85.1, 0, 0, 0, 158, 0, 0, 0, 0, 0, 0, 76.3, 0, 0, 0, 0, 0, 0, 53.7, 0},
            {0, 0, 0, 0, 0, 0, 0, 95.3, 0, 0, 0, 0, 0, 0, 54.9, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 0, 0, 0, 0, 0, 0, 0, 0, 53.7, 0, 0, 0},
            {0, 0, 0, 26, 0, 71.3, 0, 0, 0, 0, 116.7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

        int xx1[] = {425, 375, 280, 540, 440, 425, 275, 260, 350, 170, 600, 450, 470, 160, 140, 315, 110, 375, 220, 190, 200, 525, 400};
        int yy1[] = {405, 485, 540, 550, 185, 530, 430, 630, 550, 370, 425, 550, 615, 520, 585, 565, 480, 630, 535, 605, 510, 485, 400};
        String nom[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"};
      
        for (int j = 0; j < 22; j++) {
            arboles.setCordeX(j, xx1[j]);
            arboles.setCordeY(j, yy1[j]);
            arboles.setNombre(j, nom[j]);

        }
        for (int j = 0; j < 22; j++) {
            for (int k = 0; k < 22; k++) {
                arboles.setmAdyacencia(j, k, Matriz[j][k]);
                arboles.setmCoeficiente(j, k, coe[j][k]);
            }
        }
        Numerotope = 22;
        PintarFiguras(Numerotope, arboles);
    }                                              

    private void EleccionDestinoActionPerformed(ActionEvent evt) {                                                
        //BuscarCamino.setEnabled(true);
    }                                               

    private void EleccionOrigenActionPerformed(ActionEvent evt) {                                               
        //EleccionDestino.setEnabled(true);
    }                                              

    private <JTextArea> void BuscarCaminoActionPerformed(ActionEvent evt) {                                             
        int origen = 0, destino = 0;
        String nombreOrigen, nombreDestino;
        //nombreOrigen = (String) EleccionOrigen.getSelectedItem();
        //nombreDestino = (String) EleccionDestino.getSelectedItem();

        /*if ("Provenza".equals(nombreOrigen)) {
            origen = 0;
        }
        if ("Cabecera del Llano".equals(nombreOrigen)) {
            origen = 1;
        }
        if ("San Alonso".equals(nombreOrigen)) {
            origen = 2;
        }
        if ("La Ciudadela".equals(nombreOrigen)) {
            origen = 3;
        }
        if ("Lagos del Cacique".equals(nombreOrigen)) {
            origen = 4;
        }
        if ("San Francisco".equals(nombreOrigen)) {
            origen = 5;
        }
        if ("La Joya".equals(nombreOrigen)) {
            origen = 6;
        }
        if ("Cañaveral".equals(nombreOrigen)) {
            origen = 7;
        }
        if ("Ciudad Valencia".equals(nombreOrigen)) {
            origen = 8;
        }
        if ("Lagos del Cacique".equals(nombreOrigen)) {
            origen = 9;
        }
        if ("Girardot".equals(nombreOrigen)) {
            origen = 10;
        }
        if ("San Alonso".equals(nombreOrigen)) {
            origen = 11;
        }
        if ("El Bosque".equals(nombreOrigen)) {
            origen = 12;
        }
        if ("Los Cámbulos".equals(nombreOrigen)) {
            origen = 13;
        }
        if ("Los Cambulos".equals(nombreOrigen)) {
            origen = 14;
        }
        if ("Junin".equals(nombreOrigen)) {
            origen = 15;
        }
        if ("Ciudadela Comfenalco".equals(nombreOrigen)) {
            origen = 16;
        }
        if ("La Salle".equals(nombreOrigen)) {
            origen = 17;
        }
        if ("Centro".equals(nombreOrigen)) {
            origen = 18;
        }
        if ("San Francisco".equals(nombreOrigen)) {
            origen = 19;
        }
        if ("La Feria".equals(nombreOrigen)) {
            origen = 20;
        }
        if ("Altos de Granada".equals(nombreOrigen)) {
            origen = 21;
        }

        if ("Provenza".equals(nombreDestino)) {
            destino = 0;
        }
        if ("Cabecera del Llano".equals(nombreDestino)) {
            destino = 1;
        }
        if ("San Alonso".equals(nombreDestino)) {
            destino = 2;
        }
        if ("La Ciudadela".equals(nombreDestino)) {
            destino = 3;
        }
        if ("Lagos del Cacique".equals(nombreDestino)) {
            destino = 4;
        }
        if ("San Francisco".equals(nombreDestino)) {
            destino = 5;
        }
        if ("La Joya".equals(nombreDestino)) {
            destino = 6;
        }
        if ("Cañaveral".equals(nombreDestino)) {
            destino = 7;
        }
        if ("Ciudad Valencia".equals(nombreDestino)) {
            destino = 8;
        }
        if ("Lagos del Cacique".equals(nombreDestino)) {
            destino = 9;
        }
        if ("Girardot".equals(nombreDestino)) {
            destino = 10;
        }
        if ("San Alonso".equals(nombreDestino)) {
            destino = 11;
        }
        if ("El Bosque".equals(nombreDestino)) {
            destino = 12;
        }
        if ("Los Cámbulos".equals(nombreDestino)) {
            destino = 13;
        }
        if ("Los Cámbulos".equals(nombreDestino)) {
            destino = 14;
        }
        if ("Junin".equals(nombreDestino)) {
            destino = 15;
        }
        if ("Ciudadela Comfenalco".equals(nombreDestino)) {
            destino = 16;
        }
        if ("La Salle".equals(nombreDestino)) {
            destino = 17;
        }
        if ("Centro".equals(nombreDestino)) {
            destino = 18;
        }
        if ("San Francisco".equals(nombreDestino)) {
            destino = 19;
        }
        if ("La Feria".equals(nombreDestino)) {
            destino = 20;
        }
        if ("Altos de Granada".equals(nombreDestino)) {
            destino = 21;
        }

        if (origen == destino) {
            //Font fuente = new Font("Arial", Font.BOLD, 18);
            //txtKMAcumulados.setFont(fuente);
            //JOptionPane.showMessageDialog(null, "Estas en:" + nombreOrigen);
            //txtKMAcumulados.setText("Intenta de nuevo!!");
            //txtKMAcumulados.setEnabled(false);
            //txtKMAcumulados.setForeground(Color.RED);

        } else {
            AlgoritmoDijkstra Dijkstra = new AlgoritmoDijkstra(arboles, Numerotope, origen, destino);
            Dijkstra.dijkstra();

            
            //Font fuente = new Font(/* "Arial", //Font.BOLD, 18)*///);
            /*txtKMAcumulados.setFont(fuente);
            txtKMAcumulados.setText("No hay ningun error :)");
            txtKMAcumulados.setForeground(Color.BLUE);
            txtKMAcumulados.setEnabled(false);
            
            kmRecorridos.setText(Dijkstra.getAcumulado() + " KM");*/
        //}


    }                                            

    private void BotonSalirActionPerformed(ActionEvent evt) {                                           
        System.exit(0); 
    }                                          

   /*public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartDRaw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }*/
                  
    /*private JButton BotonSalir;
    private JButton BuscarCamino;
    private JComboBox<String> EleccionDestino;
    private JComboBox<String> EleccionOrigen;
    private JLabel Fondo;
    private JLabel ImgMapa;
    private JLabel LateralSuperior;
    private JLabel LateralSuperior1;
    private JLabel LateralSuperior2;
    private JButton MostrarCaminos;
    private JLabel colorDestino;
    private JLabel colorNodoVisitado;
    private JLabel colorOrigen;
    public static JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel kmRecorridos;
    private JLabel kmRecorridos1;
    private JLabel kmRecorridos2;
    private JLabel txtColorDestino;
    private JLabel txtColorNodoRecorrido;
    private JLabel txtColorOrigen;
    private JLabel txtDestino;
    private JTextArea txtKMAcumulados;
    private JLabel txtOrigen;         */       
}

