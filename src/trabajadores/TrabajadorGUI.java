package trabajadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorGUI {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JButton mostrarButton;

    public TrabajadorGUI() {
        guardarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                guardarTrabajador();
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mostrarTrabajador();
            }
        });
    }

    List<Trabajador> trabajadorList = new ArrayList<>();
    public void guardarTrabajador()
    {
        String nombre = textField1.getText();
        int cedula = Integer.parseInt(textField2.getText());
        int edad = (int)spinner1.getValue();
        int telefono = Integer.parseInt(textField3.getText());
        String direccion = textField4.getText();
        String cargo = comboBox1.getSelectedItem().toString();

        Trabajador trabajador = new Trabajador(nombre,cedula,edad,telefono,direccion,cargo);
        trabajadorList.add(trabajador);
        JOptionPane.showMessageDialog(null, "Trabajador guardado correctamente");
    }

    public void mostrarTrabajador()
    {
        for (Trabajador trabajador: trabajadorList)
        {
            System.out.println("Nombre: "+trabajador.getNombre());
            System.out.println("Cedula: "+trabajador.getCedula());
            System.out.println("Edad: "+trabajador.getEdad());
            System.out.println("Telefono: "+trabajador.getTelefono());
            System.out.println("Direccion: "+trabajador.getDireccion());
            System.out.println("Cargo: "+trabajador.getCargo());
            System.out.println("---------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Trabajador");
        frame.setContentPane(new TrabajadorGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
    }
}
