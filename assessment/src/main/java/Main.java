import configuration.DBWizard;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by alessio on 09/07/16.
 */
public class Main {

    public static void main(String args[]) throws SQLException {
        Scanner input = new Scanner(System.in);
        DBWizard dbw = new DBWizard();

        System.out.println("**********************************************************\n" +
                "*                      ASSESSMENT                        *\n" +
                "**********************************************************");

        /* Database population */
        Configuration cfg = new Configuration();
        cfg.configure();

        /* Assessment */
        dbw.connect();

        String s = "";
        while (!s.equals("0")) {
            System.out.println("\nInsert:\n 1 = QUERY: it returns the airports & runways at each airport\n " +
                    "2 = REPORTS: it returns:\n\t- 10 countries with highest number of airports" +
                    "\n\t- 10 countries with lowest number of airports" +
                    "\n\t- type of runways (as indicated in \"surface\" column) per country"+
                    "\n 0 = QUIT");
            s = input.nextLine();
            switch (s) {
                case "1":
                    System.out.println("\nInsert:\n n = country name\n c = country code\n 0 = quit");
                    String in = input.nextLine();
                    boolean result = false;
                    switch (in) {
                        case "n":
                            System.out.println("Insert a name of country: ");
                            String name = input.nextLine();
                            result = dbw.queryS(name);
                            if (!result)
                                System.out.println("There are no data with country name " + name + "\n");
                            break;
                        case "c":
                            System.out.println("Insert a code of country: ");
                            String code = input.nextLine();
                            result = dbw.queryI(Integer.parseInt(code));
                            if (!result)
                                System.out.println("There are no data with country code " + code + "\n");
                            break;
                        case "0":
                            System.out.println("Assessment terminated.");
                            dbw.disconnect();
                            System.exit(1);
                            break;
                        default:
                            System.out.println("Invalid input\n");
                            break;
                    }
                    break;
                case "2":
                    dbw.report();
                    break;
                case "0":
                    System.out.println("Assessment terminated.");
                    dbw.disconnect();
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid input\n");
                    break;
            }
        }

    }
}
