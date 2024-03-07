import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> itemOrders;

    public ShoppingCart() {
        this.itemOrders = new ArrayList<>();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrders.add(itemOrder);
    }

    public void removeItemOrder(ItemOrder itemOrder) {
        itemOrders.remove(itemOrder);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder itemOrder : itemOrders) {
            totalPrice += itemOrder.calculateTotal();
        }
        return totalPrice;
    }

    public boolean searchItemOrder(ItemOrder itemOrder) {
        return itemOrders.contains(itemOrder);
    }

    public ArrayList<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    // New method to calculate total price with bulk discount for any product
    public double calculateTotalPriceWithDiscount() {
        double totalPrice = 0;
        for (ItemOrder itemOrder : itemOrders) {
            totalPrice += applyBulkDiscount(itemOrder);
        }
        return totalPrice;
    }

    private double applyBulkDiscount(ItemOrder itemOrder) {
        // Check for bulk discount conditions (e.g., two items for $4)
        if (itemOrder.getQuantity() >= 2) {
            int discountedSets = itemOrder.getQuantity() / 2;
            int remainingItems = itemOrder.getQuantity() % 2;
            double discountedPrice = discountedSets * 4.0 + remainingItems * itemOrder.getItem().getPrice();
            return discountedPrice;
        } else {
            return itemOrder.calculateTotal();
        }
    }
}
