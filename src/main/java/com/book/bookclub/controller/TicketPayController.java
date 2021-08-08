package com.book.bookclub.controller;

import com.book.bookclub.entity.Ticketpay;
import com.book.bookclub.service.TicketPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/ticket_pay")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TicketPayController {

    @Autowired
    private TicketPayService ticketPayService;

    @GetMapping(value = "")
    public ResponseEntity<List<Ticketpay>> getAll(){
        List<Ticketpay> ticketpayList = ticketPayService.findAll();
        if(ticketpayList != null){
            return new ResponseEntity<>(ticketpayList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Ticketpay ticketpay, @PathVariable int id){
        ticketpay.setTicketPayId(id);
        return new ResponseEntity<>(ticketPayService.create(ticketpay), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody Ticketpay ticketpay){
        ticketpay.setBorrowDate(new Date());
        ticketpay.setPayDate(new Date());
        return new ResponseEntity<>(ticketPayService.create(ticketpay), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(ticketPayService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(ticketPayService.delete(id), HttpStatus.OK);
    }
}
