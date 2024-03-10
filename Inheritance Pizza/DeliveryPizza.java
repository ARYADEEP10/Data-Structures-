// DeliveryPizza.java
public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, int numToppings, String deliveryAddress) {
        super(toppings, numToppings);
        this.deliveryAddress = deliveryAddress;

        if (super.price > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nDelivery Fee: $" + deliveryFee + "\nDelivery Address: " + deliveryAddress;
    }
}
