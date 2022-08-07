package com.tosya.may.booking.component;

import com.tosya.may.booking.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
public class ScheduledDeleteUserBasket {
    @Autowired
    private BasketService basketService;
    @Transactional
    @Scheduled(fixedRate = 60000)
    public void scheduleDeleteBasket() throws InterruptedException {
        System.out.println("Basket delete Schedule start " + LocalDateTime.now());
        basketService.deleteByCheckoutTimeBefore();
        System.out.println("Basket delete Schedule end " + LocalDateTime.now());
    }
}
