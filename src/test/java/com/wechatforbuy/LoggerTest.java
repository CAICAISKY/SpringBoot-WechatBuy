package com.wechatforbuy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    @Test
    public void testLog() {
        String name = "Schuyler";
        Integer age = 26;
        log.info("name = {}, age = {}",name, age);
        log.info("name = {1,2}, age = {}", age);
        log.info("name = {1,2}, age = {{}}", age);
        log.info("name = \\{} {}", name);
        log.info("name = \\\\{}", name);
        log.error("error.......");
    }
}
