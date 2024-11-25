package christmas.repository;

import java.time.LocalDate;

public class UtecoRepository {
    private LocalDate dateToVisit;

    public void setDateToVisit(int dateInput) {
        dateToVisit = LocalDate.of(2023, 12, dateInput);
    }
}
