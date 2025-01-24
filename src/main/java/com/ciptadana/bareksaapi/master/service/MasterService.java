package com.ciptadana.bareksaapi.master.service;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqComplainEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqComplainKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqGradeStockEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.ReqComplainJpaRepository;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.SumbitGradeStockJpaRepository;
import com.ciptadana.bareksaapi.master.dto.*;
import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.MasterHolidayEntity;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.MasterHolidayJpaRepository;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.MasterMitraMapJpaRepository;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.ViewMasterStockJpaRepository;
import com.ciptadana.bareksaapi.util.FormatDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MasterService {

    private final MasterHolidayJpaRepository masterHolidayJpaRepository;
    private final MasterMitraMapJpaRepository masterMitraPPEJpaRepository;
    private final FormatDate formatDate;
    private final ViewMasterStockJpaRepository viewMasterStockJpaRepository;
    private final SumbitGradeStockJpaRepository sumbitGradeStockJpaRepository;
    private final ReqComplainJpaRepository reqComplainJpaRepository;

    public List<MasterMitraPPEResponse>  getMasterMitraPPE(){
        return masterMitraPPEJpaRepository.getMasterMitraPPE().stream()
                .map(getMasterMitraPPE -> MasterMitraPPEResponse.builder()
                        .mitraCode(getMasterMitraPPE.getMitraCode())
                        .mitraName(getMasterMitraPPE.getMitraName())
                        .updatedBy(getMasterMitraPPE.getUpdatedBy())
                        .updatedOn(getMasterMitraPPE.getUpdatedOn())
                        .build()
                ).toList();
    }

    public List<GetMasterStockResponse> getMasterStocks(){
        return viewMasterStockJpaRepository.getViewMasterStock().parallelStream()
                .map(getViewMasterStock -> GetMasterStockResponse.builder()
                        .stockId(getViewMasterStock.getStockId())
                        .stockCode(getViewMasterStock.getStockCode())
                        .stockName(getViewMasterStock.getStockName())
                        .subSectorId(getViewMasterStock.getSubsectorId())
                        .status(getViewMasterStock.getStatus())
                        .board(getViewMasterStock.getBoard())
                        .colorHex(getViewMasterStock.getColorhex())
                        .securityType(getViewMasterStock.getSecurityType())
                        .preOpeningFlag(getViewMasterStock.getPreopeningflag())
                        .markingPercent(getViewMasterStock.getMarkingpercent())
                        .isMargin(getViewMasterStock.getIsMargin())
                        .build()
                ).toList();
    }

    public List<GetMasterHolidayDTO> getMasterHolidayDTOList(){
        List<MasterHolidayEntity> masterHolidayEntities = masterHolidayJpaRepository.findByHolidayGreaterThanEqualOrderByHoliday(LocalDate.now());

        return masterHolidayEntities.stream()
                .map(getMasterHolidayDTO -> GetMasterHolidayDTO.builder()
                        .holiday(formatDate.formatYYYYmmDD(getMasterHolidayDTO.getHoliday()))
                        .build()
        ).collect(Collectors.toList());
    }

    public String submitGradeStock(GetSumbitGradeStock getSumbitGradeStock){
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String date = dateTimeNow.format(formatter);

        sumbitGradeStockJpaRepository.save(ReqGradeStockEntity.builder()
                .stockCode(getSumbitGradeStock.getStockCode())
                .gradeStock(getSumbitGradeStock.getGradeStock())
                .maxCappingAmount(getSumbitGradeStock.getMaxCappingAmount())
                .maxCappingQty(getSumbitGradeStock.getMaxCappingQty())
                .effectiveDate(getSumbitGradeStock.getEffectiveDate())
                .modifiedDate((date))
                .build()
        );

        return "Success";
    }

    public String submitComplain(SubmitComplainResponse submitComplainResponse){
        reqComplainJpaRepository.save(ReqComplainEntity.builder()
                        .id(ReqComplainKey.builder()
                                .code(submitComplainResponse.getClientCode())
                                .createdDate(formatDate.formatYYYYmmDD(LocalDate.now()))
                                .build())
                        .name(submitComplainResponse.getName())
                        .email(submitComplainResponse.getEmail())
                        .complain(submitComplainResponse.getComplain())
                        .status(submitComplainResponse.getStatus())
                        .category(submitComplainResponse.getCategory())
                        .modifiedDate(LocalDateTime.now().toString())
                .build());

        return "Success";
    }


}
