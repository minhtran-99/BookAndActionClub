package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_pass")
    private String accountPass;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "address")
    private String address;

    @Column(name = "account_status")
    private Boolean accountStatus;

    @Column(name = "create_date")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account question = (Account) o;
        return accountId == question.accountId && Objects.equals(accountName, question.accountName) && Objects.equals(accountPass, question.accountPass) && Objects.equals(phone, question.phone) && Objects.equals(mail, question.mail) && Objects.equals(address, question.address) && Objects.equals(accountStatus, question.accountStatus) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId,accountName, accountPass, phone, mail, address, accountStatus, createDate);
    }
}
