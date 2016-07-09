package tables;

/**
 * Created by alessio on 05/07/16.
 */
public class Runway implements Table {

    int id;
    int airport_ref;
    String airport_ident;
    String surface;
    String le_ident;


    public Runway(int id, int airport_ref, String airport_ident, String surface, String le_ident) {
        this.id = id;
        this.airport_ref = airport_ref;
        this.airport_ident = airport_ident;
        this.surface = surface;
        this.le_ident = le_ident;
    }

    public int getId() {
        return id;
    }

    public int getAirport_ref() {
        return airport_ref;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public String getSurface() {
        return surface;
    }

    public String getLe_ident() {
        return le_ident;
    }
}
