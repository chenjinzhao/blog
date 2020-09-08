package cn.chenjinzhao.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * RolePermission
 *
 * @author 陈今朝
 * @date 2020/8/18 19:33
 */
@Data
public class RolePermission {
    @TableId(value = "id",type = IdType.INPUT)
    private int id;
    private Integer rid;
    private Integer pid;
}