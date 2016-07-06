package tables;

/**
 * Created by alessio on 05/07/16.
 */
public class Airport implements Table {
    int id;
    String ident;
    String type;
    String name;
    String continent;
    String iso_country;
    String iso_region;

    public Airport(int id, String ident, String type, String name, String continent,
                   String iso_country, String iso_region) {
        this.id = id;
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.continent = continent;
        this.iso_country = iso_country;
        this.iso_region = iso_region;
    }

    public int getId() {
        return id;
    }

    public String getIdent() {
        return ident;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getIso_country() {
        return iso_country;
    }

    public String getIso_region() {
        return iso_region;
    }
}
