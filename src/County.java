public class County {
    private String name;
    private int fips;
    private ElectionResult elec2016;
    private Education educ2016;
    private Unemployment employ2016;

    public String getName() {
        return name;
    }

    public County(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFips() {
        return fips;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public ElectionResult getElec2016() {
        return elec2016;
    }

    public void setElec2016(ElectionResult elec2016) {
        this.elec2016 = elec2016;
    }

    public Education getEduc2016() {
        return educ2016;
    }

    public void setEduc2016(Education educ2016) {
        this.educ2016 = educ2016;
    }

    public Unemployment getEmploy2016() {
        return employ2016;
    }

    public void setEmploy2016(Unemployment employ2016) {
        this.employ2016 = employ2016;
    }
}
