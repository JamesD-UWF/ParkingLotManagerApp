import java.awt.desktop.UserSessionEvent;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class ParkingDB {
    Connection conn = null;
    public void run() {

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:csc205.db");
            System.out.println("Opened database connection!");
            createLotTable();

        } catch (SQLException e) {

        }
    }
    public String getLotEntries() throws SQLException {
        String lots = "";
        int totalNum = 0;
        String getEntries = "" + "SELECT * FROM ParkingLots";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getEntries);
        while(rs.next()) {
            lots += "Name: " + rs.getString("lotName") + " | Capacity: " + rs.getString("capacity") + '\n';
            totalNum += parseInt(rs.getString("capacity"));
        }
        return lots + "Total Spots: " + totalNum + '\n';
    }
    public void deleteLotEntry(String lotName) throws SQLException{
        String delLotTable = "" + "DELETE FROM ParkingLots WHERE lotName = '" + lotName + "';";
        Statement stmt = conn.createStatement();
        stmt.execute(delLotTable);
    }

    public void createLotTable() throws SQLException {
        String createLotTable = "" + "CREATE TABLE IF NOT EXISTS ParkingLots " +
                "( lotName VARCHAR(20) , capacity integer(20)  );";
        Statement stat = conn.createStatement();
        stat.execute(createLotTable);
    }
    public void insertLot(String lotName, String capacity) throws SQLException{

        String insertLot = "INSERT INTO ParkingLots (lotName, capacity) VALUES (?, ?);"; // default account
        PreparedStatement pstmt = conn.prepareStatement(insertLot);
        pstmt.setString(1, lotName);
        pstmt.setString(2, capacity);
        pstmt.executeUpdate();
    }

    public void displayDatabase() throws SQLException{
        String selectSQL = "SELECT * from ParkingLots";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);

        System.out.println("---------- LOT DB TABLE ----------");
        while(rs.next()) {
            String Lot = "Lot Name: " + rs.getString("lotName") + " | Capacity: " + rs.getString("capacity");
            System.out.println(Lot);
        }
    }
}
