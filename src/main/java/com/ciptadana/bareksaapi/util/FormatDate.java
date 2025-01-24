package com.ciptadana.bareksaapi.util;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Component
public class FormatDate {

    private DateTimeFormatter yyyyMMddHypen = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyyMM");
    private DateTimeFormatter mmmmYYYY = DateTimeFormatter.ofPattern("MMMM yyyy");
    private DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
    private DateTimeFormatter ddMMMyy = DateTimeFormatter.ofPattern("dd-MMM-yy");
    public String formatYYYYmmDDHypen(LocalDate date) {
        return date.format(yyyyMMddHypen);
    }

    public String formatYYYYmm(LocalDate date) {
        return date.format(yyyyMM);
    }

    public String formatMMMMyyyy(LocalDate date){
        return date.format(mmmmYYYY);
    }

    public String formatYYYYmmDD(LocalDate date){
        return date.format(yyyyMMdd);
    }
    public String formatDDmmmYY(LocalDate date){
        return date.format(ddMMMyy);
    }
}