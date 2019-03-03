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

        for (int i = 0; i < lines.length; i++) {
            ElectionResult res = new ElectionResult();
            parseLine(res, lines[i]);
            out.add(res);
        }
        return out;
    }

    private static void parseLine(ElectionResult res, String line) {
        String cleanData = cleanLine(line);
        String[] datas = cleanData.split(",");

        for (int i = 1; i < datas.length; i++) {
            String point = datas[i];
            switch (i){
                case 1:
                    res.setVotes_dem(Integer.parseInt(point));
                case 2:
                    res.setVotes_gop(Integer.parseInt(point));
                case 3:
                    res.setTotal_votes(Integer.parseInt(point));
                case 4:
                    res.setPer_dem(Double.parseDouble(point));
                case 5:
                    res.setPer_gop(Double.parseDouble(point));
                case 6:
                    res.setDiff(Integer.parseInt(point));
                case 7:
                    res.setPer_point_diff(Double.parseDouble(point));
                case 8:
                    res.setState_abbr(point);
                case 9:
                    res.setCounty_name(point);
                case 10:
                    res.setCombined_fips(Integer.parseInt(point));
                    default:

            }
        }
    }

    private static String cleanLine(String line) {
        boolean openQuote = false;
        for (int i = 0; i < line.length(); i++) {
            if(openQuote) {
                if (line.substring(i, i + 1).equals("\"")) {
                    openQuote = !openQuote;
                }

                if(line.substring(i,i+1).equals(",") || line.substring(i, i + 1).equals("\"") || line.substring(i, i + 1).equals("%")){
                    line = line.substring(0, i) + line.substring(i + 1);
                    i--;
                }
            }

        }

        return line;
    }
}
