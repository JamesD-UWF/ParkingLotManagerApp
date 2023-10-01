import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class DashboardTab extends JPanel{
    JRadioButton coke;
    JRadioButton dietCoke;
    JRadioButton tea;
    JSpinner numDrinks;
    int initialNum = 0;
    int maxDrink = 10;
    ButtonGroup group;
    Border blackline = BorderFactory.createTitledBorder("Drinks");

    public DashboardTab(ParkingDB DB) {
        setLayout(null);

        setVisible(true);
    }
}