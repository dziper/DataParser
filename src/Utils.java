import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    static DataManager manager = new DataManager();

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

    public static DataManager parseAllResults(){


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
        ArrayList<Unemployment> out = new ArrayList<>();
        String[] lines = empData.split(System.getProperty("line.separator"));

        for (int i = 10; i < lines.length; i++) {
            Unemployment edu = new Unemployment();
            parseLineUnemployment(edu, lines[i]);
            out.add(edu);
        }
        return out;
    }

    private static ArrayList<Education> parse2016EducationResults(String eduData) {
        ArrayList<Education> out = new ArrayList<>();
        String[] lines = eduData.split(System.getProperty("line.separator"));
        for (int i = 6; i < lines.length - 10; i++) {
            Education edu = new Education();
            parseLineEducation(edu, lines[i]);
            out.add(edu);
        }
        return out;
    }

    private static void createManager(DataManager manager, ArrayList<ElectionResult> results) {
        for (int i = 0; i < results.size(); i++) {
             String cName = results.get(i).getCounty_name();
             int cFips = results.get(i).getCombined_fips();

             String sName = results.get(i).getState_abbr();
             State s = new State(sName);

             if(!manager.contains(sName)){
                 manager.add(s);
             }
             State state = manager.getState(sName);

             County c = new County(cName, cFips);

             if(!manager.getState(sName).contains(cName,cFips)){
                 state.add(c);
             }
             County county = state.getCounty(cName, cFips);
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

    private static void parseLineEducation(Education edu, String line){
        String cleanData = cleanLine(line);
        String[] datum = cleanData.split(",");
        int fips = Integer.parseInt(datum[0]);

            if (manager.getCounty(datum[2], fips) != null && datum[38].length() > 0) {
                edu.add(datum);
                manager.getCounty(datum[2], fips).setEduc2016(edu);
            }

    }

    private static void parseLineUnemployment(Unemployment empl, String line){
        String cleanData = cleanLine(line);
        String[] datum = cleanData.split(",");


        for (int i = 0; i < datum.length; i++) {
            datum[i] = datum[i].trim();
        }
        String cName = datum[2];



        if (cName.length() > 1) {
            datum[2] = cName.substring(0, cName.length() - 3);
        }
        if(manager.getCounty(datum[2],Integer.parseInt(datum[0])) != null){
            empl.add(datum);
        }
        System.out.println(datum[2]);

        //@TODO: set counties by fips or name? I guess? Because currently

        manager.getCounty(datum[2], Integer.parseInt(datum[0])).setEmploy2016(empl);
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
