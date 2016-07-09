import configuration.DBWizard;
import tables.Airport;
import tables.Country;
import tables.Runway;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alessio on 05/07/16.
 */
public class DBWizardTest extends DBWizard {


    @org.junit.Test
    public void testInsertCountriesRows() throws Exception {
//        302613, "ZZ", "Unknown or unassigned country", "AF"
        Country c = new Country(302564,"CI","Côte d''Ivoire","AF");
        ArrayList<Country> cArray = new ArrayList<Country>();
        cArray.add(c);
        connect();
        deleteID(302564, "countries");
        insertCountriesRows(cArray);
        selectID(302564, "countries");
        System.out.println("Added country with id 302564");
        boolean result = deleteID(302564, "countries");
        System.out.println("Id 302564 removed");
        disconnect();
        assertTrue(result);
    }

    @org.junit.Test
    public void testInsertAirportsRows() throws Exception {
        Airport a = new Airport(6523, "00AK", "heliport", "Total Rf Heliport", "NA", "US", "US-PA");
        ArrayList<Airport> aArray = new ArrayList<Airport>();
        aArray.add(a);
        connect();
        deleteID(6523, "airports");
        insertAirportsRows(aArray);
        selectID(6523, "airports");
        System.out.println("Added airport with id 6523");
        boolean result = deleteID(6523, "airports");
        System.out.println("Id 6523 removed");
        disconnect();
        assertTrue(result);
    }

    @org.junit.Test
    public void testInsertRunwaysRows() throws Exception {
        Runway r = new Runway(269408, 6523, "00A", "ASPH-G", "H1");
        ArrayList<Runway> rArray = new ArrayList<Runway>();
        rArray.add(r);
        connect();
        deleteID(269408, "runways");
        insertRunwaysRows(rArray);
        selectID(269408, "runways");
        System.out.println("Added runway with id 269408");
        boolean result = deleteID(269408, "runways");
        System.out.println("Id 269408 removed");
        disconnect();
        assertTrue(result);
    }
}