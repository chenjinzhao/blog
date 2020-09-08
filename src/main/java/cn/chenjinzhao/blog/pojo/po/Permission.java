package cn.chenjinzhao.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 陈今朝
 * @date 2020/8/12 20:27
 */
@Data
public class Permission {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String permissionName;
}
