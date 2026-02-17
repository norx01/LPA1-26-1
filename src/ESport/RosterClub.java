package ESport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RosterClub {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JSpinner spinner1;
    private JSlider slider1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JButton guardarJugadorButton;
    private JTable tblJugadores;
    private JButton actualizarJugadorButton;
    private JSlider slider2;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JSpinner spinner6;
    private DefaultTableModel modelo;


    List<Jugador> jugadorList = new ArrayList<>();

    public RosterClub()
    {
        inicializarTabla();

        guardarJugadorButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                agregarJugador();
                refrescarTabla();
            }
        });
    }

    private void inicializarTabla() {
        String[] columnas = {
                "ID", "Nickname", "Rol", "Equipo", "Edad",
                "Salario mensual", "Nivel", "Cláusula salida", "Umbral alerta"
        };

        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // solo lectura
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // ayuda a ordenar y renderizar bien
                return switch (columnIndex) {
                    case 4, 6, 8 -> Integer.class;  // edad, nivel, umbral
                    case 5, 7 -> Double.class;       // salario, clausula
                    default -> String.class;
                };
            }
        };

        tblJugadores.setModel(modelo);
        tblJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblJugadores.setAutoCreateRowSorter(true); // ordenar columnas
    }

    private void refrescarTabla() {
        modelo.setRowCount(0); // limpia filas

        for (Jugador j : jugadorList) {
            modelo.addRow(new Object[]{
                    j.getIdGamer(),
                    j.getNickname(),
                    j.getRol(),
                    j.getEquipo(),
                    j.getEdad(),
                    j.getSalarioMensual(),
                    j.getNivel(),
                    j.getClausulaSalida(),
                    j.getUmbralAlerta()
            });
        }
    }

    void agregarJugador()
    {
        Jugador jugador = new Jugador(textField1.getText(), textField2.getText(), comboBox1.getSelectedItem().toString(),comboBox2.getSelectedItem().toString(), (int)spinner1.getValue(),
                (int)spinner2.getValue(),slider1.getValue(),(int)spinner3.getValue(),(int)spinner6.getValue());
        jugadorList.add(jugador);
        JOptionPane.showMessageDialog(null, "Jugador guardado correctamente");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Roster Club");
        frame.setContentPane(new RosterClub().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
    }

}
