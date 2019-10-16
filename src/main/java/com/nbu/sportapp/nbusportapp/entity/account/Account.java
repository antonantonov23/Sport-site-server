package com.nbu.sportapp.nbusportapp.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import com.nbu.sportapp.nbusportapp.validator.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * A account is a person who is in the website session.
 */

@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
public class Account extends AbstractPersistable<Long> {
    private Long id;

    @NotBlank
    private String fullName;

    @ValidEmail
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Column
    private boolean isAdmin; // 1 is admin, 0 is not

    public Account() {
        this.isAdmin = false;
    }

    public Account(String fullName, String email, String password) {
        super();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.isAdmin = false;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}