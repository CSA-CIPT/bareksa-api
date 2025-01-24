package com.ciptadana.bareksaapi.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Component
public class DayCalculator {

    public int getWorkingDays(LocalDate startDate, LocalDate endDate, List<LocalDate> holidays) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        int noFullWeeks = (int) (daysBetween / 7);
        int noRemainingDays = (int) (daysBetween % 7);

        int theFirstDayOfWeek = startDate.getDayOfWeek().getValue();
        int theLastDayOfWeek = endDate.getDayOfWeek().getValue();

        if (theFirstDayOfWeek <= theLastDayOfWeek) {
            if (theFirstDayOfWeek <= 6 && 6 <= theLastDayOfWeek) noRemainingDays--;
            if (theFirstDayOfWeek <= 7 && 7 <= theLastDayOfWeek) noRemainingDays--;
        } else {
            if (theFirstDayOfWeek == 7) {
                noRemainingDays--;
                if (theLastDayOfWeek == 6) noRemainingDays--;
            } else {
                noRemainingDays -= 2;
            }
        }

        int workingDays = noFullWeeks * 5;
        if (noRemainingDays > 0) {
            workingDays += noRemainingDays;
        }

        for (LocalDate holiday : holidays) {
            if ((startDate.isEqual(holiday) || startDate.isBefore(holiday)) &&
                    (endDate.isEqual(holiday) || endDate.isAfter(holiday)) &&
                    holiday.getDayOfWeek().getValue() != 6 &&
                    holiday.getDayOfWeek().getValue() != 7) {
                workingDays--;
            }
        }

        return workingDays;
    }
}
