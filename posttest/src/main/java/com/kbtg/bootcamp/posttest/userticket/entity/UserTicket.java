package com.kbtg.bootcamp.posttest.userticket.entity;

import com.kbtg.bootcamp.posttest.lottery.entity.Lottery;
import jakarta.persistence.*;

@Entity
@Table(name = "user_ticket")
public class UserTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private Lottery lottery;

    public UserTicket() {
    }

    public UserTicket(Integer id, String userId, Lottery lottery) {
        this.id = id;
        this.userId = userId;
        this.lottery = lottery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }


}
