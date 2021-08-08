package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "feedback")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Integer feedbackId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback question = (Feedback) o;
        return feedbackId == question.feedbackId && Objects.equals(userName, question.userName) && Objects.equals(mail, question.mail) && Objects.equals(content, question.content) && Objects.equals(status, question.status) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId,userName, mail, content, status, createDate);
    }
}
