package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connector {

    private String url = "jdbc:mysql://localhost:3306/da216a_project?user=root&password=root&serverTimezone=UTC";

    public Statement statement;

    public DB_Connector() {
        try {
            Connection c = DriverManager.getConnection(url);
            statement = c.createStatement();
        } catch (SQLException ex) {
            System.out.println("the connection fails");
            ex.printStackTrace();
        }
    }

}

