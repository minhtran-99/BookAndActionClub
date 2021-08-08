package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "publishing")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Publishing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publishing_id")
    private Integer publishingId;

    @Column(name = "publishing_name")
    private Integer publishingName;

    @Column(name = "address")
    private String address;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publishing question = (Publishing) o;
        return publishingId == question.publishingId && Objects.equals(publishingName, question.publishingName) && Objects.equals(address, question.address) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishingId, publishingName, address, createDate);
    }
}
