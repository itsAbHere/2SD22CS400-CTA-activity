package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Gui2 extends JFrame {
    private JTextField ia1TextField;
    private JTextField ia2TextField;
    private JTextField ia3TextField;
    private JTextField ctaTextField;
    private JTextField seeTextField;
    private JButton calculateButton;

    public Gui2() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setTitle("Student Grading System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));
        getContentPane().setBackground(new Color(255, 204, 153)); // Set background color to light orange

        Font labelFont = new Font("Montserrat", Font.PLAIN, 22); // Create a Font object for Montserrat with size 22
        Font buttonFont = new Font("Arial", Font.BOLD, 18); // Create a Font object for Arial with size 18 and bold style

        add(createLabel("IA-1 Marks:", labelFont));
        ia1TextField = new JTextField();
        add(ia1TextField);

        add(createLabel("IA-2 Marks:", labelFont));
        ia2TextField = new JTextField();
        add(ia2TextField);

        add(createLabel("IA-3 Marks:", labelFont));
        ia3TextField = new JTextField();
        add(ia3TextField);

        add(createLabel("CTA Marks:", labelFont));
        ctaTextField = new JTextField();
        add(ctaTextField);

        add(createLabel("SEE Marks:", labelFont));
        seeTextField = new JTextField();
        add(seeTextField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBackground(Color.WHITE); // Set button color to white
        calculateButton.setFont(buttonFont); // Set the font for the button text
        calculateButton.setHorizontalAlignment(SwingConstants.CENTER); // Center align the button
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        setVisible(true);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private void calculateGrade() {
        // Rest of the code remains unchanged
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui2();
            }
        });
    }
}
