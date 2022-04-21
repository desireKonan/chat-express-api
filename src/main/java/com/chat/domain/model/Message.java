package com.chat.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.chat.domain.model.embbedId.MessageFKey;

@Entity(name = "Message")
@Table(name = "messages")
public class Message {
    @EmbeddedId
    private MessageFKey fkey;

    
    @ManyToOne
    @MapsId("senderId")
    @JoinColumn(name = "sender_id")
    private User sender;

    
    @ManyToOne
    @MapsId("senderId")
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(
        name = "content",
        columnDefinition = "text"
    )
    private String content;

    @Column(
        name = "created_at",
        nullable = true,
        columnDefinition = "timestamp without time zone"
    )
    private Date createdAt;

    @Column(
        name = "updated_at",
        nullable = true,
        columnDefinition = "timestamp without time zone"
    )
    private Date updatedAt;

    @Column(
        name = "deleted_at",
        nullable = true,
        columnDefinition = "timestamp without time zone"
    )
    private Date deletedAt;

    public User getSender() {
        return sender;
    }

    public void setSenderId(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiverId(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
