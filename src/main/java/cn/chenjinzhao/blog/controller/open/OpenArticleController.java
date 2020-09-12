package cn.chenjinzhao.blog.controller.open;

import cn.chenjinzhao.blog.common.api.CommonResult;
import cn.chenjinzhao.blog.common.api.ResultCode;
import cn.chenjinzhao.blog.common.utils.CommonResultUtil;
import cn.chenjinzhao.blog.exception.GlobalException;
import cn.chenjinzhao.blog.pojo.po.Article;
import cn.chenjinzhao.blog.pojo.po.Category;
import cn.chenjinzhao.blog.pojo.po.Tag;
import cn.chenjinzhao.blog.pojo.po.User;
import cn.chenjinzhao.blog.pojo.vo.ArticleVO;
import cn.chenjinzhao.blog.service.ArticleService;
import cn.chenjinzhao.blog.service.CategoryService;
import cn.chenjinzhao.blog.service.TagService;
import cn.chenjinzhao.blog.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * TODO
 *
 * @author 陈今朝
 * @date 2020/9/8 22:40
 */
@RestController
@Slf4j
@Api(tags = "OpenArticleController")
@RequestMapping("/article")
public class OpenArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @ApiOperation("获取文章列表")
    @GetMapping("/list")
    public CommonResult getArticleList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Article> page = new Page<Article>(pageNum, pageSize);
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("state", 1);
        articleService.page(page, wrapper);
        return CommonResultUtil.success(page);
    }

    @ApiOperation("获取文章")
    @GetMapping("/{id}")
    public CommonResult article(@PathVariable("id") Integer id) {
        // 获取文章
        Article article = articleService.getOpenArticleById(id);
        // 获取标签 分类
        List<Tag> tags = tagService.listByAid(article.getId());
        Category category = categoryService.getById(article.getCid());
        // 获取已启用用户
        User user = userService.getById(article.getUid());
        //查看用户启用情况
        if (!Objects.equals(user.getEnabled(),1)){
            throw new GlobalException(ResultCode.USER_IS_NOT_ENABLE);
        }
        // 创建ArticleVO
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article,articleVO);
        articleVO.setTags(tags);
        articleVO.setCategory(category);
        HashMap<String, String> userMap = new HashMap<>(3);
        userMap.put("id",user.getId().toString());
        userMap.put("email",user.getEmail());
        userMap.put("nickname",user.getNickname());
        userMap.put("avatars",user.getAvatars());
        articleVO.setUser(userMap);
        return CommonResultUtil.success(articleVO);
    }

}
