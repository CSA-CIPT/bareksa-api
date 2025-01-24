package com.ciptadana.bareksaapi.client.service;

import com.ciptadana.bareksaapi.client.business.RDNMPPE;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Component
@Slf4j
public class ClientCache {
    private final ConcurrentHashMap<Integer, List<RDNMPPE>> rdnCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, Long> rdnPageTotalCountCache = new ConcurrentHashMap<>();


    @Scheduled(cron = "0 0 22 * * *")
    private void clearCache() {
        rdnCache.clear();
        rdnPageTotalCountCache.clear();
        log.info("CLIENT RDN CACHE CLEARED");
    }
}
