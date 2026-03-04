import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class YugiAPI {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextArea textArea1;
    private JButton invocarButton;
    private JLabel imagen;

    public YugiAPI() {
        invocarButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerDatos();
            }
        });
    }

    public void obtenerDatos()
    {
        String nombreCarta = textField2.getText().replace(" ","%20");
        String url = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + nombreCarta)).build();

        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200)
            {
                JSONObject obj = new JSONObject(response.body());
                JSONArray data = obj.getJSONArray("data");
                JSONObject carta = data.getJSONObject(0);

                textField1.setText(String.valueOf(carta.getInt("id")));
                textField3.setText(carta.getString("type"));
                textArea1.setText(carta.getString("desc"));
                textField4.setText(carta.getString("attribute"));
                textField5.setText(carta.getString("archetype"));
                textField6.setText(carta.getString("race"));

                if (carta.has("atk"))
                    textField7.setText(String.valueOf(carta.getInt("atk")));
                if (carta.has("def"))
                    textField8.setText(String.valueOf(carta.getInt("def")));
                if (carta.has("level"))
                    textField9.setText(String.valueOf(carta.getInt("level")));

                JSONArray images = carta.getJSONArray("card_images");
                if (images.length() > 0)
                {
                    String imageUrl = images.getJSONObject(0).getString("image_url");

                    try
                    {
                        java.net.URL urlImagen = new java.net.URL(imageUrl);
                        ImageIcon icon = new ImageIcon(urlImagen);
                        Image image = icon.getImage().getScaledInstance(250, 350, Image.SCALE_SMOOTH); // ajusta tamaño a tu gusto
                        imagen.setIcon(new ImageIcon(image));
                        imagen.setText(""); // eliminar texto si había
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        imagen.setText("No se pudo cargar imagen");
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al obtener datos");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("YugiAPI");
        frame.setContentPane(new YugiAPI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
    }
}
