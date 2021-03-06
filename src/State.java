import java.util.ArrayList;
import java.util.List;

public class State {
    private String name;
    private List<County> counties;

    public State(String name){
        counties = new ArrayList<>();
        this.name = name;
    }

    public boolean contains(String name, int fips){
        for (int i = 0; i < counties.size(); i++) {
            County c = counties.get(i);
            if (c.getName().equals(name) || c.getFips() == fips) return true;

        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void add(County c ){
        counties.add(c);
    }

    public County getCounty(String cName, int fips) {
        for (int i = 0; i < counties.size(); i++) {
            County c = counties.get(i);
            if (c.getName().equals(cName) || fips == c.getFips()) return c;

        }
        return null;
    }
}
