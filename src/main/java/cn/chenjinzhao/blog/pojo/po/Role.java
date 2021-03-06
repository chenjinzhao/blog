package cn.chenjinzhao.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;


/**
 * Role
 *
 * @author 陈今朝
 * @date 2020/8/18 19:33
 */
@Data
public class Role  implements Serializable {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String roleName;
    private String description;

}
