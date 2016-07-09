
import configuration.CSVRecovery;
import configuration.DBWizard;
import tables.Airport;
import tables.Country;
import tables.Runway;
import tables.TablesManager;

import java.util.ArrayList;

/**
 * Created by alessio on 05/07/16.
 */
public class Configuration {

    private static String countriesCSV = "assessment/src/main/resources/countries.csv";
    private static String airportsCSV = "assessment/src/main/resources/airports.csv";
    private static String runwaysCSV = "assessment/src/main/resources/runways.csv";

    public static void main(String[] args) {
        CSVRecovery parser = new CSVRecovery();

        /* Recovery data from CSV files */
        ArrayList<String[]> countriesA = parser.recoveryFromCSV(countriesCSV);
        ArrayList<String[]> airportsA = parser.recoveryFromCSV(airportsCSV);
        ArrayList<String[]> runwaysA = parser.recoveryFromCSV(runwaysCSV);

        /* Filtering useful data */
        ArrayList<Country> listCountries = TablesManager.filterCountryData(countriesA);
        ArrayList<Airport> listAirports = TablesManager.filterAirportData(airportsA);
        ArrayList<Runway> listRunways = TablesManager.filterRunwayData(runwaysA);

        /* Insert data filtered into DB tables */
        DBWizard dbw = new DBWizard();
        dbw.connect();
        dbw.insertCountriesRows(listCountries);
        dbw.insertAirportsRows(listAirports);
        dbw.insertRunwaysRows(listRunways);
        dbw.disconnect();
    }
}
