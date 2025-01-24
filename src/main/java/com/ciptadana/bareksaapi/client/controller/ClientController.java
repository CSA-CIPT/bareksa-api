package com.ciptadana.bareksaapi.client.controller;

import com.ciptadana.bareksaapi.api.PagingResponse;
import com.ciptadana.bareksaapi.client.business.*;
import com.ciptadana.bareksaapi.client.dto.*;
import com.ciptadana.bareksaapi.client.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bareksa/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/summary-profit-loss")
    public ResponseEntity<SummaryProfitLossResponse> getSummaryProfitLoss(@RequestBody @Valid GetSummaryProfitLoss getSummaryProfitLoss){
        return new ResponseEntity<>(clientService.getProfitLossSummary(getSummaryProfitLoss), HttpStatus.OK);
    }

    @GetMapping("/profit-loss")
    public ResponseEntity<PagingResponse<ProfitLoss>> getSummaryProfitLoss(@RequestBody GetProfitLoss getProfitLoss){
        return new ResponseEntity<>(clientService.getProfitLoss(getProfitLoss), HttpStatus.OK);
    }

    @GetMapping("/rdn/{clientCode}")
    public ResponseEntity<List<GetRDNBalanceDTO>> getRdnByClientCode(@PathVariable("clientCode") String clientCode){
        return new ResponseEntity<>(clientService.getRDNBalanceDTOList(clientCode), HttpStatus.OK);
    }

    @GetMapping("/mutations")
    public ResponseEntity<PagingResponse<ClientMutation>> getClientMutation(@RequestParam("date") String date){
        return new ResponseEntity<>(clientService.getClientMutation(date), HttpStatus.OK);
    }

    @GetMapping("/mutations-bluechip")
    public ResponseEntity<List<ClientMutationBlueChip>> getClientMutationBlueChip(@RequestParam("clientCode") String clientCode, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
        return new ResponseEntity<>(clientService.getClientMutationBlueChip(clientCode, startDate, endDate), HttpStatus.OK);
    }


    @GetMapping("/transactions/{clientCode}/{date}")
    public ResponseEntity<PagingResponse<ClientTransaction>> getClientTransactions(@PathVariable("clientCode")String clientCode, @PathVariable("date")String date) {
        return new ResponseEntity<>(clientService.getClientTransactions(clientCode, date), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagingResponse<ClientMPPE>> getClientMPPE(@RequestParam("page") int page){
        return new ResponseEntity<>(clientService.getClientMPPE(page), HttpStatus.OK);
    }

    @GetMapping("/three-days")
    public ResponseEntity<PagingResponse<ClientThreeDays>> getCashThreeDays(@RequestParam("page") int page){
        return new ResponseEntity<>(clientService.getCashThreeDays(page), HttpStatus.OK);
    }

    @GetMapping("/commissions")
    public ResponseEntity<PagingResponse<ClientCommission>> getClientCommission(@RequestParam ("page") int page){
        return new ResponseEntity<>(clientService.getClientCommission(page), HttpStatus.OK);
    }

    @GetMapping("/charges")
    public ResponseEntity<PagingResponse<ClientCharge>> getClientCharge(@RequestParam ("date") String date){
        return new ResponseEntity<>(clientService.getClientCharge(date), HttpStatus.OK);
    }

    @GetMapping("/average-prices")
    public ResponseEntity<PagingResponse<ClientAveragePrice>> getClientAveragePrice(@RequestParam ("page") int page){
        return new ResponseEntity<>(clientService.getClientAveragePrice(page), HttpStatus.OK);
    }

    @GetMapping("/rdn")
    public ResponseEntity<PagingResponse<RDNMPPE>> getAllRDN(@RequestParam("page") int page){
        return new ResponseEntity<>(clientService.getAllRDN(page), HttpStatus.OK);
    }
    @GetMapping("/finances/{period}")
    public ResponseEntity<List<ClientFinancing>> getTempClientFinancingMPPE(@PathVariable("period")int period){
        return new ResponseEntity<>(clientService.getTempClientFinancingMPPEData(period), HttpStatus.OK);
    }

    @GetMapping("/inactive")
    public ResponseEntity<PagingResponse<ClientListMitraPPEInactive>> getClientListMitraPPEInactive(@RequestParam("page") int page){
        return new ResponseEntity<>(clientService.getClientListMitraPPEInactive(page), HttpStatus.OK);
    }
    @GetMapping("/suspended")
    public ResponseEntity<List<ClientSuspended>> getClientSuspendedBareksa(){
        return new ResponseEntity<>(clientService.getClientSuspendedBareksa(), HttpStatus.OK);
    }
    @GetMapping("/unsuspended")
    public ResponseEntity<PagingResponse<ClientSuspended>> getClientUnsuspendedBareksa(){
        return new ResponseEntity<>(clientService.getClientUnsuspendedBareksa(), HttpStatus.OK);
    }
    @GetMapping("/balances/previous")
    public ResponseEntity<List<ClientPortfolioPrevBalResponse>> getPortfolioPrevBal(){
        return new ResponseEntity<>(clientService.getClientPortfolioPrevBal(), HttpStatus.OK);
    }

    @GetMapping("/transactions/ar-ap")
    public ResponseEntity<List<ClientTransactionArAp>> getTransactionArAp(@RequestParam ("date") String date){
        return new ResponseEntity<>(clientService.getClientTransactionArAp(date), HttpStatus.OK);
    }

    @GetMapping("/late-payment")
    public ResponseEntity<List<ClientLatePayment>> getClientLatePayment(@RequestParam ("period") String period){
        return new ResponseEntity<>(clientService.getClientLatePayment(period), HttpStatus.OK);
    }

    @GetMapping("/withdrawals")
    public ResponseEntity<PagingResponse<OutstandingWithdrawal>> getOutstandingWithdrawalList(){
        return new ResponseEntity<>(clientService.getOutstandingWithdrawalList(), HttpStatus.OK);
    }

    @PostMapping("/trading-limit")
    public ResponseEntity<String> getSubmitGradeStock(@RequestBody GetSubmitTradingLimitClient getSubmitTradingLimitClient){
        return new ResponseEntity<>(clientService.submitTradingLimitClient(getSubmitTradingLimitClient), HttpStatus.OK);
    }


    @GetMapping("/updated")
    public ResponseEntity<List<UpdateClientPropertyResponse>> getUpdateClientProperty(){
        return new ResponseEntity<>(clientService.getUpdateClientProperty(), HttpStatus.OK);
    }

    @PostMapping("/closing-accounts")
    public ResponseEntity<String> getSubmitClosingAccount (@RequestBody SubmitClosingAccountResponse submitClosingAccountResponse){
        return new ResponseEntity<>(clientService.submitClosingAccount(submitClosingAccountResponse), HttpStatus.OK);
    }

    @GetMapping("/ar-ap")
    public ResponseEntity<List<ClientArAp>> getClientArAp(@RequestBody GetClientArAp getClientArAp) {
        return new ResponseEntity<>(clientService.getClientArAp(getClientArAp), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String > getUpdatedDataList(@RequestBody GetUpdatedClientData getUpdatedClientData){
        return new ResponseEntity<>(clientService.updateClientData(getUpdatedClientData), HttpStatus.OK);
    }


}
