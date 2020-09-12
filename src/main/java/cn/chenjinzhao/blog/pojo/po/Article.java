package cn.chenjinzhao.blog.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Article
 *
 * @author 陈今朝
 * @date 2020/8/12 20:27
 */

@Data
public class Article  implements Serializable {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private Integer state;
    private Integer pageView;
    private Integer star;
    private Integer cid;
    private Integer uid;
    private Date createTime;
    private Date updateTime;
}
