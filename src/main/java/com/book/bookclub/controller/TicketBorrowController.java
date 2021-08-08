package com.book.bookclub.controller;

import com.book.bookclub.entity.TicketBorrow;
import com.book.bookclub.service.TicketBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/ticket_borrow")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TicketBorrowController {

    @Autowired
    private TicketBorrowService ticketBorrowService;

    @GetMapping(value = "")
    public ResponseEntity<List<TicketBorrow>> getAll(){
        List<TicketBorrow> ticketBorrowList = ticketBorrowService.findAll();
        if(ticketBorrowList != null){
            return new ResponseEntity<>(ticketBorrowList, HttpStatus.OK);
        }else{
            return new ResponseEntity("false", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody TicketBorrow ticketBorrow, @PathVariable int id){
        ticketBorrow.setTicketBorrowId(id);
        return new ResponseEntity<>(ticketBorrowService.create(ticketBorrow), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> insert(@RequestBody TicketBorrow ticketBorrow){
        ticketBorrow.setBorrowDate(new Date());
        return new ResponseEntity<>(ticketBorrowService.create(ticketBorrow), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findID(@PathVariable int id){
        return new ResponseEntity<>(ticketBorrowService.findbyId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(ticketBorrowService.delete(id), HttpStatus.OK);
    }
}
