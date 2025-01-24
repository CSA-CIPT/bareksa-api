package com.ciptadana.bareksaapi.order.controller;

import com.ciptadana.bareksaapi.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bareksa/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/trades")
    public ResponseEntity<String> uploadTrades(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>( orderService.uploadTrade(file), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> uploadOrders(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>( orderService.uploadOrders(file), HttpStatus.OK);
    }
}
