package cn.chenjinzhao.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * ArticleTag
 *
 * @author 陈今朝
 * @date 2020/8/12 20:27
 */
@Data
public class ArticleTag implements Serializable {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private Integer aid;
    private Integer tid;
}
