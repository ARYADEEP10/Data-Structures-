package pizza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaApp extends JFrame {

    private double totalPrice = 0.0;

    public PizzaApp() {
        setTitle("Pizza Builder");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel sizeLabel = new JLabel("Select the Size:");
        add(sizeLabel);

        JComboBox<String> sizeComboBox = new JComboBox<>(new String[]{"Small", "Medium", "Large", "Extra Large"});
        add(sizeComboBox);

        JLabel toppingsLabel = new JLabel("Select Toppings:");
        add(toppingsLabel);

        JCheckBox pepperoniCheckBox = new JCheckBox("Pepperoni");
        add(pepperoniCheckBox);

        JCheckBox mushroomsCheckBox = new JCheckBox("Mushrooms");
        add(mushroomsCheckBox);

        JCheckBox onionsCheckBox = new JCheckBox("Onions");
        add(onionsCheckBox);

        JCheckBox cheeseCheckBox = new JCheckBox("Cheese");
        add(cheeseCheckBox);

        JCheckBox chickenCheckBox = new JCheckBox("Chicken");
        add(chickenCheckBox);


        JButton calculateButton = new JButton("Calculate Total Bill");
        add(calculateButton);

        JButton resetButton = new JButton("Reset");
        add(resetButton);

        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        add(resultTextArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPrice = 0.0;

                // Calculate size cost
                String selectedSize = (String) sizeComboBox.getSelectedItem();
                switch (selectedSize) {
                    case "Small":
                        totalPrice += 5.0;
                        break;
                    case "Medium":
                        totalPrice += 8.0;
                        break;
                    case "Large":
                        totalPrice += 10.0;
                    case "Extra Large":
                        totalPrice += 11.0;
                        break;
                    case null:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + selectedSize);
                }

                // Calculate toppings cost
                if (pepperoniCheckBox.isSelected()) {
                    totalPrice += 2.0;
                }
                if (mushroomsCheckBox.isSelected()) {
                    totalPrice += 1.5;
                }
                if (onionsCheckBox.isSelected()) {
                    totalPrice += 1.0;
                }
                if(cheeseCheckBox.isSelected()){
                    totalPrice+=2.5;
                }
                if(chickenCheckBox.isSelected()){
                    totalPrice+=3.0;
                }
                // Display result
                resultTextArea.setText("Total Price: $" + totalPrice);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeComboBox.setSelectedIndex(0);
                pepperoniCheckBox.setSelected(false);
                mushroomsCheckBox.setSelected(false);
                onionsCheckBox.setSelected(false);
                cheeseCheckBox.setSelected(false);
                chickenCheckBox.setSelected(false);
                resultTextArea.setText("");
                totalPrice = 0.0;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PizzaApp().setVisible(true);
            }
        });
    }
}
