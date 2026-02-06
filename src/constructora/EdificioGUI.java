package constructora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EdificioGUI {
    private JPanel mainPanel;
    private JTextField textField1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSlider slider1;
    private JRadioButton siRadioButton;
    private JRadioButton siRadioButton1;
    private JButton guardarButton;
    private JButton mostrarButton;

    List<Edificio> edificioList = new ArrayList<>();

    public EdificioGUI()
    {
        mostrarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mostrarEdificio2();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                edificioList.add(guardarEdificio());
                JOptionPane.showMessageDialog(null, "Edificio guardado correctamente");
            }
        });
    }

    public Edificio guardarEdificio()
    {
        String nombre = textField1.getText();
        int pisos = (int)spinner1.getValue();
        int altura = (int)spinner2.getValue();
        int num_apartamentos = slider1.getValue();
        boolean ascensor = siRadioButton.isSelected();
        boolean parqueadero = siRadioButton1.isSelected();

        return new Edificio(nombre, pisos, altura, num_apartamentos, ascensor, parqueadero);
    }

    public void mostrarEdificio()
    {
        int i = 1;
        for (Edificio edificio: edificioList)
        {
            System.out.println("Edificio "+i);
            System.out.println("El nombre del edificio es: "+edificio.getNombre());
            System.out.println("El numero de pisos es: "+edificio.getPisos());
            System.out.println("La altura es: "+edificio.getAltura());
            System.out.println("El numero de apartamentos es: "+edificio.getNum_apartamentos());
            System.out.println("El edificio tiene ascensor?: "+edificio.isAscensor());
            System.out.println("El edificio tiene parqueadero?: "+edificio.isParqueadero());
            System.out.println("---------------------------------------");
            i++;
        }
    }

    public void mostrarEdificio2()
    {
        StringBuffer sb = new StringBuffer();
        int i = 1;
        for (Edificio edificio: edificioList)
        {
            sb.append("Edificio "+i+"\n");
            sb.append("El nombre del edificio es: "+edificio.getNombre()+"\n");
            sb.append("El numero de pisos es: "+edificio.getPisos()+"\n");
            sb.append("La altura es: "+edificio.getAltura()+"\n");
            sb.append("El numero de apartamentos es: "+edificio.getNum_apartamentos()+"\n");
            sb.append("El edificio tiene ascensor?: "+edificio.isAscensor()+"\n");
            sb.append("El edificio tiene parqueadero?: "+edificio.isParqueadero()+"\n");
            i++;
            JOptionPane.showMessageDialog(null, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Edificio");
        frame.setContentPane(new EdificioGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
