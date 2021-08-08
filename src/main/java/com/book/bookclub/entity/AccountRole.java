package com.book.bookclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_role", schema = "club_book", catalog = "")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_role_id")
    private Integer accountRoleId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "role_id")
    private Integer roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountRole question = (AccountRole) o;
        return accountRoleId == question.accountRoleId && Objects.equals(accountId, question.accountId) && Objects.equals(roleId, question.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountRoleId,accountId, roleId);
    }
}
