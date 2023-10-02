import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class DebugTab extends JPanel{
    JLabel label1;
    JButton saveButton;
    ParkingDB DB;


    public DebugTab(ParkingDB DB) {
        this.DB = DB;
        this.setLayout(null);

        label1 = new JLabel("");
        label1.setBounds(10, 60, 300, 100);

        saveButton = new JButton("Print Lot DB to console");
        saveButton.addActionListener(new saveButton());
        saveButton.setBounds(10, 10, 180, 25);

        this.add(label1);
        this.add(saveButton);

        setVisible(true);
    }

    private class saveButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                DB.displayLotTable();
            } catch (SQLException ex) {
                System.out.print("Table Creation Failed!");
            }
        }
    }
}