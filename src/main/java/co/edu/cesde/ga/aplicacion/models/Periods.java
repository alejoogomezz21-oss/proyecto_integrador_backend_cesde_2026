package co.edu.cesde.ga.aplicacion.models;

import java.time.LocalDate;

public class Periods {
    private Long periodId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public Periods() {}

    public Periods(Long periodId, String name, LocalDate startDate, LocalDate endDate) {
        this.periodId = periodId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters y Setters para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    // Getters y Setters para startDate
    public java.time.LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(java.time.LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getters y Setters para endDate
    public java.time.LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(java.time.LocalDate endDate) {
        this.endDate = endDate;
    }
}