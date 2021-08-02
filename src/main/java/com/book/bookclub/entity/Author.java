package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "author")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId")
    private Integer id;

    @Column(name = "authorName")
    private String authorName;

    @Column(name = "note")
    private String note;

    @Column(name = "createDate")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author question = (Author) o;
        return id == question.id && Objects.equals(authorName, question.authorName) && Objects.equals(note, question.note) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,authorName, note, createDate);
    }
}
