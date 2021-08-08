package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "publishing_id")
    private Integer publishingId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "year_publishing")
    private Date yearPublishing;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "image")
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book question = (Book) o;
        return bookId == question.bookId && Objects.equals(authorId, question.authorId) && Objects.equals(categoryId, question.categoryId) && Objects.equals(publishingId, question.publishingId) && Objects.equals(bookName, question.bookName) && Objects.equals(quantity, question.quantity) && Objects.equals(yearPublishing, question.yearPublishing) && Objects.equals(createDate, question.createDate) && Objects.equals(image, question.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, authorId, categoryId, publishingId, bookName, quantity, yearPublishing, createDate, image);
    }
}
