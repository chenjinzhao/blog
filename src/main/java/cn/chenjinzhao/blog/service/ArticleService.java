package cn.chenjinzhao.blog.service;

import cn.chenjinzhao.blog.pojo.po.Article;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * ArticleService
 *
 * @author 陈今朝
 * @date 2020/9/10 16:40
 */
public interface ArticleService extends IService<Article> {
    /**
     * 根据id获取已发布文章
     *
     * @param id 文章id
     * @return 文章
     */
    Article getOpenArticleById(Integer id);

    /**
     * 更新访问量
     *
     * @param id 文章id
     * @param pageView 访问量
     */
    void updatePageView(Integer id, Integer pageView);
}
