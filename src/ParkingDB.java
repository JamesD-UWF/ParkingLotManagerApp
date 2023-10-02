import java.sql.*;

import static java.lang.Integer.parseInt;

public class ParkingDB {
    Connection conn = null;

    public void run() {

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:csc205.db");
            System.out.println("Opened database connection!");
            createLotTable();
            System.out.println("Lot Table Created");
            createPerson();
            System.out.println("Person Table Created");

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

    public void createPerson() throws SQLException {
        String createTable = "" + "CREATE TABLE IF NOT EXISTS Persons " +
                "( idNumber VARCHAR(10), licensePlate VARCHAR(7), name VARCHAR(20) );";
        Statement stat = conn.createStatement();
        stat.execute(createTable);
    }

    public void displayPersonTable() throws SQLException{
        String selectSQL = "SELECT * from Persons";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);

        System.out.println("---------- Person DB TABLE ----------");
        while(rs.next()) {
            String People = "Name: " + rs.getString("lotName") + " | Capacity: " + rs.getString("capacity");
            System.out.println();
        }
    }

    public void createVehicleTable() throws SQLException {
        String createTable = "" + "CREATE TABLE IF NOT EXISTS VehicleInfo " +
                "( lotPermitted VARCHAR(20) , liscencePlate VARCHAR(7), make VARCHAR(20), model VARCHAR(20));";
        Statement stat = conn.createStatement();
        stat.execute(createTable);
    }

    public void createLotViolation() throws SQLException {
        String createTable = "" + "CREATE TABLE IF NOT EXISTS ParkingLots " +
                "( lotName VARCHAR(20) , capacity integer(20)  );";
        Statement stat = conn.createStatement();
        stat.execute(createTable);
    }

    public void createCarOwnerTable() throws SQLException {
        String createLotTable = "" + "CREATE TABLE IF NOT EXISTS ParkingLots " +
                "( idNumber VARCHAR(10), lisencePlate VARCHAR(7));";
        Statement stat = conn.createStatement();
        stat.execute(createLotTable);
    }

    public void createPermitLot() throws SQLException {
        String createLotTable = "" + "CREATE TABLE IF NOT EXISTS ParkingLots " +
                "( lotName VARCHAR(20), lisencePlate VARCHAR(7), duration VARCHAR(20));";
        Statement stat = conn.createStatement();
        stat.execute(createLotTable);
    }



    public void displayLotTable() throws SQLException{
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
