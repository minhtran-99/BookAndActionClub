package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
@Setter
@Getter
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "class")
    private String classRoom;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_date")
    private Date createDate;

    public User(Integer userId, Integer accountId, String userName, String password, String fullName, String classRoom, String phone, String mail, Boolean status, Date createDate) {
        this.userId = userId;
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.classRoom = classRoom;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User question = (User) o;
        return userId == question.userId && Objects.equals(accountId, question.accountId) && Objects.equals(userName, question.userName) && Objects.equals(password, question.password) && Objects.equals(fullName, question.fullName) && Objects.equals(classRoom, question.classRoom) && Objects.equals(phone, question.phone) && Objects.equals(mail, question.mail) && Objects.equals(status, question.status) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountId, userName, password, fullName, classRoom, phone, mail, status, createDate);
    }
}
