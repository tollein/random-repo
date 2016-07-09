package tables;

import java.util.ArrayList;

/**
 * Created by alessio on 05/07/16.
 */
public class TablesManager {

    public static ArrayList<Country> filterCountryData(ArrayList<String[]> countries) {
        ArrayList<Country> listCountries = new ArrayList<Country>();

        for (int i = 1; i < countries.size(); i++) {
            String[] tmp = countries.get(i);
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String name = tmp[2];
            String continent = tmp[3];
            listCountries.add(new Country(id, code, name, continent));
        }
        return listCountries;
    }

    public static ArrayList<Airport> filterAirportData(ArrayList<String[]> airports) {
        ArrayList<Airport> listAirports = new ArrayList<Airport>();

        for (int i = 1; i < airports.size(); i++) {
            String[] tmp = airports.get(i);
            int id = Integer.parseInt(tmp[0]);
            String ident = tmp[1];
            String type = tmp[2];
            String name = tmp[3];
            String continent = tmp[7];
            String iso_country = tmp[8];
            String iso_region = tmp[9];
            listAirports.add(new Airport(id, ident, type, name, continent, iso_country, iso_region));
        }
        return listAirports;
    }

    public static ArrayList<Runway> filterRunwayData(ArrayList<String[]> runways) {
        ArrayList<Runway> listRunways = new ArrayList<Runway>();

        for (int i = 1; i < runways.size(); i++) {
            String[] tmp = runways.get(i);
            int id = Integer.parseInt(tmp[0]);
            int airport_ref = Integer.parseInt(tmp[1]);
            String airport_ident = tmp[2];
            String surface = tmp[5];
            String le_ident = tmp[7];
            listRunways.add(new Runway(id, airport_ref, airport_ident, surface, le_ident));
        }
        return listRunways;
    }
}
