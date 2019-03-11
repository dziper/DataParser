import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    DataManager manager = new DataManager();

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

    public DataManager parseAllResults(){


        String elecData = readFileAsString("data/2016_Presidential_Results.csv");
        ArrayList<ElectionResult> results= Utils.parse2016ElectionResults(elecData);
        createManager(manager, results);

        String eduData = readFileAsString("data/Education.csv");
        ArrayList<Education> edu = Utils.parse2016EducationResults(eduData);

        String empData = readFileAsString("data/Unemployment.csv");
        ArrayList<Unemployment> emp = Utils.parse2016EmploymentResults(empData);

        return manager;

    }

    private static ArrayList<Unemployment> parse2016EmploymentResults(String empData) {
        return null;
    }

    private ArrayList<Education> parse2016EducationResults(String eduData) {
        ArrayList<Education> out = new ArrayList<>();
        String[] lines = eduData.split(System.getProperty("line.separator"));

        for (int i = 6; i < lines.length; i++) {
            Education edu = new Education();
            parseLineEducation(edu, lines[i]);
            out.add(edu);
        }
        return out;
    }

    private static void createManager(DataManager manager, ArrayList<ElectionResult> results) {
        for (int i = 0; i < results.size(); i++) {
             String cName = results.get(i).getCounty_name();
             String sName = results.get(i).getState_abbr();
             State s = new State(sName);

             if(!manager.contains(sName)){
                 manager.add(s);
             }
             State state = manager.getState(sName);

             County c = new County(cName);

             if(!manager.getState(sName).contains(cName)){
                 state.add(c);
             }
             County county = state.getCounty(cName);

             county.setElec2016(results.get(i));
        }
    }

    public static ArrayList<ElectionResult> parse2016ElectionResults(String results){
        ArrayList<ElectionResult> out = new ArrayList<>();
        String[] lines = results.split(System.getProperty("line.separator"));

        for (int i = 1; i < lines.length; i++) {
            ElectionResult res = new ElectionResult();
            parseLineElection(res, lines[i]);
            out.add(res);
        }
        return out;
    }

    private static void parseLineElection(ElectionResult res, String line) {
        String cleanData = cleanLine(line);
        String[] datas = cleanData.split(",");

        for (int i = 0; i < datas.length - 1 ; i++) {
            datas[i] = datas[i+1];
        }
        res.add(datas);
    }

    private void parseLineEducation(Education edu, String line){
        String cleanData = cleanLine(line);
        String[] datum = cleanData.split(",");
        if(manager.getCounty(datum[2]) != null){
            edu.add(datum);
        }
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
