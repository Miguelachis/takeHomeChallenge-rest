package com.take_homechallenge.Miguel.takeHomeChallenge.BackendWorker;

import com.take_homechallenge.Miguel.takeHomeChallenge.service.AccreditationService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Service

public class DailyTaskService {

    @Value("${app.setting.numberOfDaysToExpier}")
    private int number;

    AccreditationService accreditationService;

    DailyTaskService(AccreditationService accreditationService) {
        this.accreditationService = accreditationService;
    }


    @Async
    @Scheduled(fixedRate = 5000) // This can be changed. But for testing i made it every 5 seconds.
    public void runBackgroundTask() {
        try {
            System.out.println("Background task started...");
            // Simulate long-running task (e.g., processing, computation)
            accreditationService.setExpiredAllExpiredAccreditation(LocalDateTime.now().minusDays(number));
            System.out.println("Background task completed.");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println("Background task was interrupted.");
        }
    }
}