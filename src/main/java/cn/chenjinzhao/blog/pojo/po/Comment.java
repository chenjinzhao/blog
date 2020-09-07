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
public class Comment {
    private int id;
    private Integer aid;
    private String content;
    private Integer parentId;
    private Integer uid;
    private Integer state;
    private Date createTime;
}