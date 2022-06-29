package com.leeheefull.springbatch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * next를 통해서 여러 step을 사용하는 예제
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class Ex02_NextJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job nextJob() {
        return jobBuilderFactory.get("nextJob")
                .start(nextStep1())
                .next(nextStep2())
                .next(nextStep3())
                .build();
    }

    @Bean
    public Step nextStep1() {
        return stepBuilderFactory.get("nextStep1")
                .tasklet((contribution, chunkContext) -> {
                    log.info("next 사용해보기1 !!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step nextStep2() {
        return stepBuilderFactory.get("nextStep2")
                .tasklet((contribution, chunkContext) -> {
                    log.info("next 사용해보기2 !!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step nextStep3() {
        return stepBuilderFactory.get("nextStep3")
                .tasklet((contribution, chunkContext) -> {
                    log.info("next 사용해보기3 !!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}