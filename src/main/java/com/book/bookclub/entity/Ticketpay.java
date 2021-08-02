package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ticket_pay", schema = "book_club", catalog = "")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticketpay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tichketPayId")
    private Integer id;

    @Column(name = "tichketBorrowId")
    private Integer ticketBorrowId;

    @Column(name = "bookId")
    private Integer bookId;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "payStatus")
    private Boolean payStatus;

    @Column(name = "payFee")
    private Integer payFee;

    @Column(name = "note")
    private String note;

    @Column(name = "borrowDate")
    private Date borrowDate;

    @Column(name = "payDate")
    private Date payDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticketpay question = (Ticketpay) o;
        return id == question.id && Objects.equals(ticketBorrowId, question.ticketBorrowId) && Objects.equals(bookId, question.bookId) && Objects.equals(accountId, question.accountId) && Objects.equals(payStatus, question.payStatus) && Objects.equals(payFee, question.payFee) && Objects.equals(note, question.note) && Objects.equals(borrowDate, question.borrowDate) && Objects.equals(payDate, question.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,ticketBorrowId, bookId, accountId, payStatus, payFee, note, borrowDate, payDate);
    }
}
