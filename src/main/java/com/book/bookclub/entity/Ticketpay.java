package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ticket_pay")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticketpay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_pay_id")
    private Integer ticketPayId;

    @Column(name = "ticket_borrow_id")
    private Integer ticketBorrowId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "pay_status")
    private Boolean payStatus;

    @Column(name = "pay_fee")
    private Integer payFee;

    @Column(name = "note")
    private String note;

    @Column(name = "borrow_date")
    private Date borrowDate;

    @Column(name = "pay_date")
    private Date payDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticketpay question = (Ticketpay) o;
        return ticketPayId == question.ticketPayId && Objects.equals(ticketBorrowId, question.ticketBorrowId) && Objects.equals(bookId, question.bookId) && Objects.equals(accountId, question.accountId) && Objects.equals(payStatus, question.payStatus) && Objects.equals(payFee, question.payFee) && Objects.equals(note, question.note) && Objects.equals(borrowDate, question.borrowDate) && Objects.equals(payDate, question.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketPayId,ticketBorrowId, bookId, accountId, payStatus, payFee, note, borrowDate, payDate);
    }
}
