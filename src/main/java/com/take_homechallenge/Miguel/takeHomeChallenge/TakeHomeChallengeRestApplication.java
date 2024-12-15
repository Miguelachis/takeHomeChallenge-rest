package com.take_homechallenge.Miguel.takeHomeChallenge;

import com.take_homechallenge.Miguel.takeHomeChallenge.BackendWorker.DailyTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Configuration
@EnableScheduling
public class TakeHomeChallengeRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeHomeChallengeRestApplication.class, args);

        ApplicationContext context = SpringApplication.run(TakeHomeChallengeRestApplication.class, args);
        DailyTaskService daily = context.getBean(DailyTaskService.class);
        daily.runBackgroundTask();
    }

}
