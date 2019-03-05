import java.util.ArrayList;

public class Main {

    //Main for Data Parser

    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");

        ArrayList<ElectionResult> results= Utils.parse2016ElectionResults(data);

        System.out.println(results);

    }
}
