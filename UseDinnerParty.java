
import javax.swing.*;

public class UseDinnerParty {
    public static void main(String[] args) {
        Party aParty = new Party();
        aParty.setGuests(20);

        // Display Party details
        JOptionPane.showMessageDialog(null, "Enter number of guests for the party >> " + aParty.getGuests() +
                "\nThe party has " + aParty.getGuests() + " guests");
        aParty.displayInvitation();

        // Create a DinnerParty object
        DinnerParty aDinnerParty = new DinnerParty();

        // Prompt for and set the number of guests for the DinnerParty
        int dinnerGuests = Integer.parseInt(JOptionPane.showInputDialog("Enter number of guests for the dinner party >> "));
        aDinnerParty.setGuests(dinnerGuests);

        // Prompt for and set the dinner choice for the DinnerParty
        String dinnerChoice = JOptionPane.showInputDialog("Enter the menu option -- 1 for chicken or 2 for Vegi >> ");
        aDinnerParty.setDinnerChoice(dinnerChoice);

        // Display DinnerParty details
        JOptionPane.showMessageDialog(null, "The dinner party has " + aDinnerParty.getGuests() +
                " guests\nMenu option " + aDinnerParty.getDinnerChoice() + " will be served");
        aDinnerParty.displayInvitation();
    }
}
