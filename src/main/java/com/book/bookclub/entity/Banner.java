package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "banner")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bannerId")
    private Integer id;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "createDate")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner question = (Banner) o;
        return id == question.id && Objects.equals(accountId, question.accountId) && Objects.equals(image, question.image) && Objects.equals(content, question.content) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,accountId, image, content, createDate);
    }
}
