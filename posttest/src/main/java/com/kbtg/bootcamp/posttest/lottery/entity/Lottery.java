package com.kbtg.bootcamp.posttest.lottery.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="lottery")
public class Lottery {
    public class Lottery {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonProperty("ticket")
        @Column(name = "ticket_id", nullable = false, unique = true, length = 6)
        private String lotteryNumber;

        @Column(name = "price", nullable = false)
        private Long price;

        @Column(name = "amount", nullable = false, length = 1)
        private int amount;

        @Column(name = "owner_user_id", nullable = true)
        private String userId;

        @JsonProperty("is_sold")
        @Column(name = "is_sold", nullable = false)
        private boolean isSold = false;

        @JsonProperty("is_sold")
        public boolean isSold() {
            return isSold;
        }
        @JsonProperty("is_sold")
        public void setSold(boolean sold) {
            isSold = sold;
        }

        @JsonProperty("ticket")
        public String getLotteryNumber() {
            return lotteryNumber;
        }

        @JsonProperty("ticket")
        public void setLotteryNumber(String lotteryNumber) {
            this.lotteryNumber = lotteryNumber;
        }


        public String getTicketId() {
            return lotteryNumber;
        }

        public void setTicketId(String ticketId) {
            this.lotteryNumber = ticketId;
        }
    }
}
