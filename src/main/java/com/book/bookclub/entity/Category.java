package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "category")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Integer id;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "createDate")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category question = (Category) o;
        return id == question.id && Objects.equals(categoryName, question.categoryName) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, createDate);
    }
}
