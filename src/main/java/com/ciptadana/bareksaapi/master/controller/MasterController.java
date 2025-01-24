package com.ciptadana.bareksaapi.master.controller;


import com.ciptadana.bareksaapi.client.dto.SubmitClosingAccountResponse;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqGradeStockEntity;
import com.ciptadana.bareksaapi.master.dto.*;
import com.ciptadana.bareksaapi.master.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bareksa/masters")
public class MasterController {

    private final MasterService masterService;

    @GetMapping("/holidays")
    public ResponseEntity<List<GetMasterHolidayDTO>> getMasterHolidayDTO() {
        return new ResponseEntity<>(masterService.getMasterHolidayDTOList(), HttpStatus.OK);
    }

    @GetMapping("/mitra-ppe")
    public ResponseEntity<List<MasterMitraPPEResponse>> getMasterMitraPPE(){
        return new ResponseEntity<>(masterService.getMasterMitraPPE(), HttpStatus.OK);
    }
    @GetMapping("/stocks")
    public ResponseEntity<List<GetMasterStockResponse>> getMasterStock(){
        return new ResponseEntity<>(masterService.getMasterStocks(), HttpStatus.OK);
    }

    @PostMapping("/grade-stocks")
    public ResponseEntity<String> getSubmitGradeStock(@RequestBody GetSumbitGradeStock getSumbitGradeStock){
        return new ResponseEntity<>(masterService.submitGradeStock(getSumbitGradeStock), HttpStatus.OK);
    }

    @PostMapping("/complains")
    public ResponseEntity<String> getSubmitComplain (@RequestBody SubmitComplainResponse submitComplainResponse){
        return new ResponseEntity<>(masterService.submitComplain(submitComplainResponse), HttpStatus.OK);
    }

}
