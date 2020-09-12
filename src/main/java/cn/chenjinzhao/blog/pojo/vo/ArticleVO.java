package cn.chenjinzhao.blog.pojo.vo;

import cn.chenjinzhao.blog.pojo.po.Category;
import cn.chenjinzhao.blog.pojo.po.Tag;
import cn.chenjinzhao.blog.pojo.po.User;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ArticleVO
 *
 * @author 陈今朝
 * @date 2020/9/11 16:14
 */
@Data
public class ArticleVO {
    private Integer id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private Integer state;
    private Integer pageView;
    private Integer star;
    private List<Tag> tags;
    private Category category;
    private Map<String,String> user;
    private Date createTime;
    private Date updateTime;
}
