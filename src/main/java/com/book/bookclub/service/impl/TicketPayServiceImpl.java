package com.book.bookclub.service.impl;

import com.book.bookclub.reponsitory.TicketPayReponsitory;
import com.book.bookclub.entity.Ticketpay;
import com.book.bookclub.service.TicketPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TicketPayServiceImpl implements TicketPayService {

    @Autowired
    private TicketPayReponsitory ticketPayReponsitory;

    @Override
    public List<Ticketpay> findAll() {
        return ticketPayReponsitory.findAll();
    }

    @Override
    public boolean delete(int id) {
        try{
            ticketPayReponsitory.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Ticketpay create(Ticketpay ticketpay) {
        if(ticketpay.getTicketPayId() != null){
            Ticketpay ticketpayCreate = ticketPayReponsitory.findById(ticketpay.getTicketPayId()).get();
            ticketpay.setTicketPayId(ticketpay.getTicketPayId());
            ticketpay.setBorrowDate(ticketpayCreate.getBorrowDate());
            ticketpay.setPayDate(new Date());
            if(ticketpay.getTicketBorrowId() == null){
                ticketpay.setTicketBorrowId(ticketpayCreate.getTicketBorrowId());
            }
            if(ticketpay.getBookId() == null){
                ticketpay.setBookId(ticketpayCreate.getBookId());
            }
            if(ticketpay.getAccountId() == null){
                ticketpay.setAccountId(ticketpayCreate.getAccountId());
            }
            if(ticketpay.getPayStatus() == null){
                ticketpay.setPayStatus(ticketpayCreate.getPayStatus());
            }
            if(ticketpay.getPayFee() == null){
                ticketpay.setPayFee(ticketpayCreate.getPayFee());
            }
            if(ticketpay.getNote() == null){
                ticketpay.setNote(ticketpayCreate.getNote());
            }
        }
        return ticketPayReponsitory.save(ticketpay);
    }

    @Override
    public Ticketpay findbyId(int id) {
        return ticketPayReponsitory.findById(id).get();
    }
}
