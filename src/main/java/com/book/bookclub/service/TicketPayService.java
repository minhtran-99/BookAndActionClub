package com.book.bookclub.service;

import com.book.bookclub.entity.Ticketpay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketPayService {
    List<Ticketpay> findAll();
    boolean delete(int id);
    Ticketpay create(Ticketpay ticketpay);
    Ticketpay findbyId(int id);
}
