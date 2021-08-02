package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "book")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Integer id;

    @Column(name = "authorId")
    private Integer authorId;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "publishingId")
    private Integer publishingId;

    @Column(name = "bookname")
    private String bookName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "yearPublishing")
    private Date yearPublishing;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "image")
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book question = (Book) o;
        return id == question.id && Objects.equals(authorId, question.authorId) && Objects.equals(categoryId, question.categoryId) && Objects.equals(publishingId, question.publishingId) && Objects.equals(bookName, question.bookName) && Objects.equals(quantity, question.quantity) && Objects.equals(yearPublishing, question.yearPublishing) && Objects.equals(createDate, question.createDate) && Objects.equals(image, question.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, categoryId, publishingId, bookName, quantity, yearPublishing, createDate, image);
    }
}
