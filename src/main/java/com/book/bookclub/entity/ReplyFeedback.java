package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reply_feedback")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "replyfeedbackId")
    private Integer id;

    @Column(name = "feedbackId")
    private Integer feedbackId;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "replycontent")
    private String replyContent;

    @Column(name = "createDate")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplyFeedback question = (ReplyFeedback) o;
        return id == question.id && Objects.equals(feedbackId, question.feedbackId) && Objects.equals(accountId, question.accountId) && Objects.equals(replyContent, question.replyContent) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedbackId, accountId, replyContent, createDate);
    }
}
