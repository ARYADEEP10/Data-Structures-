import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartyGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Party GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();

            // Create Party components
            JLabel partyLabel = new JLabel("Party Guests:");
            JTextField partyTextField = new JTextField(10);
            JButton partyButton = new JButton("Invite to Party");

            // Create DinnerParty components
            JLabel dinnerLabel = new JLabel("Dinner Guests:");
            JTextField dinnerTextField = new JTextField(10);
            JLabel choiceLabel = new JLabel("Menu Choice:");
            JComboBox<String> choiceComboBox = new JComboBox<>(new String[]{"Chicken", "Vegi"});
            JButton dinnerButton = new JButton("Invite to Dinner Party");

            // Party components to the panel
            panel.add(partyLabel);
            panel.add(partyTextField);
            panel.add(partyButton);

            // DinnerParty components to the panel
            panel.add(dinnerLabel);
            panel.add(dinnerTextField);
            panel.add(choiceLabel);
            panel.add(choiceComboBox);
            panel.add(dinnerButton);


            partyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int guests = Integer.parseInt(partyTextField.getText());
                    Party party = new Party();
                    party.setGuests(guests);
                    JOptionPane.showMessageDialog(frame, "The party has " + party.getGuests() + " guests.\nPlease come to my party!");
                }
            });

            // DinnerParty button action listener
            dinnerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int guests = Integer.parseInt(dinnerTextField.getText());
                    String choice = (String) choiceComboBox.getSelectedItem();
                    DinnerParty dinnerParty = new DinnerParty();
                    dinnerParty.setGuests(guests);
                    dinnerParty.setDinnerChoice(choice);
                    JOptionPane.showMessageDialog(frame, "The dinner party has " + dinnerParty.getGuests() +
                            " guests.\nMenu option " + dinnerParty.getDinnerChoice() + " will be served.\nPlease come to my party!");
                }
            });

            frame.getContentPane().add(panel);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
