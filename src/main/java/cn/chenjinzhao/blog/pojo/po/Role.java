package cn.chenjinzhao.blog.pojo.po;

import lombok.Data;

import javax.persistence.*;

/**
 * TODO
 *
 * @author 陈今朝
 * @date 2020/8/18 19:33
 */
@Entity
@Data
public class Role {
    @Id
    private int id;
    private String roleName;
    private String description;

}
