package cn.chenjinzhao.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 陈今朝
 */
@SpringBootApplication
@EnableScheduling
public class BlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogApplication.class, args);
    }

}
