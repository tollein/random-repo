import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alessio on 05/07/16.
 */
public class CSVRecovery {

    ArrayList<String[]> dataRecovered = new ArrayList<String[]>();

    public ArrayList<String[]> recoveryFromCSV(String csvFilePath) {

        ArrayList<String[]> csvExtracted = new ArrayList<String[]>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));

            String line = "";
            String symbol = ",";

            while ((line = br.readLine()) != null) {
                String[] row = line.split(symbol);
                csvExtracted.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvExtracted;
    }


}
