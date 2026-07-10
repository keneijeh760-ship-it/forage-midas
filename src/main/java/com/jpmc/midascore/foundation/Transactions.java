package com.jpmc.midascore.foundation;

import com.jpmc.midascore.entity.UserRecord;
import jakarta.persistence.*;

@Entity
public class Transactions {

    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_Id")
    private UserRecord   sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_Id")
    private UserRecord  recipient;

}
