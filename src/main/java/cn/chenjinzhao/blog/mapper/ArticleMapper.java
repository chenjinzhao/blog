package cn.chenjinzhao.blog.mapper;

import cn.chenjinzhao.blog.pojo.po.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ArticleMapper
 *
 * @author 陈今朝
 * @date 2020/9/10 16:41
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 更新文章访问量
     * @param id 文章id
     * @param pageView 访问量
     */
    void updatePageView(@Param("id") Integer id, @Param("page_view") Integer pageView);
}
