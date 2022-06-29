package com.leeheefull.springbatch.job;

import com.leeheefull.springbatch.component.ScopeTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class Ex04_ScopeJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ScopeTasklet scopeTasklet;

    @Bean
    public Job scopeJob() {
        return jobBuilderFactory.get("scopeJob")
                .start(scopeStep())
                .build();
    }

    @Bean
    @JobScope
    public Step scopeStep() {
        return stepBuilderFactory.get("scopeStep")
                .tasklet(scopeTasklet)
                .build();
    }

    /**
     * ScopeTasklet으로 분리
     */
//    @Bean
//    @StepScope
//    public Tasklet scopeTasklet(@Value("#{jobParameters[requestDate]}") String requestDate) {
//        return (contribution, chunkContext) -> {
//            log.info("scope 사용해보기!! -> {}", requestDate);
//            return RepeatStatus.FINISHED;
//        };
//    }
}