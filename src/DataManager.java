import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<State> states;

    public DataManager(){
        states = new ArrayList<>();
    }

    public boolean contains(String name){
        for (int i = 0; i < states.size(); i++) {
            State s = states.get(i);
            if (s.getName().equals(name)) return true;

        }
        return false;
    }

    public void add(State s){
        states.add(s);
    }

    public State getState(String name){
        for (int i = 0; i < states.size(); i++) {
            State s = states.get(i);
            if (s.getName().equals(name)) return s;

        }
        return null;
    }

    public County getCounty(String name, int fips){
        for (int i = 0; i < states.size(); i++) {
            State s = states.get(i);
            if (s.contains(name, fips)) {
                return s.getCounty(name,fips);
            }

        }
        return null;
    }


}
