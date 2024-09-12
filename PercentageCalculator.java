
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCalculator extends JFrame {

    private JTextField input1Field, input2Field, resultField;
    private JComboBox<String> operationBox;

    public PercentageCalculator() {
        setTitle("Percentage Calculator");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Create Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Light blue color
        JLabel headerLabel = new JLabel("Percentage Calculator", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main Input Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between elements
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input 1 Label and Field
        JLabel input1Label = new JLabel("First Value:");
        input1Label.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(input1Label, gbc);

        input1Field = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(input1Field, gbc);

        // Input 2 Label and Field
        JLabel input2Label = new JLabel("Second Value / Percentage:");
        input2Label.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(input2Label, gbc);

        input2Field = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(input2Field, gbc);

        // Operation Selector
        JLabel operationLabel = new JLabel("Operation:");
        operationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(operationLabel, gbc);

        String[] operations = {"Calculate Percentage", "Percentage Increase", "Percentage Decrease", "Find Whole"};
        operationBox = new JComboBox<>(operations);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(operationBox, gbc);

        // Result Label and Field
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(resultLabel, gbc);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(resultField, gbc);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setBackground(new Color(50, 205, 50)); // Green color
        calculateButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(calculateButton, gbc);

        // Add action listener to button
        calculateButton.addActionListener(new CalculateListener());

        add(mainPanel, BorderLayout.CENTER);

        // Footer with developer information (Optional)
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180));
        JLabel footerLabel = new JLabel("Developed by Suhani Pardeshi", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Listener to handle button click and perform calculations
    private class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double input1 = Double.parseDouble(input1Field.getText());
                double input2 = Double.parseDouble(input2Field.getText());
                double result = 0;

                String selectedOperation = (String) operationBox.getSelectedItem();

                switch (selectedOperation) {
                    case "Calculate Percentage":
                        result = (input1 / input2) * 100;
                        break;
                    case "Percentage Increase":
                        result = input1 + (input1 * input2 / 100);
                        break;
                    case "Percentage Decrease":
                        result = input1 - (input1 * input2 / 100);
                        break;
                    case "Find Whole":
                        result = (input1 * 100) / input2;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Operation");
                }

                resultField.setText(String.format("%.2f", result));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PercentageCalculator());
    }
}
