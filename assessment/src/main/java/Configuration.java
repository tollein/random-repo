
import configuration.CSVRecovery;
import configuration.DBWizard;
import tables.Airport;
import tables.Country;
import tables.Runway;
import tables.TablesManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * This class recovers data from csv files and it filters them with the aim of insert them into
 * the tables.
 * <p/>
 * Created by alessio on 05/07/16.
 */
public class Configuration {

    private static String countriesCSV = "src/main/resources/countries.csv";
    private static String airportsCSV = "src/main/resources/airports.csv";
    private static String runwaysCSV = "src/main/resources/runways.csv";

    public void configure() {

        InputStream in = null;
        in = Configuration.class.getClassLoader().getResourceAsStream("config.properties");
        if (in == null) {
            System.out.println("Sorry, unable to find properties file!");
            System.exit(1);
        }
        Properties props = new Properties();
        System.out.println("DATABASE CONFIGURATION");
        try {
            props.load(in);

            /* Check if db is already populated */
            if (props.getProperty("db.populated").equals("yes")) {
                System.out.println("Already populated!\n");
                in.close();
            } else {
                System.out.println("It will take a few seconds...");
                CSVRecovery parser = new CSVRecovery();

                /* Recovery data from CSV files */
                System.out.println("\nRecovery data from CSV files");
                System.out.println("1/3 countries.csv");
                ArrayList<String[]> countriesA = parser.recoveryFromCSV(props.getProperty("csv.path") +"/"+ countriesCSV);
                System.out.println("2/3 airports.csv");
                ArrayList<String[]> airportsA = parser.recoveryFromCSV(props.getProperty("csv.path") +"/"+ airportsCSV);
                System.out.println("3/3 runways.csv");
                ArrayList<String[]> runwaysA = parser.recoveryFromCSV(props.getProperty("csv.path") +"/"+ runwaysCSV);

                /* Filtering useful data */
                System.out.println("\nFiltering useful data");
                System.out.println("1/3 countries");
                ArrayList<Country> listCountries = TablesManager.filterCountryData(countriesA);
                System.out.println("2/3 airports");
                ArrayList<Airport> listAirports = TablesManager.filterAirportData(airportsA);
                System.out.println("3/3 runways");
                ArrayList<Runway> listRunways = TablesManager.filterRunwayData(runwaysA);

                /* Insert data filtered into DB tables */
                System.out.println("\nInsert data filtered into DB tables");
                DBWizard dbw = new DBWizard();
                dbw.connect();
                System.out.println("1/3 Countries");
                dbw.insertCountriesRows(listCountries);
                System.out.println("2/3 Airports");
                dbw.insertAirportsRows(listAirports);
                System.out.println("3/3 Runways");
                dbw.insertRunwaysRows(listRunways);

                System.out.println("Done!");
                props.setProperty("db.populated", "yes");
                FileOutputStream out = new FileOutputStream("assessment/conf/config.properties");
                props.store(out, null);
                out.close();
                dbw.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
