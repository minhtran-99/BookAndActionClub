package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "author")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "note")
    private String note;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author question = (Author) o;
        return authorId == question.authorId && Objects.equals(authorName, question.authorName) && Objects.equals(note, question.note) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId,authorName, note, createDate);
    }
}
