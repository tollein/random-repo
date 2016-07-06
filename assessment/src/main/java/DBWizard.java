import tables.Airport;
import tables.Country;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by alessio on 05/07/16.
 */
public class DBWizard {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assessment";
    static final String USER = "root";
    static final String PASS = "root";

    private Statement stmt = null;
    private Connection conn = null;

    public void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Connected to " + DB_URL + ".");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCountriesRows(ArrayList<Country> rows) {
        if (stmt != null) {
            try {
                for (int i = 0; i < rows.size(); i++) {
                    stmt.executeUpdate("insert into countries(id,code,name,continent) values (" +
                            rows.get(i).getId() + "," +
                            "'" + rows.get(i).getCode() + "'," +
                            "'" + rows.get(i).getName() + "'," +
                            "'" + rows.get(i).getContinent() + "');");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertAirportsRows(ArrayList<Airport> rows) {
        if (stmt != null) {
            try {
                for (int i = 0; i < rows.size(); i++) {
                    stmt.executeUpdate("insert into airports(id,ident,type,name,continent,iso_country,iso_region) values (" +
                            rows.get(i).getId() + "," +
                            "'" + rows.get(i).getIdent() + "'," +
                            "'" + rows.get(i).getType() + "'," +
                            "'" + rows.get(i).getName() + "'," +
                            "'" + rows.get(i).getContinent() + "'," +
                            "'" + rows.get(i).getIso_country() + "'," +
                            "'" + rows.get(i).getIso_region() + "');");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}