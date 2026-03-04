package ESport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
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
    private JTextField textField3;
    private JComboBox comboBox5;
    private JButton buscarButton;
    private JTextField textField4;
    private JTable table1;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;


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
                auxiliar();
            }
        });

        comboBox4.addItemListener(new ItemListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                int index = comboBox4.getSelectedIndex();
                slider2.setValue(jugadorList.get(index).getNivel());
                spinner4.setValue(jugadorList.get(index).getSalarioMensual());
                spinner5.setValue(jugadorList.get(index).getClausulaSalida());
                textField3.setText(jugadorList.get(index).getEquipo());
            }
        });
        actualizarJugadorButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox4.getSelectedIndex();
                jugadorList.get(index).setNivel(slider2.getValue());
                jugadorList.get(index).setSalarioMensual((int)spinner4.getValue());
                jugadorList.get(index).setClausulaSalida((int)spinner5.getValue());
                jugadorList.get(index).setEquipo(comboBox3.getSelectedItem().toString());
                refrescarTabla();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String busqueda = comboBox5.getSelectedItem().toString();

                if (busqueda == "idGamer")
                {
                    for (Jugador jugador: jugadorList)
                    {
                        if (jugador.getIdGamer().equals(textField4.getText()))
                        {
                            modelo2.addRow(new Object[]{
                                    jugador.getIdGamer(),
                                    jugador.getNickname(),
                                    jugador.getRol(),
                                    jugador.getEquipo(),
                                    jugador.getEdad(),
                                    jugador.getSalarioMensual(),
                                    jugador.getNivel(),
                            });
                        }
                    }
                }
                else if (busqueda == "nickname")
                {
                    for (Jugador jugador: jugadorList)
                    {
                        if (jugador.getNickname().equals(textField4.getText()))
                        {
                            modelo2.addRow(new Object[]{
                                    jugador.getIdGamer(),
                                    jugador.getNickname(),
                                    jugador.getRol(),
                            });
                        }
                    }
                }
                else if (busqueda == "equipo")
                {
                    for (Jugador jugador: jugadorList)
                    {
                        if (jugador.getEquipo().equals(textField4.getText()))
                        {
                            modelo2.addRow(new Object[]{
                                    jugador.getIdGamer(),
                                    jugador.getNickname(),
                                    jugador.getRol(),
                            });
                        }
                    }
                }

            }
        });
    }

    void auxiliar()
    {
        //comboBox4.removeAllItems();
        comboBox4.addItem("Seleccione un jugador");
        for (Jugador jugador: jugadorList)
            comboBox4.addItem(jugador.getIdGamer());
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

        modelo2 = new DefaultTableModel(columnas, 0) {
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

        table1.setModel(modelo2);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.setAutoCreateRowSorter(true); // ordenar columnas
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
