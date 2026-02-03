import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Animal
{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JRadioButton esterilizadoRadioButton;
    private JButton guardarButton;


    //Atributos
    private String nombre;
    private String especie;
    private int edad;
    private String sexo;
    private boolean esterilizado;

    //Lista de objetos
    List<Animal> animalList = new ArrayList<>();

//Constructor de la clase
    public Animal(String nombre, String especie, int edad, String sexo, boolean esterilizado)
    {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.sexo = sexo;
        this.esterilizado = esterilizado;

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String nombre = textField1.getText();
                String especie = textField2.getText();
                int edad = (int) spinner1.getValue();
                String sexo = comboBox1.getSelectedItem().toString();
                boolean esterilizado = esterilizadoRadioButton.isSelected();

                Animal objeto = new Animal(nombre, especie, edad, sexo, esterilizado);
                animalList.add(objeto);
            }
        });
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isEsterilizado() {
        return esterilizado;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

    public void pantallaPrincipal()
    {
        JFrame frame = new JFrame("Animal");
        frame.setContentPane(new Animal("","",4,"",false).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
    }
}
