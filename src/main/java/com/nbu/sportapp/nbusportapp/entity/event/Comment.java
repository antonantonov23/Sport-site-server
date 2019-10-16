package com.nbu.sportapp.nbusportapp.entity.event;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nbu.sportapp.nbusportapp.entity.account.Account;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@EntityListeners(AuditingEntityListener.class)
public class Comment extends AbstractPersistable<Long> {

    private Long id;

    // MAYBE TRANSIENT - ico plovdiv me chaka trqbva da slizam :D

    @Column
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "account")
    @JsonBackReference
    private Account account;

    @Column
    private String publisherName;

    @NotBlank
    private String bodyOfComment;

    // TO DECIDE: komentara shte sudurja li ID-to na event ?

    @Column(name = "base_event_id", insertable = false, updatable = false)
    private Long baseEventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="baseEvent-movement")
    private BaseEvent baseEvent;

    public Comment() {
    }

    public Comment(String publisherName, String bodyOfComment) {
        this.publisherName = publisherName;
        this.bodyOfComment = bodyOfComment;
    }


    public Long getBaseEventId() {
        return baseEventId;
    }

    public void setBaseEventId(Long baseEventId) {
        this.baseEventId = baseEventId;
    }

    public BaseEvent getBaseEvent() {
        return baseEvent;
    }

    public void setBaseEvent(BaseEvent baseEvent) {
        this.baseEvent = baseEvent;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getBodyOfComment() {
        return bodyOfComment;
    }

    public void setBodyOfComment(String bodyOfComment) {
        this.bodyOfComment = bodyOfComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", account=" + account +
                ", publisherName='" + publisherName + '\'' +
                ", bodyOfComment='" + bodyOfComment + '\'' +
                ", baseEventId=" + baseEventId +
                ", baseEvent=" + baseEvent +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
