package cn.chenjinzhao.blog.service.impl;

import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.exception.GlobalException;
import cn.chenjinzhao.blog.mapper.ArticleMapper;
import cn.chenjinzhao.blog.pojo.po.Article;
import cn.chenjinzhao.blog.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * ArticleServiceImpl
 *
 * @author 陈今朝
 * @date 2020/9/10 16:41
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public Article getOpenArticleById(Integer id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<Article>();
        wrapper.eq("id", id)
                .eq("state", 1);
        Article article = baseMapper.selectOne(wrapper);
        String key = "article::page_view::articleId:" + id;
        if (article != null) {
            // 从redis中获取当前访问量
            Integer pageView = (Integer) redisTemplate.opsForValue().get(key);
            // 从redis中无访问量
            if (pageView == null) {
                // 获取文章访问量
                pageView = article.getPageView();
            }
            // 访问量++
            pageView++;
            // 缓存访问量 缓存时间25小时
            redisTemplate.opsForValue().set(key, pageView, 25, TimeUnit.HOURS);
            article.setPageView(pageView);
        } else {
            throw new GlobalException(ResultCode.ARTICLE_NOT_FOUND);
        }
        return article;
    }

    @Override
    public void updatePageView(Integer id, Integer pageView) {
        baseMapper.updatePageView(id, pageView);
    }
}
