package com.ciptadana.bareksaapi.scheduler;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataScheduler {
    private final DataMigrateService dataMigrateService;

    @Scheduled(cron = "0 25 00 * * *")
    //@PostConstruct
    public void syncData(){
        dataMigrateService.scheduleSync();
    }

    @PostConstruct
    public void migrate(){
        dataMigrateService.startMigrate();
    }
}
