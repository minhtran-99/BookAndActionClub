package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account_role")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountRoleId")
    private Integer id;

    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "roleId")
    private Integer roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRole question = (AccountRole) o;
        return id == question.id && Objects.equals(accountId, question.accountId) && Objects.equals(roleId, question.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,accountId, roleId);
    }
}
