package com.example.assignment3;

public class Covid {
    private String cases;
    private String recovered;
    private String deaths;

    public String getTotalCases() {
        return cases;
    }

    public void setTotalCases(String cases) {
        this.cases = cases;
    }

    public String getTotalRecovered() {
        return recovered;
    }

    public void setTotalRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTotalDeaths() {
        return deaths;
    }

    public void setTotalDeaths(String deaths) {
        this.deaths = deaths;
    }
}
