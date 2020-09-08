package cn.chenjinzhao.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User
 *
 * @author 陈今朝
 * @date 2020/8/12 20:27
 */
@Data
public class User {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String email;
    private String nickname;
    private String password;
    private Integer enabled;
    private String avatars;
    private Date regDate;
    private Date loginTime;
}
