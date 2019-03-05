import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parse2016ElectionResults(String results){
        ArrayList<ElectionResult> out = new ArrayList<>();
        String[] lines = results.split(System.getProperty("line.separator"));

        for (int i = 1; i < lines.length; i++) {
            ElectionResult res = new ElectionResult();
            parseLine(res, lines[i]);
            out.add(res);
        }
        return out;
    }

    private static void parseLine(ElectionResult res, String line) {
        String cleanData = cleanLine(line);
        String[] datas = cleanData.split(",");

        for (int i = 0; i < datas.length - 1 ; i++) {
            datas[i] = datas[i+1];
        }
        res.add(datas);
    }

    private static String cleanLine(String line) {
        boolean openQuote = false;
        for (int i = 0; i < line.length(); i++) {

            if (line.substring(i, i + 1).equals("\"")) {
                openQuote = !openQuote;
                line = line.substring(0, i) + line.substring(i + 1);
                i--;
                continue;
            }

            if(openQuote) {
                if(line.substring(i,i+1).equals(",")){
                    line = line.substring(0, i) + line.substring(i + 1);
                    i--;
                    continue;
                }
            }

            if (line.substring(i, i + 1).equals("%")) {
                line = line.substring(0, i) + line.substring(i + 1);
                i--;
                continue;
            }

        }

        return line;
    }
}
