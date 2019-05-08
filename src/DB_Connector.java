/*
Chess Game Server: the user retrieves the other player’s latest move and/or submits his own latest move.
The move can be represented by a string in a table.
Each player move results in a new row in a table.
The table has two columns: Player ID and Move.
The string “Qa1”, means: Queen moves to A1.
*/


import java.sql.DriverManager;
import java.sql.*;

class DB_Connector {

    String url = "jdbc:mysql://localhost:3306/dod_db?user=root&password=root&serverTimezone=UTC";

    Statement statement;

    DB_Connector() {
        try {
            Connection c = DriverManager.getConnection(url);
            statement = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("the connection fails");
            ex.printStackTrace();
        }
    }

}

