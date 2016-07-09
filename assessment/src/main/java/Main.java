import configuration.DBWizard;

import java.util.Scanner;

/**
 * Created by alessio on 09/07/16.
 */
public class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        DBWizard dbw = new DBWizard();
        dbw.connect();

        String s = "";
        while (!s.equals("0")) {
            System.out.println("***************** ASSESSMENT ********************");
            System.out.println("Insert:\n 1 = QUERY\n 2 = REPORTS\n 0 = quit");
            s = input.nextLine();
            switch (s) {
                case "1":
                    System.out.println("Insert:\n n = country name\n c = country code\n 0 = quit");
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
