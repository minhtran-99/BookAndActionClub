package com.book.bookclub.service.impl;

import com.book.bookclub.reponsitory.TicketBorrowReponsitory;
import com.book.bookclub.entity.TicketBorrow;
import com.book.bookclub.service.TicketBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketBorrowServiceImpl implements TicketBorrowService {

    @Autowired
    private TicketBorrowReponsitory ticketBorrowReponsitory;

    @Override
    public List<TicketBorrow> findAll() {
        return ticketBorrowReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            ticketBorrowReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TicketBorrow create(TicketBorrow ticketBorrow) {
        if(ticketBorrow.getTicketBorrowId() != null){
            TicketBorrow ticketBorrowCreate = ticketBorrowReponsitory.findById(ticketBorrow.getTicketBorrowId()).get();
            ticketBorrow.setTicketBorrowId(ticketBorrow.getTicketBorrowId());
            ticketBorrow.setBorrowDate(ticketBorrowCreate.getBorrowDate());
            if(ticketBorrow.getUserId() == null){
                ticketBorrow.setUserId(ticketBorrowCreate.getUserId());
            }
            if(ticketBorrow.getAccountId() == null){
                ticketBorrow.setAccountId(ticketBorrowCreate.getAccountId());
            }
            if(ticketBorrow.getBookId() == null){
                ticketBorrow.setBookId(ticketBorrowCreate.getBookId());
            }
            if(ticketBorrow.getQuantity() == null){
                ticketBorrow.setQuantity(ticketBorrowCreate.getQuantity());
            }
            if(ticketBorrow.getNote() == null){
                ticketBorrow.setNote(ticketBorrowCreate.getNote());
            }
            if(ticketBorrow.getBorrowStatus() == null){
                ticketBorrow.setBorrowStatus(ticketBorrowCreate.getBorrowStatus());
            }
        }
        return ticketBorrowReponsitory.save(ticketBorrow);
    }

    @Override
    public TicketBorrow findbyId(int id) {
        return ticketBorrowReponsitory.findById(id).get();
    }
}
