import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class SettingsTab extends JPanel{
    JLabel createLotLabel, deleteLotLabel;
    JTextField lotSizeField, lotNameField, deleteLotNameField;
    JButton saveButton, deleteButton;
    JTextPane display;
    JScrollPane jsp;
    ParkingDB DB;


    public SettingsTab(ParkingDB DB) throws SQLException {
        this.DB = DB;
        this.setLayout(null);

        createLotLabel = new JLabel("Create Lot Here");
        createLotLabel.setBounds(10, 20, 300, 100);

        lotNameField = new JTextField();
        lotNameField.setBounds(10, 83, 180, 25);

        lotSizeField = new JTextField();
        lotSizeField.setBounds(200, 83, 180, 25);


        deleteLotLabel = new JLabel("Delete Lot Here");
        deleteLotLabel.setBounds(10, 220, 300, 100);

        deleteLotNameField = new JTextField();
        deleteLotNameField.setBounds(10, 283, 180, 25);


        saveButton = new JButton("Create New Lot");
        saveButton.addActionListener(new saveButton());
        saveButton.setBounds(10, 120, 180, 25);

        deleteButton = new JButton("Delete Lot");
        deleteButton.addActionListener(new deleteButton());
        deleteButton.setBounds(10, 320, 180, 25);

        display = new JTextPane();
        jsp = new JScrollPane(display);
        jsp.setBounds(450, 59, 229, 143);
        display.setText(DB.getLotEntries());
        display.setEditable(false);


        this.add(createLotLabel);
        this.add(lotSizeField);
        this.add(lotNameField);
        this.add(saveButton);
        this.add(deleteButton);
        this.add(deleteLotLabel);
        this.add(deleteLotNameField);
        this.add(jsp);

        setVisible(true);
    }

    private class saveButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = lotNameField.getText();
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
                String name = deleteLotNameField.getText();
                DB.deleteLotEntry(name);
                System.out.println("Lot Deletion Successful!");
                display.setText(DB.getLotEntries());
            } catch (SQLException ex) {
                System.out.print("Lot Deletion Failed!");
            }
        }
    }
}