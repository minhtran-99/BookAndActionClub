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
    @Column(name = "ticket_borrow_id")
    private Integer ticketBorrowId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "note")
    private String note;

    @Column(name = "borrow_status")
    private Boolean borrowStatus;

    @Column(name = "borrow_date")
    private Date borrowDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketBorrow question = (TicketBorrow) o;
        return ticketBorrowId == question.ticketBorrowId && Objects.equals(userId, question.userId) && Objects.equals(accountId, question.accountId) && Objects.equals(bookId, question.bookId) && Objects.equals(quantity, question.quantity) && Objects.equals(note, question.note) && Objects.equals(borrowStatus, question.borrowStatus) && Objects.equals(borrowDate, question.borrowDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketBorrowId,userId, accountId, bookId, quantity, note, borrowStatus, borrowDate);
    }
}
