public class Unemployment {
    private int totalLaborForce, employedLaborForce, unemployedLaborForce;
    private double unemployedPercent;

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    @Override
    public String toString() {
        return "Unemployment{" +
                "totalLaborForce=" + totalLaborForce +
                ", employedLaborForce=" + employedLaborForce +
                ", unemployedLaborForce=" + unemployedLaborForce +
                ", unemployedPercent=" + unemployedPercent +
                '}';
    }

    public int getEmployedLaborForce() {
        return employedLaborForce;
    }

    public void setEmployedLaborForce(int employedLaborForce) {
        this.employedLaborForce = employedLaborForce;
    }

    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }

    public double getUnemployedPercent() {
        return unemployedPercent;
    }

    public void setUnemployedPercent(double unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
    }

    public void add(String[] data){
        setEmployedLaborForce(Integer.parseInt(data[43]));
        setUnemployedLaborForce(Integer.parseInt(data[44]));
        setUnemployedPercent(Double.parseDouble(data[45]));
        setTotalLaborForce(getEmployedLaborForce()+getUnemployedLaborForce());
    }
}
