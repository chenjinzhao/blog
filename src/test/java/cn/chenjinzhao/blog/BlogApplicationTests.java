package cn.chenjinzhao.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    /**
     * 私钥
     */
    @Value("${jwt.secret}")
    private static String secret;
    @Test
    void contextLoads() {
        System.out.println(secret);
    }

}
