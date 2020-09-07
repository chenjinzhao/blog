package cn.chenjinzhao.blog.pojo.po;

import lombok.Data;

import java.util.Date;

/**
 * TODO
 *
 * @author 陈今朝
 * @date 2020/8/12 20:27
 */

@Data
public class Article {
    private int id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private Integer state;
    private Integer pageView;
    private Integer star;
    private Integer cid;
    private Integer uid;
    private Date createTime;
    private Date updateTime;
}
