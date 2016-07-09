import configuration.CSVRecovery;
import org.junit.Test;
import tables.Airport;
import tables.Country;
import tables.Runway;
import tables.TablesManager;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alessio on 08/07/16.
 */
public class TablesManagerTest extends TablesManager {
    private static String countriesCSV = "/home/alessio/lunatech/random-repo/assessment/src/test/resources/esCountries.csv";
    private static String airportsCSV = "/home/alessio/lunatech/random-repo/assessment/src/test/resources/esAirports.csv";
    private static String runwaysCSV = "/home/alessio/lunatech/random-repo/assessment/src/test/resources/esRunways.csv";

    CSVRecovery parser = new CSVRecovery();

    @Test
    public void testFilterCountryData() throws Exception {
        ArrayList<String[]> countriesA = parser.recoveryFromCSV(countriesCSV);
        ArrayList<Country> listCountries = TablesManager.filterCountryData(countriesA);
        for (int i = 0; i < listCountries.size(); i++) {
            System.out.print(listCountries.get(i).getId() + ", " +
                    listCountries.get(i).getCode() + ", " +
                    listCountries.get(i).getName() + ", " +
                    listCountries.get(i).getContinent());
            System.out.println();
        }
    }

    @Test
    public void testFilterAirportData() throws Exception {
        ArrayList<String[]> airportsA = parser.recoveryFromCSV(airportsCSV);
        ArrayList<Airport> listAirports = TablesManager.filterAirportData(airportsA);
        for (int i = 0; i < listAirports.size(); i++) {
            System.out.print(listAirports.get(i).getId() + ", " +
                    listAirports.get(i).getIdent() + ", " +
                    listAirports.get(i).getType() + ", " +
                    listAirports.get(i).getName() + ", " +
                    listAirports.get(i).getContinent() + ", " +
                    listAirports.get(i).getIso_country() + ", " +
                    listAirports.get(i).getIso_region());
            System.out.println();
        }
    }

    @Test
    public void testFilterRunwayData() throws Exception {
        ArrayList<String[]> runwaysA = parser.recoveryFromCSV(runwaysCSV);
        ArrayList<Runway> listRunways = TablesManager.filterRunwayData(runwaysA);
        for (int i = 0; i < listRunways.size(); i++) {
            System.out.print(listRunways.get(i).getId() + ", " +
                    listRunways.get(i).getAirport_ref() + ", " +
                    listRunways.get(i).getAirport_ident() + ", " +
                    listRunways.get(i).getSurface() + ", " +
                    listRunways.get(i).getLe_ident());
            System.out.println();
        }
    }
}