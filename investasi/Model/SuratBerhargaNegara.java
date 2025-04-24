package Model;

public class SuratBerhargaNegara {
    private String name;
    private double interestRate;
    private int duration; // in months
    private String maturityDate;
    private long nationalQuota;

    public SuratBerhargaNegara(String name, double interestRate, int duration, String maturityDate, int nationalQuota) {
        this.name = name;
        this.interestRate = interestRate;
        this.duration = duration;
        this.maturityDate = maturityDate;
        this.nationalQuota = nationalQuota;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public long getNationalQuota() {
        return nationalQuota;
    }

    public void setNationalQuota(long nationalQuota) {
        this.nationalQuota = nationalQuota;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Interest Rate: " + interestRate + "%" +
                ", Duration: " + duration + " months" +
                ", Maturity Date: " + maturityDate +
                ", National Quota: " + nationalQuota;
    }
}
