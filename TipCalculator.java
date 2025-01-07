import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tip Calculator");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel billLabel = new JLabel("Bill Amount:");
        billLabel.setBounds(10, 20, 100, 25);
        frame.add(billLabel);

        JTextField billField = new JTextField();
        billField.setBounds(120, 20, 150, 25);
        frame.add(billField);

        JLabel tipLabel = new JLabel("Tip Percentage:");
        tipLabel.setBounds(10, 60, 100, 25);
        frame.add(tipLabel);

        JTextField tipField = new JTextField();
        tipField.setBounds(120, 60, 150, 25);
        frame.add(tipField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 100, 100, 25);
        frame.add(calculateButton);

        JLabel resultLabel = new JLabel("Tip Amount: $0.00");
        resultLabel.setBounds(120, 100, 150, 25);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double billAmount = Double.parseDouble(billField.getText());
                    double tipPercentage = Double.parseDouble(tipField.getText());
                    double tipAmount = billAmount * (tipPercentage / 100);
                    resultLabel.setText(String.format("Tip Amount: $%.2f", tipAmount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}