package cn.chenjinzhao.blog.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO
 *
 * @author 陈今朝
 * @date 2020/8/12 20:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String nickname;
    private String password;
    private Integer enabled;
    private String avatars;
    private Date regDate;
    private Date loginTime;
}
