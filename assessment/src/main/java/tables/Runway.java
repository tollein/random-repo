package tables;

/**
 * Created by alessio on 05/07/16.
 */
public class Runway implements Table {

    int id;
    int airport_ref;
    String airport_indent;
    String surface;
    String le_ident;


    public Runway(int id, int airport_ref, String airport_indent, String surface, String le_ident) {
        this.id = id;
        this.airport_ref = airport_ref;
        this.airport_indent = airport_indent;
        this.surface = surface;
        this.le_ident = le_ident;
    }

    public int getId() {
        return id;
    }

    public int getAirport_ref() {
        return airport_ref;
    }

    public String getAirport_indent() {
        return airport_indent;
    }

    public String getSurface() {
        return surface;
    }

    public String getLe_ident() {
        return le_ident;
    }
}
