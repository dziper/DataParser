import java.net.DatagramPacket;

public class Education {
    private int FIPS_Code;
    private String State, Area_name;
    private Double[] data;

    private String labels;

    public Education(){
    }
    public void add(String[] data){
        setFIPS_Code(Integer.parseInt(data[0]));
        setState(data[1]);
        setArea_name(data[2]);
        for (int i = 3; i < this.data.length; i++) {
            this.data[i] = Double.parseDouble(data[i]);
        }
    }


    //Getters

    public int getFIPS_Code() {
        return FIPS_Code;
    }
    public String getState() {
        return State;
    }
    public String getArea_name() {
        return Area_name;
    }

    public Double getRUCC2003(){
        return data[0];
    }
    public Double getUIC2003(){
        return data[1];
    }
    public Double getRUCC2013(){
        return data[2];
    }
    public Double getUIC2013(){
        return data[3];
    }
    public Double getLTAHSD1970(){
        return data[4];
    }
    public Double getHSDO1970(){
        return data[5];
    }
    public Double getSC1_3Y1970(){
        return data[6];
    }
    public Double getFYOCOH1970(){
        return data[7];
    }
    public Double getPOAWLTAHSD1970(){
        return data[8];
    }
    public Double getPOAWAHSDO1970(){
        return data[9];
    }
    public Double getPOACSC1_3Y1970(){
        return data[10];
    }
    public Double getPOACFYOCOH1970(){
        return data[11];
    }
    public Double getLTAHSD1980(){
        return data[12];
    }
    public Double getHSDO1980(){
        return data[13];
    }
    public Double getSC1_3Y1980(){
        return data[14];
    }
    public Double getFYOCOH1980(){
        return data[15];
    }
    public Double getPOAWLTAHSD1980(){
        return data[16];
    }
    public Double getPOAWAHSDO1980(){
        return data[17];
    }
    public Double getPOACSC1_3Y1980(){
        return data[18];
    }
    public Double getPOACFYOCOH1980(){
        return data[19];
    }
    public Double getLTAHSD1990(){
        return data[20];
    }
    public Double getHSDO1990(){
        return data[21];
    }
    public Double getSCOAD1990(){
        return data[22];
    }
    public Double getBDOH1990(){
        return data[23];
    }
    public Double getPOAWLTAHSD1990(){
        return data[24];
    }
    public Double getPOAWAHSDO1990(){
        return data[25];
    }
    public Double getPOACSCOAD1990(){
        return data[26];
    }
    public Double getPOAWABDOH1990(){
        return data[27];
    }
    public Double getLTAHSD2000(){
        return data[28];
    }
    public Double getHSDO2000(){
        return data[29];
    }
    public Double getSCOAD2000(){
        return data[30];
    }
    public Double getBDOH2000(){
        return data[31];
    }
    public Double getPOAWLTAHSD2000(){
        return data[32];
    }
    public Double getPOAWAHSDO2000(){
        return data[33];
    }
    public Double getPOACSCOAD2000(){
        return data[34];
    }
    public Double getPOAWABDOH2000(){
        return data[35];
    }
    public Double getLTAHSD2012_16(){
        return data[36];
    }
    public Double getHSDO2012_16(){
        return data[37];
    }
    public Double getSCOAD2012_16(){
        return data[38];
    }
    public Double getBDOH2012_16(){
        return data[39];
    }
    public Double getPOAWLTAHSD2012_16(){
        return data[40];
    }
    public Double getPOAWAHSDO2012_16(){
        return data[41];
    }
    public Double getPOACSCOAD2012_16(){
        return data[42];
    }
    public Double getPOAWABDOH2012_16(){
        return data[43];
    }


    //Setters


    public void setFIPS_Code(int FIPS_Code) {
        this.FIPS_Code = FIPS_Code;
    }

    public void setState(String state) {
        State = state;
    }

    public void setArea_name(String area_name) {
        Area_name = area_name;
    }

    public Double setRUCC2003(){
        return data[0];
    }
    public Double setUIC2003(){
        return data[1];
    }
    public Double setRUCC2013(){
        return data[2];
    }
    public Double setUIC2013(){
        return data[3];
    }
    public Double setLTAHSD1970(){
        return data[4];
    }
    public Double setHSDO1970(){
        return data[5];
    }
    public Double setSC1_3Y1970(){
        return data[6];
    }
    public Double setFYOCOH1970(){
        return data[7];
    }
    public Double setPOAWLTAHSD1970(){
        return data[8];
    }
    public Double setPOAWAHSDO1970(){
        return data[9];
    }
    public Double setPOACSC1_3Y1970(){
        return data[10];
    }
    public Double setPOACFYOCOH1970(){
        return data[11];
    }
    public Double setLTAHSD1980(){
        return data[12];
    }
    public Double setHSDO1980(){
        return data[13];
    }
    public Double setSC1_3Y1980(){
        return data[14];
    }
    public Double setFYOCOH1980(){
        return data[15];
    }
    public Double setPOAWLTAHSD1980(){
        return data[16];
    }
    public Double setPOAWAHSDO1980(){
        return data[17];
    }
    public Double setPOACSC1_3Y1980(){
        return data[18];
    }
    public Double setPOACFYOCOH1980(){
        return data[19];
    }
    public Double setLTAHSD1990(){
        return data[20];
    }
    public Double setHSDO1990(){
        return data[21];
    }
    public Double setSCOAD1990(){
        return data[22];
    }
    public Double setBDOH1990(){
        return data[23];
    }
    public Double setPOAWLTAHSD1990(){
        return data[24];
    }
    public Double setPOAWAHSDO1990(){
        return data[25];
    }
    public Double setPOACSCOAD1990(){
        return data[26];
    }
    public Double setPOAWABDOH1990(){
        return data[27];
    }
    public Double setLTAHSD2000(){
        return data[28];
    }
    public Double setHSDO2000(){
        return data[29];
    }
    public Double setSCOAD2000(){
        return data[30];
    }
    public Double setBDOH2000(){
        return data[31];
    }
    public Double setPOAWLTAHSD2000(){
        return data[32];
    }
    public Double setPOAWAHSDO2000(){
        return data[33];
    }
    public Double setPOACSCOAD2000(){
        return data[34];
    }
    public Double setPOAWABDOH2000(){
        return data[35];
    }
    public Double setLTAHSD2012_16(){
        return data[36];
    }
    public Double setHSDO2012_16(){
        return data[37];
    }
    public Double setSCOAD2012_16(){
        return data[38];
    }
    public Double setBDOH2012_16(){
        return data[39];
    }
    public Double setPOAWLTAHSD2012_16(){
        return data[40];
    }
    public Double setPOAWAHSDO2012_16(){
        return data[41];
    }
    public Double setPOACSCOAD2012_16(){
        return data[42];
    }
    public Double setPOAWABDOH2012_16(){
        return data[43];
    }
}
