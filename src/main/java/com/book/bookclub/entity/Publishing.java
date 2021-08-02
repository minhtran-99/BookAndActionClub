package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "publishing")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publishing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publishingId")
    private Integer id;

    @Column(name = "publishingName")
    private Integer publishingName;

    @Column(name = "address")
    private String address;

    @Column(name = "createDate")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publishing question = (Publishing) o;
        return id == question.id && Objects.equals(publishingName, question.publishingName) && Objects.equals(address, question.address) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publishingName, address, createDate);
    }
}
