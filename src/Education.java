import java.net.DatagramPacket;

public class Education {
    private int FIPS_Code;
    private String State, Area_name;
    private Double noHighSchool, onlyHighSchool,someCollege,bachelorsOrMore;

    //38,39,40,41

    public Education(){
    }

    public void add(String[] data){
        setFIPS_Code(Integer.parseInt(data[0]));
        setState(data[1]);
        setArea_name(data[2]);
        setNoHighSchool(Double.parseDouble(data[38]));
        setOnlyHighSchool(Double.parseDouble(data[39]));
        setSomeCollege(Double.parseDouble(data[40]));
        setBachelorsOrMore(Double.parseDouble(data[41]));

    }

    @Override
    public String toString() {
        return "Education{" +
                "FIPS_Code=" + FIPS_Code +
                ", State='" + State + '\'' +
                ", Area_name='" + Area_name + '\'' +
                ", noHighSchool=" + noHighSchool +
                ", onlyHighSchool=" + onlyHighSchool +
                ", someCollege=" + someCollege +
                ", bachelorsOrMore=" + bachelorsOrMore +
                '}';
    }

    public Double getNoHighSchool() {
        return noHighSchool;
    }

    public void setNoHighSchool(Double noHighSchool) {
        this.noHighSchool = noHighSchool;
    }

    public Double getOnlyHighSchool() {
        return onlyHighSchool;
    }

    public void setOnlyHighSchool(Double onlyHighSchool) {
        this.onlyHighSchool = onlyHighSchool;
    }

    public Double getSomeCollege() {
        return someCollege;
    }

    public void setSomeCollege(Double someCollege) {
        this.someCollege = someCollege;
    }

    public Double getBachelorsOrMore() {
        return bachelorsOrMore;
    }

    public void setBachelorsOrMore(Double bachelorsOrMore) {
        this.bachelorsOrMore = bachelorsOrMore;
    }

    public int getFIPS_Code() {
        return FIPS_Code;
    }
    public String getState() {
        return State;
    }
    public String getArea_name() {
        return Area_name;
    }

    public void setFIPS_Code(int FIPS_Code) {
        this.FIPS_Code = FIPS_Code;
    }

    public void setState(String state) {
        State = state;
    }

    public void setArea_name(String area_name) {
        Area_name = area_name;
    }



}
