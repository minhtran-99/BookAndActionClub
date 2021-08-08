package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "banner")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banner_id")
    private Integer bannerId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner question = (Banner) o;
        return bannerId == question.bannerId && Objects.equals(accountId, question.accountId) && Objects.equals(image, question.image) && Objects.equals(content, question.content) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bannerId,accountId, image, content, createDate);
    }
}
