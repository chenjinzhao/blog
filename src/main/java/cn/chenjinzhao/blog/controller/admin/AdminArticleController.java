package cn.chenjinzhao.blog.controller.admin;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员操作文章
 *
 * @author 陈今朝
 * @date 2020/9/12 9:39
 */
@RestController
@Slf4j
@Api(tags = "AdminArticleController")
@RequestMapping("/admin/article")
public class AdminArticleController {
}
