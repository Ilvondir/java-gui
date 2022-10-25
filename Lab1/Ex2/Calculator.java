import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Calculator extends JFrame {
    private JPanel mainPanel;
    private JTextField exactField;
    private JTextField approximateField;
    private JButton confirmButton;
    private JButton calculateButton;
    private JButton closeButton;
    private JLabel resultLabel;
    private JButton reslutionButton;

    URL iconURL = getClass().getResource("icon.png");
    ImageIcon icon = new ImageIcon(iconURL);

    double exactNumber, approximateNumber, absoluteError, relativeError;

    public Calculator() {
        super("Przelicznik błędów");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());
        this.setContentPane(mainPanel);
        this.setBounds(192,108, (int)(2.3*192), 3*108);

        confirmButton.addActionListener(e -> {
            if (!exactField.getText().equals("") && !exactField.getText().equals("0")) {
                exactNumber = Double.parseDouble(exactField.getText());
                exactField.setEnabled(false);
                confirmButton.setEnabled(false);

                approximateField.setEnabled(true);
                calculateButton.setEnabled(true);

                resultLabel.setText("<html><center><b>Wpisz wartość przybliżoną liczby A.</b></center></html>");

            } else {
                if (exactField.getText().equals("0")) resultLabel.setText("<html><center><b>Jako wartość dokładną wpisałeś 0!</b></center></html>");
                else resultLabel.setText("<html><center><b>Wpisz wartość dokładną liczby A!</b></center></html>");
            }
        });

        calculateButton.addActionListener(e -> {
            if (!approximateField.getText().equals("") && !approximateField.getText().equals("0")) {
                approximateNumber = Double.parseDouble(approximateField.getText());
                exactField.setEnabled(true);
                confirmButton.setEnabled(true);

                approximateField.setText("0");
                approximateField.setEnabled(false);
                calculateButton.setEnabled(false);

                absoluteError = Math.abs(exactNumber-approximateNumber);
                relativeError = absoluteError / exactNumber;

                resultLabel.setText("<html><center><b>Dla liczby dokładnej (A) " + exactNumber + "<br>i jej wartości przybliżonej (a) = " + approximateNumber + "<br>błąd bezwzględny tego przybliżenia wynosi " +  String.format("%f", absoluteError) + ",<br>zaś błąd względny wynosi " + String.format("%.2f", relativeError*100) + "%.</b></center></html>");

            } else {
                if (approximateField.getText().equals("0")) resultLabel.setText("<html><center><b>Jako wartość przybliżoną wpisałeś 0!</b></center></html>");
                else resultLabel.setText("<html><center><b>Wpisz wartość przybliżoną liczby A!</b></center></html>");
            }
        });

        closeButton.addActionListener(e -> dispose());
        reslutionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isUndecorated()) {
                    dispose();
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    setUndecorated(true);
                    setVisible(true);
                } else {
                    dispose();
                    setExtendedState(0);
                    setUndecorated(false);
                    setBounds(192,108, (int)(2.3*192), 3*108);
                    setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        Calculator frame = new Calculator();
        frame.setVisible(true);
    }

}
