package com.leeheefull.springbatch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 각 step을 conditional하게 사용하는 예제
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class Ex03_FlowJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job flowJob() {
        return jobBuilderFactory.get("flowJob")
                .start(flowStep1())
                .on("FAILED")   // FAILED 일 경우
                .to(flowStep3())        // step3으로 이동한다.
                .on("*")        // step3의 결과 관계 없이
                .end()                  // step3으로 이동하면 Flow가 종료한다.
                .from(flowStep1())          // step1로부터
                .on("*")        // FAILED 외에 모든 경우
                .to(flowStep2())        // step2로 이동한다.
                .next(flowStep3())      // step2가 정상 종료되면 step3으로 이동한다.
                .on("*")        // step3의 결과 관계 없이
                .end()                  // step3으로 이동하면 Flow가 종료한다.
                .end()                      // Job 종료
                .build();
    }

    @Bean
    public Step flowStep1() {
        return stepBuilderFactory.get("flowStep1")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Flow 사용해보기1 !! -> 실패");
                    contribution.setExitStatus(ExitStatus.FAILED);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step flowStep2() {
        return stepBuilderFactory.get("flowStep2")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Flow 사용해보기2 !! -> 성공");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step flowStep3() {
        return stepBuilderFactory.get("flowStep3")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Flow 사용해보기3 !! -> 성공");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}