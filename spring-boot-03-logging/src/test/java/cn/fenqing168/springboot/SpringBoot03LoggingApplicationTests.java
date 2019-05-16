package cn.fenqing168.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        //由低到高 trace< debug< info < warn < error
        //可以调节输出的日志级别；日志就会在这个级别以后的高级别生效
        logger.trace("这是tracer日志...");
        logger.debug("这是debug日志...");
        //springBoot默认调节的是info级别的,没有指定别的就用SpringBoot默认规定的级别：root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");

    }

}
