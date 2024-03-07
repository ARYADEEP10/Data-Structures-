import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartGUI extends JFrame {
    private ShoppingCart shoppingCart;
    private DefaultTableModel tableModel;
    private JTable cartTable;
    private JLabel totalLabel;

    public ShoppingCartGUI() {
        shoppingCart = new ShoppingCart();
        tableModel = new DefaultTableModel(new Object[]{"Item", "Quantity", "Price", "Total"}, 0);
        cartTable = new JTable(tableModel);
        totalLabel = new JLabel("Total: $0.00");

        JButton addButton = new JButton("Add Item to Cart");
        JButton removeButton = new JButton("Remove Selected Item");
        JButton totalPriceButton = new JButton("Calculate Total Price");
        JButton submitOrderButton = new JButton("Submit Order");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String itemName = JOptionPane.showInputDialog("Enter item name:");// This Prompts user for item details
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price per unit:"));

                // We Create item and item order
                Item item = new Item(itemName, price);
                ItemOrder itemOrder = new ItemOrder(item, quantity);


                shoppingCart.addItemOrder(itemOrder);// Append item order to shopping cart


                updateTable();// Then we Update table and total label
                updateTotalLabel();

                JOptionPane.showMessageDialog(null, "Item added to cart!");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // For simplicity, directly remove the selected row from the table
                if (cartTable.getSelectedRow() != -1) {
                    tableModel.removeRow(cartTable.getSelectedRow());
                    updateTotalLabel();
                } else {
                    JOptionPane.showMessageDialog(null, "Select an item to remove!");
                }
            }
        });

        totalPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate total price with bulk discount
                double totalPrice = shoppingCart.calculateTotalPriceWithDiscount();
                JOptionPane.showMessageDialog(null, "Total Price: $" + totalPrice);
            }
        });

        submitOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalPrice = shoppingCart.calculateTotalPrice();
                JOptionPane.showMessageDialog(null, "Thanks for the order!\nTotal Price: $" + totalPrice);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(totalPriceButton);
        buttonPanel.add(submitOrderButton);

        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new FlowLayout());
        totalPanel.add(totalLabel);

        setLayout(new BorderLayout());
        add(new JScrollPane(cartTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(totalPanel, BorderLayout.NORTH);

        setTitle("Shopping Cart");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (ItemOrder itemOrder : shoppingCart.getItemOrders()) {
            tableModel.addRow(new Object[]{itemOrder.getItem().getName(), itemOrder.getQuantity(),
                    itemOrder.getItem().getPrice(), itemOrder.calculateTotal()});
        }
    }

    private void updateTotalLabel() {
        double total = shoppingCart.calculateTotalPrice();
        totalLabel.setText("Total: $" + total);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingCartGUI().setVisible(true);
            }
        });
    }
}
