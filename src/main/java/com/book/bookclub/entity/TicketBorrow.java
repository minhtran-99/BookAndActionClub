package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ticket_borrow")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tichketBorrowId")
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "bookId")
    private Integer bookId;

    @Column(name = "quantity")
    private Integer quantity;

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
        TicketBorrow question = (TicketBorrow) o;
        return id == question.id && Objects.equals(userId, question.userId) && Objects.equals(accountId, question.accountId) && Objects.equals(bookId, question.bookId) && Objects.equals(quantity, question.quantity) && Objects.equals(note, question.note) && Objects.equals(borrowDate, question.borrowDate) && Objects.equals(payDate, question.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,userId, accountId, bookId, quantity, note, borrowDate, payDate);
    }
}
