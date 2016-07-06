import tables.Country;

import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alessio on 05/07/16.
 */
public class DBWizardTest {


    @org.junit.Test
    public void testCountriesInsertRows() throws Exception {
        Country c = new Country(302613, "ZZ", "Unknown or unassigned country", "AF");
        ArrayList<Country> cArray = new ArrayList<Country>();
        cArray.add(c);
        DBWizard dbw = new DBWizard();
        dbw.connect();
        dbw.insertCountriesRows(cArray);
        dbw.disconnect();
    }

}