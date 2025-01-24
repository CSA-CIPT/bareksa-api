package com.ciptadana.bareksaapi.client.service;

import com.ciptadana.bareksaapi.client.dto.GetMasterMitraDTO;
import com.ciptadana.bareksaapi.client.dto.GetSummaryProfitLoss;
import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.TempBalanceEntity;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.TempBalanceJpaRepository;
import com.ciptadana.bareksaapi.util.FormatDate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientAsyncService {

    private final TempBalanceJpaRepository tempBalanceJpaRepository;
    private final FormatDate formatDate;


    @Transactional
    public List<TempBalanceEntity> processAsync(GetMasterMitraDTO mitraDTO, GetSummaryProfitLoss getSummaryProfitLoss){
        LocalDate start = LocalDate.parse(getSummaryProfitLoss.getStartDate(), formatDate.getYyyyMMddHypen());
        LocalDate end = LocalDate.parse(getSummaryProfitLoss.getEndDate(), formatDate.getYyyyMMddHypen());
        tempBalanceJpaRepository.callPortfolioClientPLSummary(formatDate.formatYYYYmmDD(start), formatDate.formatYYYYmmDD(end), "", mitraDTO.getCode());
        List<TempBalanceEntity> temp =  new ArrayList<>(tempBalanceJpaRepository.getAllTempBalance());
        temp.forEach(System.out::println);
        return temp;
    }
}
