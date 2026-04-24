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

}