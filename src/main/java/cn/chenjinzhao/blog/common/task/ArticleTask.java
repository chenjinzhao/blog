package cn.chenjinzhao.blog.common.task;

import cn.chenjinzhao.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 定时任务
 *
 * @author 陈今朝
 * @date 2020/9/11 10:06
 */
@Component
@Slf4j
public class ArticleTask {
    @Autowired
    ArticleService articleService;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /**
     * 每日0时和12时同步访问量到数据库
     */
    @Scheduled(cron = "0 0 0,12 * * ?")
    public void updateViews(){
        String keyPrefix = "article::page_view::articleId:";
        Set<String> keys = redisTemplate.keys("article::page_view::articleId:" + "*");
        log.info("<---------开始同步访问量到数据库--------->");
        keys.forEach(key->{
            // 从redis中获取当前访问量
            Integer pageView = (Integer) redisTemplate.opsForValue().get(key);
            String strId = key.substring(keyPrefix.length());
            Integer id = Integer.parseInt(strId);
            log.info("文章id:{},访问量:{}",id,pageView);
            articleService.updatePageView(id,pageView);
        });
        log.info("<---------同步访问量到数据库完毕--------->");
    }
}
