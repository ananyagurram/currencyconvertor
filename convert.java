import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GFG {

    public static void converter() {
        JFrame frame = new JFrame("CONVERTER");

        JLabel labelRupees, labelDollars;
        JTextField textRupees, textDollars;
        JButton buttonToDollar, buttonToRupee, buttonClose;

        labelRupees = new JLabel("Rupees:");
        labelRupees.setBounds(20, 40, 60, 30);
        labelDollars = new JLabel("Dollars:");
        labelDollars.setBounds(170, 40, 60, 30);

        textRupees = new JTextField("0");
        textRupees.setBounds(80, 40, 50, 30);
        textDollars = new JTextField("0");
        textDollars.setBounds(240, 40, 50, 30);

        buttonToDollar = new JButton("INR");
        buttonToDollar.setBounds(50, 80, 60, 15);
        buttonToRupee = new JButton("Dollar");
        buttonToRupee.setBounds(190, 80, 60, 15);
        buttonClose = new JButton("close");
        buttonClose.setBounds(150, 150, 60, 30);

        buttonToDollar.addActionListener(e -> {
            try {
                double rupees = Double.parseDouble(textRupees.getText());
                double dollars = rupees / 65.25;
                textDollars.setText(String.format("%.2f", dollars));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonToRupee.addActionListener(e -> {
            try {
                double dollars = Double.parseDouble(textDollars.getText());
                double rupees = dollars * 65.25;
                textRupees.setText(String.format("%.2f", rupees));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonClose.addActionListener(e -> frame.dispose());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.add(labelRupees);
        frame.add(textRupees);
        frame.add(labelDollars);
        frame.add(textDollars);
        frame.add(buttonToDollar);
        frame.add(buttonToRupee);
        frame.add(buttonClose);

        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        converter();
    }
}


