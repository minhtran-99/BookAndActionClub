package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reply_feedback", schema = "club_book", catalog = "")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_feedback_id")
    private Integer replyfeedbackId;

    @Column(name = "feedback_id")
    private Integer feedbackId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplyFeedback question = (ReplyFeedback) o;
        return replyfeedbackId == question.replyfeedbackId && Objects.equals(feedbackId, question.feedbackId) && Objects.equals(accountId, question.accountId) && Objects.equals(replyContent, question.replyContent) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyfeedbackId, feedbackId, accountId, replyContent, createDate);
    }
}
