package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        add(new JLabel("IA-1 Marks:"));
        ia1TextField = new JTextField();
        add(ia1TextField);

        add(new JLabel("IA-2 Marks:"));
        ia2TextField = new JTextField();
        add(ia2TextField);

        add(new JLabel("IA-3 Marks:"));
        ia3TextField = new JTextField();
        add(ia3TextField);

        add(new JLabel("CTA Marks:"));
        ctaTextField = new JTextField();
        add(ctaTextField);

        add(new JLabel("SEE Marks:"));
        seeTextField = new JTextField();
        add(seeTextField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBackground(Color.WHITE); // Set button color to white
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        setVisible(true);
    }

    private void calculateGrade() {
        try {
            int ia1 = Integer.parseInt(ia1TextField.getText());
            int ia2 = Integer.parseInt(ia2TextField.getText());
            int ia3 = Integer.parseInt(ia3TextField.getText());
            int cta = Integer.parseInt(ctaTextField.getText());
            int see = Integer.parseInt(seeTextField.getText());

            if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20 ||
                    cta < 0 || cta > 10 || see < 0 || see > 100) {
                throw new IllegalArgumentException("Invalid marks entered!");
            }

            int cie = Math.max(ia1, Math.max(ia2, ia3)) + Math.min(ia1, Math.min(ia2, ia3)) + cta;

            if (cie < 20) {
                JOptionPane.showMessageDialog(null, "Student is detained from taking SEE");
                return;
            }

            if (see == 38 || see == 39) {
                see = 40;
            }

            int totalMarks = cie + (see / 2);

            String grade;
            if (totalMarks >= 90 && totalMarks <= 100) {
                grade = "S";
            } else if (totalMarks >= 80 && totalMarks < 90) {
                grade = "A";
            } else if (totalMarks >= 70 && totalMarks < 80) {
                grade = "B";
            } else if (totalMarks >= 60 && totalMarks < 70) {
                grade = "C";
            } else if (totalMarks >= 50 && totalMarks < 60) {
                grade = "D";
            } else if (totalMarks >= 40 && totalMarks < 50) {
                grade = "E";
            } else {
                grade = "F";
            }

            JOptionPane.showMessageDialog(null, "Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid marks entered! Please enter valid numeric values.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gui2();
            }
        });
    }
}

