public class Main {

    //Main for Data Parser

    public static void main(String[] args) {
        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        System.out.println(data);
    }
}
