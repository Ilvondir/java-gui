import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passwords extends JFrame {
    private JPanel mainPanel;
    private JButton OKButton;
    private JPasswordField firstPassword;
    private JPasswordField secondPassword;

    private String pass1, pass2;

    public Passwords() {
        super("Passwords");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(300, 150);

        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pass1 = new String(firstPassword.getPassword());
                pass2 = new String(secondPassword.getPassword());

                if (pass1.equals(pass2)) {
                    if (pass1.equals("codejava")) JOptionPane.showMessageDialog(null, "Congratulation! You entered correct password.");
                    else JOptionPane.showMessageDialog(null, "Wrong password!");
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords are not matched!");
                }
            }
        });
    }

    public static void main(String[] args) {
        Passwords frame = new Passwords();
        frame.setVisible(true);
    }
}
