import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Termometr extends JFrame {
    private JPanel mainPanel;
    private JTextField temperatureField;
    private JButton closeButton;
    private JButton resultButton;
    private JLabel resultLabel;

    private ImageIcon icon = new ImageIcon("src/icon.png");
    private double temperature, result;

    public Termometr() {
        super("Przelicznik temperatury");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,500,180);
        this.setIconImage(icon.getImage());
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        resultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(temperatureField.getText(), "")) {
                    temperature = Double.parseDouble(temperatureField.getText());
                    result = 9*temperature/5 + 32;
                    resultLabel.setText("Podana temperatura to " + String.valueOf(result) + " F.");
                } else {
                    resultLabel.setText("Wpisz wartosc w pole tekstowe.");
                }
            }
        });
    }

    public static void main(String[] args) {
        Termometr frame = new Termometr();
        frame.setVisible(true);
    }
}
