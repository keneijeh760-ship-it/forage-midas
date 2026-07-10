package com.jpmc.midascore.foundation;

import com.jpmc.midascore.entity.UserRecord;
import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_Id")
    private UserRecord   sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_Id")
    private UserRecord  recipient;

    private float balance;


    public Transactions(UserRecord sender, UserRecord recipient, float balance) {
        this.sender = sender;
        this.recipient = recipient;
        this.balance = balance;
    }

    public Transactions() {

    }
}
