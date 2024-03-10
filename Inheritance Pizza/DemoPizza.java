import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza {
    private JTextField toppingsField;
    private JRadioButton pickupRadioButton;
    private JRadioButton deliveryRadioButton;
    private JTextField addressField;
    private JButton submitButton;
    private JTextArea resultTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DemoPizza().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Pizza Order");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        toppingsField = new JTextField(20);
        pickupRadioButton = new JRadioButton("Dine-In");
        deliveryRadioButton = new JRadioButton("Delivery");
        addressField = new JTextField(20);
        submitButton = new JButton("Submit");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        ButtonGroup group = new ButtonGroup();
        group.add(pickupRadioButton);
        group.add(deliveryRadioButton);

        panel.add(createLabelPanel("Enter Pizza Toppings (comma-separated):"));
        panel.add(toppingsField);
        panel.add(createRadioButtonsPanel());
        panel.add(createLabelPanel("Enter Delivery Address:"));
        panel.add(addressField);
        panel.add(createButtonPanel());
        panel.add(createResultPanel());

        frame.add(panel);
        frame.setVisible(true);
    }

    private JPanel createLabelPanel(String labelText) {
        JPanel labelPanel = new JPanel();
        JLabel label = new JLabel(labelText);
        labelPanel.add(label);
        return labelPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmission();
            }
        });
        buttonPanel.add(submitButton);
        return buttonPanel;
    }

    private JPanel createResultPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.add(new JScrollPane(resultTextArea));
        return resultPanel;
    }

    private JPanel createRadioButtonsPanel() {
        JPanel radioButtonsPanel = new JPanel();
        radioButtonsPanel.setLayout(new GridLayout(1, 2));

        pickupRadioButton.setSelected(true);

        radioButtonsPanel.add(pickupRadioButton);
        radioButtonsPanel.add(deliveryRadioButton);

        return radioButtonsPanel;
    }

    private void handleSubmission() {
        try {
            String[] toppings = validateToppings(toppingsField.getText());
            double price = calculatePrice(toppings);

            if (deliveryRadioButton.isSelected()) {
                String address = validateAddress(addressField.getText());
                double deliveryFee = calculateDeliveryFee(price);
                displayOrderDetails(toppings, price, deliveryFee, address);
            } else {
                displayOrderDetails(toppings, price, 0, "Dine-In");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[] validateToppings(String toppingsInput) {
        String[] toppings = toppingsInput.split(",");
        if (toppings.length > 10) {
            throw new IllegalArgumentException("Maximum of 10 toppings allowed.");
        }
        return toppings;
    }

    private double calculatePrice(String[] toppings) {
        return 14 + 2 * toppings.length;
    }

    private String validateAddress(String address) {
        if (address.trim().isEmpty()) {
            throw new IllegalArgumentException("Delivery address cannot be empty.");
        }
        return address;
    }

    private double calculateDeliveryFee(double totalPrice) {
        return totalPrice > 18 ? 3 : 5;
    }

    private void displayOrderDetails(String[] toppings, double price, double deliveryFee, String address) {
        StringBuilder orderDetails = new StringBuilder("Pizza Toppings: " + String.join(", ", toppings) +
                "\nPrice: $" + price);

        if (deliveryRadioButton.isSelected()) {
            orderDetails.append("\nDelivery Fee: $" + deliveryFee + "\nDelivery Address: " + address);

            JOptionPane.showMessageDialog(null, orderDetails.toString() +
                            "\n\nYour pizza will be delivered within 30 minutes.", "Order Confirmation",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            orderDetails.append("\n\nYour pizza will be ready for pickup in 15 minutes.");

            JOptionPane.showMessageDialog(null, orderDetails.toString(), "Order Confirmation",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        resultTextArea.setText(orderDetails.toString());
    }
}
