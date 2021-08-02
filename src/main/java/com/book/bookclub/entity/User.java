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
    @Column(name = "userId")
    private Integer id;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "class")
    private String classRoom;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "createDate")
    private Date createDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    public User(Integer id, Integer accountId, String userName, String password, String fullName, String classRoom, String phone, String mail, Boolean status, Date createDate, Set<Role> roles) {
        this.id = id;
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.classRoom = classRoom;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.createDate = createDate;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User question = (User) o;
        return id == question.id && Objects.equals(accountId, question.accountId) && Objects.equals(userName, question.userName) && Objects.equals(password, question.password) && Objects.equals(fullName, question.fullName) && Objects.equals(classRoom, question.classRoom) && Objects.equals(phone, question.phone) && Objects.equals(mail, question.mail) && Objects.equals(status, question.status) && Objects.equals(createDate, question.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, userName, password, fullName, classRoom, phone, mail, status, createDate);
    }
}
