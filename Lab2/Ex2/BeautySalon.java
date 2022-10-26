import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeautySalon extends JFrame {
    private JPanel mainPanel;
    private JPasswordField voucherField;
    private JCheckBox lifting;
    private JCheckBox manicure;
    private JCheckBox masage;
    private JCheckBox pedicure;
    private JButton calculateButton;

    private double cost = 0, voucher=0;
    private String message = "Twoje usługi:";

    public BeautySalon() {
        super("Salon piękności");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(400,300);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (lifting.isSelected()) {
                    cost += 450;
                    message += "\nLinfting- 450zł";
                }

                if (manicure.isSelected()) {
                    cost += 60;
                    message += "\nManicure- 60zł";
                }

                if (pedicure.isSelected()) {
                    cost += 120;
                    message += "\nPedicure- 120zł";
                }

                if (masage.isSelected()) {
                    cost += 300;
                    message += "\nMasaż- 300zł";
                }

                if (!new String(voucherField.getPassword()).equals("")) voucher = Double.parseDouble(String.valueOf(voucherField.getPassword()));

                if (voucher >= 100 || voucher < 0) message = "Wprowadzony błędny voucher!\n\n" + message;
                else {
                    message = "Wprowadzono voucher na " + voucher + "%\n\n" + message;
                    cost -= (cost*voucher)/100;
                }

                message += "\n-----------------------------\nCałkowity koszt: " + cost + "zł";

                if (cost!=0) JOptionPane.showMessageDialog(null, message);
                else JOptionPane.showMessageDialog(null, "Wybierz jakieś usługi!");

                message = "Twoje usługi:";
                cost=0;
                voucher=0;
            }
        });
    }

    public static void main(String[] args) {
        BeautySalon frame = new BeautySalon();
        frame.setVisible(true);
    }
}
