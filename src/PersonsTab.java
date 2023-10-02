import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PersonsTab extends JPanel{
    JLabel createLPersonLabel, deletePersonLabel;
    JTextField lotSizeField, personNameField, deletePersonNameField;
    JButton saveButton, deleteButton;
    JTextPane display;
    JScrollPane jsp;
    ParkingDB DB;


    public PersonsTab(ParkingDB DB) throws SQLException {
        this.DB = DB;
        this.setLayout(null);

        createLPersonLabel = new JLabel("Add Person Here");
        createLPersonLabel.setBounds(10, 20, 300, 100);

        personNameField = new JTextField();
        personNameField.setBounds(10, 83, 180, 25);

        lotSizeField = new JTextField();
        lotSizeField.setBounds(200, 83, 180, 25);


        deletePersonLabel = new JLabel("Remove Person Here");
        deletePersonLabel.setBounds(10, 220, 300, 100);

        deletePersonNameField = new JTextField();
        deletePersonNameField.setBounds(10, 283, 180, 25);


        saveButton = new JButton("Add Person");
        saveButton.addActionListener(new saveButton());
        saveButton.setBounds(10, 120, 180, 25);

        deleteButton = new JButton("Remove Person");
        deleteButton.addActionListener(new deleteButton());
        deleteButton.setBounds(10, 320, 180, 25);

        display = new JTextPane();
        jsp = new JScrollPane(display);
        jsp.setBounds(450, 59, 229, 250);
        display.setText(DB.getLotEntries());
        display.setEditable(false);


        this.add(createLPersonLabel);
        this.add(personNameField);
        this.add(saveButton);
        this.add(deleteButton);
        this.add(deletePersonLabel);
        this.add(deletePersonNameField);
        this.add(jsp);

        setVisible(true);
    }

    private class saveButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = personNameField.getText();
                String capacity = lotSizeField.getText();
                DB.insertLot(name, capacity);
                System.out.println("Lot Creation Successful!");
                display.setText(DB.getLotEntries());
            } catch (SQLException ex) {
                System.out.print("Lot Creation Failed!");
            }
        }
    }

    private class deleteButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = deletePersonNameField.getText();
                DB.deleteLotEntry(name);
                System.out.println("Lot Deletion Successful!");
                display.setText(DB.getLotEntries());
            } catch (SQLException ex) {
                System.out.print("Lot Deletion Failed!");
            }
        }
    }
}