package tables;

/**
 * Created by alessio on 05/07/16.
 */
public class Country implements Table {
    int id;
    String code;
    String name;
    String continent;

    public Country(int id, String code, String name, String continent) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
    }


    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }
}
