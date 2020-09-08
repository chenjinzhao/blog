package cn.chenjinzhao.blog.pojo.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserRole
 *
 * @author 陈今朝
 * @date 2020/8/18 19:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private Integer uid;
    private Integer rid;
    private Date createTime;
    private Date updateTime;

    public UserRole(Integer uid, Integer rid) {
        this(null,uid,rid,new Date(),new Date());
    }
}