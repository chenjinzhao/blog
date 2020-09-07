package cn.chenjinzhao.blog.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO
 *
 * @author 陈今朝
 * @date 2020/8/18 19:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Integer id;
    private Integer uid;
    private Integer rid;
    private Date createTime;
    private Date updateTime;

    public UserRole(Integer uid, Integer rid) {
        this(null,uid,rid,new Date(),new Date());
    }
}