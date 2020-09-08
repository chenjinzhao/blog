package cn.chenjinzhao.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 陈今朝
 */
@SpringBootApplication
@EnableOpenApi
@MapperScan("cn.chenjinzhao.blog.mapper")
public class BlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogApplication.class, args);
    }

}
