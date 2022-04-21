package com.chat.domain.model.embbedId;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MessageFKey implements Serializable {
    
    @Column(
        name = "sender_id",
        length = 16,
        nullable = false
    )
    private UUID senderId;

    
    @Column(
        name = "receiver_id",
        length = 16,
        nullable = false
    )
    private UUID receiverId;

    public UUID getSenderId() {
        return this.senderId;
    }

    public UUID getReceiverId() {
        return this.receiverId;
    }

    public void setSenderId(UUID sender) {
        this.senderId = sender;
    }

    public void setReceiverId(UUID receiver) {
        this.receiverId = receiver;
    }
}
