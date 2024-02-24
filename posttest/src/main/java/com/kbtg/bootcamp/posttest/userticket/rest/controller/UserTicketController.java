package com.kbtg.bootcamp.posttest.userticket.rest.controller;

import com.kbtg.bootcamp.posttest.lottery.rest.dto.LotteryResponseDto;
import com.kbtg.bootcamp.posttest.userticket.rest.dto.UserTicketResDto;
import com.kbtg.bootcamp.posttest.userticket.rest.dto.UserTicketResponseDto;
import com.kbtg.bootcamp.posttest.userticket.rest.dto.UserTicketsRequestDto;
import com.kbtg.bootcamp.posttest.userticket.service.UserTicketService;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserTicketController {
    private final UserTicketService userTicketService;

    public UserTicketController(UserTicketService userTicketService) {
        this.userTicketService = userTicketService;
    }

    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<UserTicketsRequestDto> buyLottery(
            @PathVariable("userId")
//            @Pattern(regexp = "^0\\d{9}$", message = "must be a number only  and start with '0'")
//            @Size(min = 10, max = 10, message = "must be a 10 digit")
            String userId,
            @PathVariable("ticketId")
//            @Pattern(regexp = "^\\d{6}$", message = "must be a number only")
//            @Size(min = 6, max = 6, message = "must be a 6 digit")
            String ticketId) {
        return new ResponseEntity<>(userTicketService.buyLottery(userId, ticketId), HttpStatus.OK);
    }


    @GetMapping("/users/{userId}/lotteries")
    public ResponseEntity<UserTicketResDto> getLotteryByUser(
            @PathVariable("userId")
//            @Pattern(regexp = "^0\\d{9}$", message = "must be a number only  and start with '0'")
//            @Size(min = 10, max = 10, message = "must be a 10 digit")
            String userId) {
        return new ResponseEntity<>(userTicketService.getLotteryByUser(userId), HttpStatus.OK);//fixed
    }


    //Sell lottery
    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<LotteryResponseDto> sellLottery(
            @PathVariable("userId")
//            @Pattern(regexp = "^0\\d{9}$", message = "must be a number only  and start with '0'")
//            @Size(min = 10, max = 10, message = "must be a 10 digit")
            String userId,
            @PathVariable("ticketId")
//            @Pattern(regexp = "^\\d{6}$", message = "must be a number only")
//            @Size(min = 6, max = 6, message = "must be a 6 digit")
            String ticketId) {
        return new ResponseEntity<>(userTicketService.sellLottery(userId, ticketId), HttpStatus.OK);
    }

}