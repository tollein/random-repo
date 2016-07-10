package configuration;

import tables.Airport;
import tables.Country;
import tables.Runway;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class create connection with the database and it execute the queries.
 * <p/>
 * Created by alessio on 05/07/16.
 */
public class DBWizard {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/assessment";
    static final String USER = "lunatech";

    private Statement stmt = null;
    private Connection conn = null;

    public void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, "");
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
            System.out.println("Disconnected from " + DB_URL + ".");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* It insert filtered countries values into table */
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

    /* It insert filtered airports values into table */
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

    /* It insert filtered runways values into table */
    public void insertRunwaysRows(ArrayList<Runway> rows) {
        if (stmt != null) {
            try {
                for (int i = 0; i < rows.size(); i++) {
                    stmt.execute("insert into runways(id,airport_ref,airport_ident,surface,le_ident) values (" +
                            rows.get(i).getId() + "," +
                            "'" + rows.get(i).getAirport_ref() + "'," +
                            "'" + rows.get(i).getAirport_ident() + "'," +
                            "'" + rows.get(i).getSurface() + "'," +
                            "'" + rows.get(i).getLe_ident() + "');");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /* This method gets the country name */
    public boolean queryS(String input) {
        boolean result = false;
        try {
            ResultSet rs = null;
            rs = stmt.executeQuery("select airports.name, runways.surface " +
                    "from runways, airports " +
                    "inner join countries c on c.code = airports.iso_country " +
                    "where c.name = '" + input + "' " +
                    "and runways.airport_ref = airports.id " +
                    "group by airports.name;");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " +
                        rs.getString(2));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    /* This method gets the country code */
    public boolean queryI(int input) {
        boolean result = false;
        try {
            ResultSet rs = null;
            String query = ("select airports.name as airport, runways.surface as runway\n" +
                    "from airports, runways\n" +
                    "where airports.iso_country = " + input + " and runways.airport_ref = airports.id\n" +
                    "group by airports.name;");
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " +
                        rs.getString(2));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    public void report() {
        try {
            System.out.println("10 countries with highest number of airports (with count):\n");
            System.out.println("COUNTRY NAME | NUMBER OF AIRPORTS");
            ResultSet rs1 = stmt.executeQuery("select countries.name , sel.cont from\n" +
                    "(select iso_country, count(id) as cont\n" +
                    "from airports group by iso_country) sel\n" +
                    "join countries on countries.code = sel.iso_country\n" +
                    "order by sel.cont desc limit 10;");
            while (rs1.next()) {
                System.out.println(rs1.getString(1) + " | " +
                        rs1.getInt(2));
            }

            System.out.println("\n10 countries with lowest number of airports (with count):\n");
            System.out.println("COUNTRY NAME | NUMBER OF AIRPORTS");
            ResultSet rs2 = stmt.executeQuery("select countries.name , sel.cont from\n" +
                    "(select iso_country, count(id) as cont\n" +
                    "from airports group by iso_country) sel\n" +
                    "join countries on countries.code = sel.iso_country\n" +
                    "order by sel.cont asc, countries.name limit 10;");
            while (rs2.next()) {
                System.out.println(rs2.getString(1) + " | " +
                        rs2.getInt(2));
            }

            System.out.println("\nType of runways (as indicated in \"surface\" column) per country:\n");
            System.out.println("COUNTRY NAME | RUNWAY SURFACE");
            ResultSet rs3 = stmt.executeQuery("select distinct c.name, r.surface\n" +
                    "from countries c\n" +
                    "  inner join airports a on c.code = a.iso_country\n" +
                    "  inner join runways r on r.airport_ref = a.id\n" +
                    "  where r.surface <> ''\n" +
                    "order by c.name;");
            while (rs3.next()) {
                System.out.println(rs3.getString(1) + " | " +
                        rs3.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * Useful for the test.
     */
    public void selectID(int id, String table) {
        try {
            ResultSet rs = stmt.executeQuery("select * from " + table + " where id = " + id + ";");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Useful for the test.
     */
    public boolean deleteID(int id, String table) {
        try {
            stmt.executeUpdate("delete from " + table + " where id = " + id + ";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}