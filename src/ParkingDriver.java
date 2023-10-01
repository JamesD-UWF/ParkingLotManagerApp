import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ParkingDriver {
    public static void main(String[] args) throws SQLException {

        ParkingDB DB = new ParkingDB();
        DB.run();

        // Create the main frame
        JFrame frame = new JFrame("Parking Management Software"); // Set the title here
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 991, 683);

        JLabel titleLabel = new JLabel("Parking Management Software");
        titleLabel.setBounds(206, 23, 544, 43);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font and size if needed
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 30, 935, 478);
        JPanel tab1 = new DashboardTab(DB);
        JPanel tab2 = new JPanel();
        JPanel tab3 = new JPanel();
        JPanel tab4 = new JPanel();
        JPanel tab5 = new JPanel();
        JPanel tab6 = new SettingsTab(DB);
        JPanel tab7 = new DebugTab(DB);


        tabbedPane.addTab("Dashboard", tab1);
        tabbedPane.addTab("Pass Management", tab2);
        tabbedPane.addTab("Add Vehicle", tab3);
        tabbedPane.addTab("Remove Vehicle", tab4);
        tabbedPane.addTab("Display Parking Capacity", tab5);
        tabbedPane.addTab("Settings", tab6);
        tabbedPane.addTab("Debug", tab7);



        JPanel mainPanel = new JPanel(null);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        frame.add(mainPanel);

        frame.setVisible(true);
    }
}
