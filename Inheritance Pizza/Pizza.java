// Pizza.java
public class Pizza {
    private String[] toppings;
     double price;

    public Pizza(String[] toppings, int numToppings) {
        this.toppings = new String[numToppings];
        System.arraycopy(toppings, 0, this.toppings, 0, numToppings);

        StringBuilder descriptionBuilder = new StringBuilder();
        for (int i = 0; i < numToppings; i++) {
            descriptionBuilder.append(toppings[i]);
            if (i < numToppings - 1) {
                descriptionBuilder.append(", ");
            }
        }

        this.price = 14 + 2 * numToppings;
    }

    public String toString() {
        return "Pizza Toppings: " + String.join(", ", toppings) + "\nPrice: $" + price;
    }
}
